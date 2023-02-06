package com.zihuv.managebooks.service;


import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.vo.BookVO;

import java.util.List;

public interface BookService {
    /**
     * 添加书籍
     *
     * @param book 书籍信息
     */
    void insertBook(Book book);

    /**
     * 根据id删除书籍
     *
     * @param id 书籍id
     */
    void deleteBookById(Integer id);

    /**
     * 修改书籍信息
     *
     * @param book 书籍信息
     */
    void updateBook(Book book);

    /**
     * 查询所有书籍
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<BookVO> listBook(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询书籍
     *
     * @param id 书籍id
     * @return com.zihuv.managebooks.entity.Book
     */
    BookVO getBookById(Integer id);

    /**
     * 根据书名查询书籍
     *
     * @param bookName 书籍名称
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<BookVO> listBookByBookName(String bookName,Integer pageNum, Integer pageSize);

    /**
     * 根据书籍类别查询书籍
     *
     * @param categoryName 书籍类别名称
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<BookVO> listBookByCategory(String categoryName,Integer pageNum, Integer pageSize);
}