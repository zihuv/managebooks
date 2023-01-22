package com.zihuv.managebooks.service.impl;

import com.zihuv.managebooks.dao.BookDao;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.exception.BizException;
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
    public void insertCategory(String categoryName) {
        String result = bookDao.getCategoryByCategoryName(categoryName);
        //判断所添加的类别是否已经存在，若存在，无法添加，result!=null，抛出异常
        if (result != null) {
            throw new BizException(BookStatusEnums.CATEGORY_IS_EXIST);
        }
        bookDao.insertCategory(categoryName);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        int result = bookDao.getCategoryById(id);
        //判断所删除的类别是否已经存在，若不存在，无法删除，result==0，抛出异常
        if (result == 0) {
            throw new BizException(BookStatusEnums.CATEGORY_NOT_EXIST);
        }
        bookDao.deleteCategoryById(id);
    }

    @Override
    public void insertBook(Book book) {
        bookDao.insertBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        int result = bookDao.getBookById(id);
        //判断所删除的书籍是否已经存在，若不存在，无法删除，result==0，抛出异常
        if (result == 0) {
            throw new BizException(BookStatusEnums.BOOK_NOT_EXIST);
        }
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        int result = bookDao.getBookById(book.getId());
        //判断所修改的书籍是否已经存在，若不存在，无法修改，result==0，抛出异常
        if (result == 0) {
            throw new BizException(BookStatusEnums.BOOK_NOT_EXIST);
        }
        bookDao.updateBook(book);
    }

    @Override
    public List<Book> listBook() {
        return bookDao.listBook();
    }
}