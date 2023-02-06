package com.zihuv.managebooks.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zihuv.managebooks.annotation.OptLog;
import com.zihuv.managebooks.constant.IdentityConst;
import com.zihuv.managebooks.dao.OperationLogDao;
import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.OperationLog;
import com.zihuv.managebooks.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 操作日志切面
 *
 * @author: zihuv
 * @date: 2023/2/5
 */
@Slf4j
@Aspect
@Component
public class OperationLogAspect {
    @Autowired
    private OperationLogDao operationLogDao;
    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.zihuv.managebooks.annotation.OptLog)")
    public void method() {}

    @Around("method()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取日志创建时间
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dateTimeFormatter.format(localDateTime);
        //执行原始方法
        Object result = joinPoint.proceed();
        //封装log，并存进数据库
        saveLog(joinPoint,date);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, String date) throws JsonProcessingException {
        OperationLog operationLog = new OperationLog();
        //获取操作者名称
        Object object = request.getSession().getAttribute(IdentityConst.LOGIN_INFO);
        String username = null;
        if (object instanceof User user) {
            username = user.getUserName();
        } else if(object instanceof Admin admin) {
            username = admin.getAdminName();
        }
        // String username = (String) request.getSession().getAttribute("user");
        operationLog.setUsername(username);
        //获取操作描述（通过反射）
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        OptLog logAnnotation = method.getAnnotation(OptLog.class);
        String description = logAnnotation.value();
        operationLog.setDescription(description);
        //获取类名
        String className = joinPoint.getTarget().getClass().getName();
        operationLog.setClassName(className);
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        operationLog.setMethodName(methodName);
        //获取路径uri
        String uri = request.getRequestURI();
        operationLog.setUri(uri);
        //获取请求参数(Object数组 -> JSON串)
        Object[] args = joinPoint.getArgs();
        ObjectMapper objectMapper = new ObjectMapper();
        String paramJSON = objectMapper.writeValueAsString(args);
        operationLog.setParams(paramJSON);
        //记录日志创建时间
        operationLog.setCreateDate(date);

        //将数据写入数据库
        operationLogDao.insertOperationLog(operationLog);
    }
}