package com.zihuv.managebooks.service.impl;

import com.zihuv.managebooks.dao.BookDao;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zihuv
 * @date: 2023/1/21
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public int insertCategory(String categoryName) {
        return bookDao.insertCategory(categoryName);
    }

    @Override
    public int deleteCategoryById(Integer id) {
        return bookDao.deleteCategoryById(id);
    }

    @Override
    public int insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public List<Book> listBook() {
        return bookDao.listBook();
    }
}