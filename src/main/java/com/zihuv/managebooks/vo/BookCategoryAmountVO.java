package com.zihuv.managebooks.vo;

import lombok.Data;

/**
 * 书籍类别数量VO
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@Data
public class BookCategoryAmountVO {
    /**
     * 书籍类别id
     */
    private Integer id;

    /**
     * 书籍类别名称
     */
    private String categoryName;

    /**
     * 该书籍的数量
     */
    private Integer amount;
}