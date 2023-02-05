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
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String borrowDate;
}