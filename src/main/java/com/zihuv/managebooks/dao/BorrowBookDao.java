package com.zihuv.managebooks.dao;

import com.zihuv.managebooks.entity.BorrowBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 借书管理
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@Mapper
public interface BorrowBookDao {
    /**
     * 添加借书记录
     *
     * @param borrowBook 借书信息
     * @return int
     */
    int insertBorrowBook(BorrowBook borrowBook);

    /**
     * 删除借书记录
     *
     * @param userId 用户id
     * @param bookId 书籍id
     * @return int
     */
    int deleteBorrowBook(Integer userId,Integer bookId);

    /**
     * 根据书籍id查询借书记录
     *
     * @param bookId 书籍id
     * @return com.zihuv.managebooks.entity.BorrowBook
     */
    BorrowBook getBorrowBookByBookId(Integer bookId);

    /**
     * 根据用户id查询借书记录
     *
     * @param userId 用户id
     * @return java.util.List<com.zihuv.managebooks.entity.BorrowBook>
     */
    List<BorrowBook> listBorrowBookByUserId(Integer userId);

    /**
     * 查询所有借书记录
     *
     * @return java.util.List<com.zihuv.managebooks.vo.BorrowBookVO>
     */
    List<BorrowBook> listAllBorrowBook();
}