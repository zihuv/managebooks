package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.service.BookService;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 书籍管理Controller
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
     * @param book 书籍对象
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/book")
    public Result<?> insertBook(@RequestBody Book book) {
        bookService.insertBook(book);
        return Result.success();
    }

    /**
     * 删除书籍
     *
     * @param id 书籍的id
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/book/{id}")
    public Result<?> deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return Result.success();
    }

    /**
     * 修改书籍信息
     *
     * @param book 书籍对象
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/book")
    public Result<?> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return Result.success();
    }

    /**
     * 查询所有书籍
     *
     * @return com.zihuv.managebooks.vo.Result<java.util.List<com.zihuv.managebooks.entity.Book>>
     */
    @GetMapping("/book")
    public Result<List<Book>> listBook() {
        List<Book> result = bookService.listBook();
        return Result.success(result);
    }
}