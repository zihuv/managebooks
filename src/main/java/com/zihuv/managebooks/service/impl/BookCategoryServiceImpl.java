package com.zihuv.managebooks.service.impl;

import com.github.pagehelper.PageHelper;
import com.zihuv.managebooks.dao.BookCategoryDao;
import com.zihuv.managebooks.dao.BookDao;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BookCategoryService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.BookCategoryAmountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书籍类别管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public void insertCategory(String categoryName) {
        //判断书籍类别名称是否为空
        CommonUtils.checkParamIsNull(categoryName);
        //去除字符串中的空格（首尾和字符串中间的空格）
        categoryName = categoryName.replace(" ", "");
        BookCategory category = bookCategoryDao.getCategoryByCategoryName(categoryName);
        //判断所添加的类别是否已经存在，若存在，无法添加
        if (category != null) {
            throw new BizException(BookStatusEnums.CATEGORY_IS_EXIST);
        }
        bookCategoryDao.insertCategory(categoryName);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        BookCategory category = bookCategoryDao.getCategoryById(id);
        //判断所删除的类别是否存在，若不存在，无法删除
        if (category == null) {
            throw new BizException(BookStatusEnums.CATEGORY_NOT_EXIST);
        }
        //判断该书籍类别是否在book表当中正在被使用
        //若该书籍类别已经被使用不允许直接删除该书籍类别
        List<Book> books = bookDao.listBookByCategoryId(id);
        if (!books.isEmpty()) {
            throw new BizException(BookStatusEnums.CATEGORY_IS_USED);
        }
        //删除书籍类别
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