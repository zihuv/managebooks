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
    private String userName;
    private String bookName;
    private String borrowDate;
    private String returnDate;
}