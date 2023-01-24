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

    /**
     * 查询所有书籍
     *
     * @return java.util.List<com.zihuv.managebooks.entity.Book>
     */
    List<Book> listBook();
}