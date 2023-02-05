package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.constant.BorrowBookConst;
import com.zihuv.managebooks.constant.IdentityConst;
import com.zihuv.managebooks.entity.Admin;
import com.zihuv.managebooks.entity.BorrowBook;
import com.zihuv.managebooks.entity.User;
import com.zihuv.managebooks.enums.BookStatusEnums;
import com.zihuv.managebooks.enums.UserAdminEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BorrowBookService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.BookVO;
import com.zihuv.managebooks.vo.BorrowBookVO;
import com.zihuv.managebooks.vo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * 借书Controller
 *
 * @author: zihuv
 * @date: 2023/1/29
 */
@RestController
public class BorrowBookController {
    @Autowired
    private BorrowBookService borrowBookService;

    @Autowired
    private HttpSession session;

    /**
     * 借书
     *
     * @param bookVO
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/borrow")
    public Result<?> borrowBook(@RequestBody BookVO bookVO) {
        //判断用户是否登录，判断身份是否为普通用户,并获得用户信息
        User user = (User)CommonUtils.checkLogin(IdentityConst.USER, session);
        //通过前端的数据，判断书籍是否被借书
        if (!BorrowBookConst.BORROWABLE.equals(bookVO.getState())) {
            throw new BizException(BookStatusEnums.BOOK_IS_BORROWED);
        }
        //封装BorrowBook对象
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setUserId(user.getId());
        borrowBook.setBookId(bookVO.getId());
        LocalDate localDate = LocalDate.now();
        borrowBook.setBorrowDate(localDate.toString());
        //将BorrowBook添加进BorrowBook表中
        borrowBookService.insertBorrowBook(borrowBook);
        return Result.success();
    }

    /**
     * 还书
     *
     * @param bookId 书籍id
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/borrow")
    public Result<?> returnBook(@RequestParam Integer bookId) {
        //判断用户是否登录，判断身份是否为普通用户,并获得用户信息
        User user = (User)CommonUtils.checkLogin(IdentityConst.USER, session);
        //还书 把借阅信息删除
        borrowBookService.deleteBorrowBook(user.getId(), bookId);
        return Result.success();
    }

    /**
     * 查询用户个人的借书记录
     *
     * @param pageNum
     * @param pageSize
     * @return com.zihuv.managebooks.vo.Result<java.util.List<com.zihuv.managebooks.vo.BorrowBookVO>>
     */
    @GetMapping("/borrow/user")
    public Result<List<BorrowBookVO>> listBorrowBook(Integer pageNum,Integer pageSize) {
        //判断用户是否登录，判断身份是否为普通用户,并获得用户信息
        User user = (User)CommonUtils.checkLogin(IdentityConst.USER, session);
        List<BorrowBookVO> result = borrowBookService.listBorrowBook(user.getId(),pageNum,pageSize);
        return Result.success(result);
    }

    /**
     * 查询所有人历史借阅记录
     *
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.vo.BorrowBookVO>>
     */
    @GetMapping("/borrow/admin")
    public Result<List<BorrowBookVO>> listAllBorrowBook(Integer pageNum,Integer pageSize) {
        //判断管理员是否登录，判断身份是否为管理员
        CommonUtils.checkLogin(IdentityConst.ADMIN, session);
        List<BorrowBookVO> result = borrowBookService.listAllBorrowBook(pageNum,pageSize);
        return Result.success(result);
    }
}