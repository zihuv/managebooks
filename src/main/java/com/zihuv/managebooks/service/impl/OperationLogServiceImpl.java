package com.zihuv.managebooks.service.impl;

import com.github.pagehelper.PageHelper;
import com.zihuv.managebooks.dao.OperationLogDao;
import com.zihuv.managebooks.entity.OperationLog;
import com.zihuv.managebooks.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志管理
 *
 * @author: zihuv
 * @date: 2023/2/5
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogDao operationLogDao;

    @Override
    public List<OperationLog> listOperationLog(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return operationLogDao.listOperationLog();
    }

    @Override
    public void deleteOperationLog(List<Integer> ids) {
        operationLogDao.deleteOperationLog(ids);
    }
}