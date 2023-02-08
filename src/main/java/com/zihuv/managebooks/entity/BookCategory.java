package com.zihuv.managebooks.entity;

import lombok.Data;

/**
 * 书籍类别
 *
 * @author: zihuv
 * @date: 2023/1/21
 */
@Data
public class BookCategory {
    /**
     * 书籍类别id
     */
    private Integer id;

    /**
     * 书籍类别名称
     */
    private String categoryName;
}