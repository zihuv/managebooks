package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.annotation.OptLog;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.service.BookService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.BookVO;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 书籍管理
 *
 * @author: zihuv
 * @date: 2023/1/20
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 添加书籍
     *
     * @param book 书籍信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "添加书籍")
    @PostMapping("/book")
    public Result<?> insertBook(@RequestBody Book book) {
        bookService.insertBook(book);
        return Result.success();
    }

    /**
     * 删除书籍
     *
     * @param id 书籍id
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "删除书籍")
    @DeleteMapping("/book/{id}")
    public Result<?> deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return Result.success();
    }

    /**
     * 修改书籍信息
     *
     * @param book 书籍信息
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "修改书籍信息")
    @PutMapping("/book")
    public Result<?> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return Result.success();
    }

    /**
     * 查询所有书籍
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.vo.BookVO>>
     */
    @OptLog(value = "查询所有书籍")
    @GetMapping("/book/list")
    public Result<List<BookVO>> listBook(@RequestParam Integer pageNum,
                                         @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<BookVO> result = bookService.listBook(pageNum, pageSize);
        return Result.success(result);
    }

    /**
     * 根据id查询书籍
     *
     * @param id 书籍id
     * @return com.zihuv.managebooks.vo.Result<com.zihuv.managebooks.vo.BookVO>
     */
    @OptLog(value = "根据id查询书籍")
    @GetMapping("/book/{id}")
    public Result<BookVO> getBookById(@PathVariable Integer id) {
        BookVO book = bookService.getBookById(id);
        return Result.success(book);
    }

    /**
     * 根据书名查询书籍
     *
     * @param bookName 书籍名称
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.vo.BookVO>>
     */
    @OptLog(value = "根据书名查询书籍")
    @GetMapping("/book")
    public Result<List<BookVO>> listBookByBookName(@RequestParam String bookName,
                                                   @RequestParam Integer pageNum,
                                                   @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<BookVO> books = bookService.listBookByBookName(bookName, pageNum, pageSize);
        return Result.success(books);
    }

    /**
     * 根据书籍类别查询书籍
     *
     * @param categoryName 类别名称
     * @param pageNum      页码
     * @param pageSize
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.vo.BookVO>>
     */
    @OptLog(value = "根据书籍类别查询书籍")
    @GetMapping("/book/category")
    public Result<List<BookVO>> listBookByCategory(@RequestParam String categoryName,
                                                   @RequestParam Integer pageNum,
                                                   @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<BookVO> books = bookService.listBookByCategory(categoryName, pageNum, pageSize);
        return Result.success(books);
    }
}