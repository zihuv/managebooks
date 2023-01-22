package com.zihuv.managebooks.service;


import com.zihuv.managebooks.entity.Book;

import java.util.List;

/**
 * 书籍管理
 *
 * @author: zihuv
 * @date: 2023/1/20
 */

public interface BookService {
    /**
     * 添加书籍类别
     *
     * @param categoryName 书籍类型名称
     */
    void insertCategory(String categoryName);

    /**
     * 根据id删除书籍类别
     *
     * @param id 书籍类别的id
     */
    void deleteCategoryById(Integer id);

    /**
     * 添加书籍
     *
     * @param book 书籍对象
     */
    void insertBook(Book book);

    /**
     * 根据id删除书籍
     *
     * @param id 书籍id
     */
    void deleteBookById(Integer id);

    /**
     * 修改书籍信息
     *
     * @param book 书籍对象
     */
    void updateBook(Book book);

    List<Book> listBook();
}