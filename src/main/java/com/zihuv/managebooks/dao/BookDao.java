package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 书籍管理
 *
 * @author: zihuv
 * @date: 2023/1/21
 */
@Mapper
public interface BookDao {
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
    String getCategoryByCategoryName(String categoryName);

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
    int getCategoryById(Integer id);

    /**
     * 添加书籍
     *
     * @param book 书籍对象
     * @return int
     */
    int insertBook(Book book);

    /**
     * 根据id获取书籍id
     *
     * @param id 书籍id
     * @return int
     */
    int getBookById(Integer id);

    /**
     * 根据id删除书籍
     *
     * @param id 书籍id
     * @return int
     */
    int deleteBookById(Integer id);

    /**
     * 修改书籍信息
     *
     * @param book 书籍对象
     * @return int
     */
    int updateBook(Book book);

    /**
     * 获取所有书籍信息
     *
     * @return java.util.List<com.zihuv.managebooks.entity.Book>
     */
    List<Book> listBook();


}