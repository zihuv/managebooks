package com.zihuv.managebooks.entity;

import lombok.Data;

/**
 * @author: zihuv
 * @date: 2023/1/21
 */
@Data
public class Book {
    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String bookPublish;
    private Integer bookCategory;
    private Integer bookPrize;
    private String bookIntroduction;
}