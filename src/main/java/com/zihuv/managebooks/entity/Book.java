package com.zihuv.managebooks.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 书籍
 *
 * @author: zihuv
 * @date: 2023/1/21
 */
@Data
public class Book {
    /**
     * 书籍id
     */
    @JsonIgnore
    private Integer id;

    /**
     * 书籍名称
     */
    @ExcelProperty(value = "书籍名称")
    private String bookName;

    /**
     * 书籍作者
     */
    @ExcelProperty(value = "书籍作者")
    private String bookAuthor;

    /**
     * 书籍出版社
     */
    @ExcelProperty(value = "书籍出版社")
    private String bookPublish;

    /**
     * 书籍类别
     */
    @ExcelProperty(value = "书籍类别")
    private Integer bookCategory;

    /**
     * 书籍价格
     */
    @ExcelProperty(value = "书籍价格")
    private Double bookPrize;

    /**
     * 书籍介绍
     */
    @ExcelProperty(value = "书籍介绍")
    private String bookIntroduction;
}