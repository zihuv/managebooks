package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.OperationLog;

import java.util.List;

public interface OperationLogService {
    /**
     * 查询所有日志
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.entity.OperationLog>
     */
    List<OperationLog> listOperationLog(Integer pageNum,Integer pageSize);

    /**
     * 根据id删除日志
     *
     * @param ids 所要删除的日志id集合
     */
    void deleteOperationLog(List<Integer> ids);
}
