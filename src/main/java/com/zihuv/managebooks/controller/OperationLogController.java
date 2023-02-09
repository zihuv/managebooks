package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.OperationLog;
import com.zihuv.managebooks.service.OperationLogService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 操作日志管理
 *
 * @author: zihuv
 * @date: 2023/2/5
 */
@RestController
public class OperationLogController {
    @Autowired
    private OperationLogService operationLogService;

    /**
     * 查询所有日志
     *
     * @param pageNum  页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.entity.OperationLog>>
     */
    @GetMapping("/log")
    public Result<List<OperationLog>> listOperationLog(@RequestParam Integer pageNum,
                                                       @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum, pageSize);
        List<OperationLog> operationLogs = operationLogService.listOperationLog(pageNum, pageSize);
        return Result.success(operationLogs);
    }

    /**
     * 根据id集合删除日志
     *
     * @param ids 所要删除的日志id集合
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @DeleteMapping("/log")
    public Result<?> deleteOperationLog(@RequestBody List<Integer> ids) {
        operationLogService.deleteOperationLog(ids);
        return Result.success();
    }

    /**
     * 查询开始时间与截止时间查询日志
     *
     * @param beginTime 开始时间
     * @param endTime   截止时间
     * @param pageNum   页码
     * @param pageSize  显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List<com.zihuv.managebooks.entity.OperationLog>>
     */
    @GetMapping("/log/time")
    public Result<List<OperationLog>> listOperationLogByDateTime(@RequestParam String beginTime,
                                                                 @RequestParam String endTime,
                                                                 @RequestParam Integer pageNum,
                                                                 @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum, pageSize);
        //判断endTime是否>beginTime 若小于 则将这两变量交换数据
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime begin = LocalDateTime.parse(beginTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);
        if (begin.isAfter(end)) {
            String temp = beginTime;
            beginTime = endTime;
            endTime = temp;
        }
        List<OperationLog> operationLogs =
                operationLogService.listOperationLogByDateTime(beginTime, endTime, pageNum, pageSize);
        return Result.success(operationLogs);
    }
}