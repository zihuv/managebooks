package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.vo.BookCategoryAmountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 书籍类别管理
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@Mapper
public interface BookCategoryDao {
    /**
     * 添加书籍类别
     *
     * @param categoryName 书籍类型名称
     * @return int
     */
    int insertCategory(String categoryName);

    /**
     * 查询书籍类别名称
     *
     * @param categoryName 书籍类型名称
     * @return java.lang.String
     */
    BookCategory getCategoryByCategoryName(String categoryName);

    /**
     * 根据id删除书籍类别
     *
     * @param id 书籍类别id
     * @return int
     */
    int deleteCategoryById(Integer id);

    /**
     * 根据id查询书籍类别
     *
     * @param id 书籍类别id
     * @return int
     */
    BookCategory getCategoryById(Integer id);

    /**
     * 查询所有书籍类别
     *
     * @return java.util.List<com.zihuv.managebooks.entity.BookCategory>
     */
    List<BookCategory> listCategory();

    /**
     * 查询所有类别有多少本书
     *
     * @return java.util.List<com.zihuv.managebooks.vo.BookCategoryAmountVO>
     */
    List<BookCategoryAmountVO> listCategoryAmount();
}