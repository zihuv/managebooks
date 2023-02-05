package com.zihuv.managebooks.service;

import com.zihuv.managebooks.entity.BorrowBook;
import com.zihuv.managebooks.vo.BorrowBookVO;

import java.util.List;

public interface BorrowBookService {
    void insertBorrowBook(BorrowBook borrowBook);

    void deleteBorrowBook(Integer userId,Integer bookId);

    List<BorrowBookVO> listBorrowBook(Integer userId,Integer pageNum, Integer pageSize);

    List<BorrowBookVO> listAllBorrowBook(Integer pageNum,Integer pageSize);
}
