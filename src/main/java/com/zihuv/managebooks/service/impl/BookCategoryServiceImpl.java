package com.zihuv.managebooks.service.impl;

import com.zihuv.managebooks.dao.BookCategoryDao;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zihuv
 * @date: 2023/1/23
 */
@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public void insertCategory(String categoryName) {
        String result = bookCategoryDao.getCategoryByCategoryName(categoryName);
        //判断所添加的类别是否已经存在，若存在，无法添加，result!=null，抛出异常
        if (result != null) {
            throw new BizException(BookStatusEnums.CATEGORY_IS_EXIST);
        }
        bookCategoryDao.insertCategory(categoryName);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        int result = bookCategoryDao.getCategoryById(id);
        //判断所删除的类别是否已经存在，若不存在，无法删除，result==0，抛出异常
        if (result == 0) {
            throw new BizException(BookStatusEnums.CATEGORY_NOT_EXIST);
        }
        bookCategoryDao.deleteCategoryById(id);
    }
}