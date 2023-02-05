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
    private Integer id;
    private String categoryName;
    private Integer amount;
}