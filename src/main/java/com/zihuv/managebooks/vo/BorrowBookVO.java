package com.zihuv.managebooks.vo;

import lombok.Data;

/**
 * 借书记录VO
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@Data
public class BorrowBookVO {
    /**
     * 借阅者用户名
     */
    private String userName;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 借阅日期
     */
    private String borrowDate;

    /**
     * 书籍归还日期
     */
    private String returnDate;
}