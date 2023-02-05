package com.zihuv.managebooks.service.impl;

import com.github.pagehelper.PageHelper;
import com.zihuv.managebooks.dao.BookCategoryDao;
import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BookCategoryService;
import com.zihuv.managebooks.vo.BookCategoryAmountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        //去除字符串中的空格（首尾和字符串中间的空格）
        categoryName = categoryName.replace(" ", "");
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

    @Override
    public List<BookCategory> listCategory(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return bookCategoryDao.listCategory();
    }

    @Override
    public List<BookCategoryAmountVO> listCategoryAmount(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return bookCategoryDao.listCategoryAmount();
    }
}