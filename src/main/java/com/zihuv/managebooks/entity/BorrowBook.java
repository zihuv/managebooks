package com.zihuv.managebooks.entity;

import lombok.Data;

/**
 * 借书记录
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@Data
public class BorrowBook {
    /**
     * 借书记录id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 书籍id
     */
    private Integer bookId;

    /**
     * 借书日期
     */
    private String borrowDate;
}