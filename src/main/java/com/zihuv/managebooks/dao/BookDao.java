package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

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
     * 添加书籍
     *
     * @param book 书籍对象
     * @return int
     */
    int insertBook(Book book);

    /**
     * 根据id查询书籍
     *
     * @param id 书籍id
     * @return com.zihuv.managebooks.entity.Book
     */
    Book getBookById(Integer id);

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
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<Book> listBook();

    /**
     * 根据书名查询书籍
     *
     * @param bookName 书籍名称
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<Book> listBookByBookName(String bookName);

    List<Book> listBookByCategory(String categoryName);
}