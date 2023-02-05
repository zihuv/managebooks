package com.zihuv.managebooks.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 有关书籍与书籍类别异常信息的枚举类
 *
 * @author: zihuv
 * @date: 2023/1/22
 */
@Getter
@AllArgsConstructor
public enum BookStatusEnums {
    CATEGORY_IS_EXIST(30000,"该书籍类别已经存在"),
    CATEGORY_NOT_EXIST(30001,"该书籍类别不存在"),
    BOOK_NOT_EXIST(40000,"该书籍不存在"),
    BOOK_IS_BORROWED(60000,"该书籍已经被借出"),
    USER_NOT_BORROW(60001,"该用户没有借该书");

    private Integer code;
    private String message;
}
