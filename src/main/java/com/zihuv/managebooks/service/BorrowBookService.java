package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.BorrowBook;
import com.zihuv.managebooks.vo.BorrowBookVO;

import java.util.List;

public interface BorrowBookService {
    /**
     * 添加书籍
     *
     * @param borrowBook 借书信息
     */
    void insertBorrowBook(BorrowBook borrowBook);

    /**
     * 删除书籍
     *
     * @param userId 用户id
     * @param bookId 书籍id
     */
    void deleteBorrowBook(Integer userId,Integer bookId);

    /**
     * 查询用户个人的借书记录
     *
     * @param userId 用户id
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.vo.BorrowBookVO>
     */
    List<BorrowBookVO> listBorrowBookByUserId(Integer userId,Integer pageNum, Integer pageSize);

    /**
     * 查询所有人历史借阅记录
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return java.util.List<com.zihuv.managebooks.vo.BorrowBookVO>
     */
    List<BorrowBookVO> listAllBorrowBook(Integer pageNum,Integer pageSize);
}
