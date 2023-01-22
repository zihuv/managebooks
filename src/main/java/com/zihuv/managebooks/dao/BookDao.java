package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: zihuv
 * @date: 2023/1/21
 */
@Mapper
public interface BookDao {
    int insertCategory(String categoryName);

    int deleteCategoryById(Integer id);

    int insertBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    List<Book> listBook();
}