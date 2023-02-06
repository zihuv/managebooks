package com.zihuv.managebooks.entity;

import lombok.Data;

/**
 * @author: zihuv
 * @date: 2023/2/5
 */
@Data
public class OperationLog {
    /**
     * 日志id
     */
    private Integer id;

    /**
     * 操作者的用户名
     */
    private String username;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作类名
     */
    private String className;

    /**
     * 操作方法名
     */
    private String methodName;

    /**
     * 操作路径
     */
    private String uri;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 日志创建日期
     */
    private String createDate;
}