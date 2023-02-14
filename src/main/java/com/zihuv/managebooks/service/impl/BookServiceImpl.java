package com.zihuv.managebooks.service.impl;

import com.github.pagehelper.PageHelper;
import com.zihuv.managebooks.constant.BorrowBookConst;
import com.zihuv.managebooks.dao.BookDao;
import com.zihuv.managebooks.dao.BorrowBookDao;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BookService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 书籍管理
 *
 * @author: zihuv
 * @date: 2023/1/21
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowBookDao borrowBookDao;

    @Override
    public void insertBook(Book book) {
        //判断名称、作者、书籍出版社、书籍类别不能为空
        CommonUtils.checkParamIsNull(book.getBookName(), book.getBookAuthor(),
                book.getBookPublish(), book.getBookCategory());
        bookDao.insertBook(book);
    }

    @Transactional
    @Override
    public void insertBookByList(List<Book> books) {
        for (Book book : books) {
            //判断名称、作者、书籍出版社、书籍类别不能为空
            CommonUtils.checkParamIsNull(book.getBookName(), book.getBookAuthor(),
                    book.getBookPublish(), book.getBookCategory());
        }
        bookDao.insertBookByList(books);
    }

    @Override
    public void deleteBookById(Integer id) {
        Book bk = bookDao.getBookById(id);
        //判断所删除的书籍是否存在，若不存在，无法删除
        if (bk == null) {
            throw new BizException(BookStatusEnums.BOOK_NOT_EXIST);
        }
        //判断书籍是否在借书表中被借
        if (borrowBookDao.getBorrowBookByBookId(id) != null) {
            throw new BizException(BookStatusEnums.BOOK_IS_BORROWED);
        }
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        Book bk = bookDao.getBookById(book.getId());
        //判断所修改的书籍是否存在，若不存在，无法修改
        if (bk == null) {
            throw new BizException(BookStatusEnums.BOOK_NOT_EXIST);
        }
        bookDao.updateBook(book);
    }

    @Override
    public List<BookVO> listBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookDao.listBook()
                .stream()
                .map(this::bookToVo)
                .collect(Collectors.toList());
    }

    @Override
    public BookVO getBookById(Integer id) {
        return bookToVo(bookDao.getBookById(id));
    }

    @Override
    public List<BookVO> listBookByBookName(String bookName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookDao.listBookByBookName(bookName)
                .stream()
                .map(this::bookToVo)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookVO> listBookByCategory(String categoryName, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookDao.listBookByCategoryName(categoryName)
                .stream()
                .map(this::bookToVo)
                .collect(Collectors.toList());
    }

    //将Book entity 转成 BookVO
    private BookVO bookToVo(Book book) {
        BookVO bookVO = new BookVO();
        bookVO.setId(book.getId());
        bookVO.setBookName(book.getBookName());
        bookVO.setBookAuthor(book.getBookAuthor());
        bookVO.setBookPublish(book.getBookPublish());
        if (borrowBookDao.getBorrowBookByBookId(book.getId()) == null) {
            bookVO.setState(BorrowBookConst.BORROWABLE);
        } else {
            bookVO.setState(BorrowBookConst.BORROWED);
        }
        return bookVO;
    }
}