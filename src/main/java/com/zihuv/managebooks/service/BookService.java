package com.zihuv.managebooks.service;


import com.zihuv.managebooks.entity.Book;

import java.util.List;

/**
 * @author: zihuv
 * @date: 2023/1/20
 */

public interface BookService {
    /**
     * 添加书籍类别
     *
     * @param categoryName
     * @return boolean
     */
    int insertCategory(String categoryName);

    /**
     * 根据id删除书籍类别
     *
     * @param id
     * @return boolean
     */
    int deleteCategoryById(Integer id);

    /**
     * 添加书籍
     *
     * @param book
     * @return int
     */
    int insertBook(Book book);

    /**
     * 根据id删除书籍
     *
     * @param id
     * @return int
     */
    int deleteBookById(Integer id);

    /**
     * 修改书籍信息（没提交的词段不修改数据）
     *
     * @param book
     * @return int
     */
    int updateBook(Book book);

    List<Book> listBook();
}