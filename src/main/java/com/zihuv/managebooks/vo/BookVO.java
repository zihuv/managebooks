package com.zihuv.managebooks.vo;

import lombok.Data;

/**
 * 书籍VO
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@Data
public class BookVO {
    /**
     * 书籍id
     */
    private Integer id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书籍作者
     */
    private String bookAuthor;

    /**
     * 书籍出版社
     */
    private String bookPublish;

    /**
     * 借阅状态
     */
    private String state;
}