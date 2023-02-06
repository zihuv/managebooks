package com.zihuv.managebooks.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zihuv.managebooks.dao.BookDao;
import com.zihuv.managebooks.dao.BorrowBookDao;
import com.zihuv.managebooks.dao.UserDao;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.entity.BorrowBook;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BorrowBookService;
import com.zihuv.managebooks.vo.BorrowBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 借书管理
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@Service
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    private BorrowBookDao borrowBookDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void insertBorrowBook(BorrowBook borrowBook) {
        Integer bookId = borrowBook.getBookId();
        //查询数据库，再次判断书籍是否已经被借出
        BorrowBook bk1 = borrowBookDao.getBorrowBookByBookId(bookId);
        if (bk1 != null) {
            throw new BizException(BookStatusEnums.BOOK_IS_BORROWED);
        }
        //查询bookId是否在book表中存在
        Book bk2 = bookDao.getBookById(bookId);
        if (bk2 == null) {
            throw new BizException(BookStatusEnums.BOOK_NOT_EXIST);
        }
        //添加进借书表中
        borrowBookDao.insertBorrowBook(borrowBook);
    }

    @Override
    public void deleteBorrowBook(Integer userId, Integer bookId) {
        //查询数据库，判断该书籍是否真的被该用户借了
        BorrowBook bk = borrowBookDao.getBorrowBookByBookId(bookId);
        List<BorrowBook> books = borrowBookDao.listBorrowBookByUserId(userId);
        if (bk == null || books == null) {
            throw new BizException(BookStatusEnums.USER_NOT_BORROW);
        }
        boolean flag = true;
        for (BorrowBook book : books) {
            if (book.getBookId().equals(bk.getBookId())) {
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new BizException(BookStatusEnums.USER_NOT_BORROW);
        }
        //将借阅信息删除
        borrowBookDao.deleteBorrowBook(userId, bookId);
    }

    @Override
    public List<BorrowBookVO> listBorrowBookByUserId(Integer userId,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return borrowBookDao.listBorrowBookByUserId(userId)
                .stream()
                .map(this::borrowBookToVO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BorrowBookVO> listAllBorrowBook(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //BorrowBook转成BorrowBookVO集合
        return borrowBookDao.listAllBorrowBook()
                .stream()
                .map(this::borrowBookToVO)
                .collect(Collectors.toList());
    }



    //BorrowBook转成BorrowBookVO
    private BorrowBookVO borrowBookToVO(BorrowBook borrowBook) {
        BorrowBookVO borrowBookVO = new BorrowBookVO();
        borrowBookVO.setUserName(userDao.getUserById(borrowBook.getUserId()).getUserName());
        borrowBookVO.setBookName(bookDao.getBookById(borrowBook.getBookId()).getBookName());
        //将字符串的时间转换为LocalDate类型，并在原有借书时间基础上添加2个月（设定是借书时间默认2个月）
        //再转换成字符串类型存进borrowBook类型中的returnTime属性
        String borrowDate = borrowBook.getBorrowDate();
        borrowBookVO.setBorrowDate(borrowDate);
        borrowBookVO.setReturnDate(LocalDate.parse(borrowDate).plusMonths(2).toString());
        return borrowBookVO;
    }
}