package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.OperationLog;
import com.zihuv.managebooks.service.OperationLogService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @GetMapping("/log")
    public Result<?> listOperationLog(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
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
}