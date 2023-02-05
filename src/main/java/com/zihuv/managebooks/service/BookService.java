package com.zihuv.managebooks.service;


import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.vo.BookVO;

import java.util.List;

/**
 * 书籍管理
 *
 * @author: zihuv
 * @date: 2023/1/20
 */

public interface BookService {
    /**
     * 添加书籍
     *
     * @param book 书籍对象
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
     * @param book 书籍对象
     */
    void updateBook(Book book);

    /**
     * 查询所有书籍
     *
     * @param pageNum
     * @param pageSize
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<BookVO> listBook(Integer pageNum, Integer pageSize);

    /**
     * 根据id查询书籍
     *
     * @param id
     * @return com.zihuv.managebooks.entity.Book
     */
    BookVO getBookById(Integer id);

    /**
     * 根据书名查询书籍
     *
     * @param bookName
     * @return java.util.List<com.zihuv.managebooks.vo.BookVO>
     */
    List<BookVO> listBookByBookName(String bookName,Integer pageNum, Integer pageSize);

    List<BookVO> listBookByCategory(String categoryName,Integer pageNum, Integer pageSize);
}