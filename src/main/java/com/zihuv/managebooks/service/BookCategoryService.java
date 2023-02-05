package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.vo.BookCategoryAmountVO;

import java.util.List;
import java.util.Map;

public interface BookCategoryService {
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
     * 查询所有书籍类别
     *
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.zihuv.managebooks.entity.BookCategory>
     */
    List<BookCategory> listCategory(Integer pageNum, Integer pageSize);

    /**
     * 查询所有类别有多少本书
     *
     * @return java.util.List<com.zihuv.managebooks.vo.BookCategoryAmountVO>
     */
    List<BookCategoryAmountVO> listCategoryAmount(Integer pageNum, Integer pageSize);
}
