package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作日志
 *
 * @author: zihuv
 * @date: 2023/2/5
 */
@Mapper
public interface OperationLogDao {
    /**
     * 添加日志
     *
     * @param operationLog 日志信息
     * @return int
     */
    int insertOperationLog(OperationLog operationLog);

    /**
     * 查询所有日志
     *
     * @return java.util.List<com.zihuv.managebooks.entity.OperationLog>
     */
    List<OperationLog> listOperationLog();

    /**
     * 根据id删除日志
     *
     * @param ids 所要删除的日志id集合
     * @return int
     */
    int deleteOperationLog(List<Integer> ids);
}