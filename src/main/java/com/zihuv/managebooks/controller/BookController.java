package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.service.BookService;
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
    BookService bookService;

    /**
     * 添加书籍类别
     *
     * @param bookCategory
     * @return com.zihuv.managebooks.vo.Result<java.lang.Boolean>
     */
    @PostMapping("/category")
    public Result<Boolean> insertCategory(@RequestBody BookCategory bookCategory) {
        boolean flag = bookService.insertCategory(bookCategory.getCategoryName()) > 0;
        return Result.success(flag);
    }

    /**
     * 删除书籍类别
     *
     * @param id
     * @return com.zihuv.managebooks.vo.Result<java.lang.Boolean>
     */
    @PutMapping("/category/{id}")
    public Result<Boolean> deleteCategoryById(@PathVariable Integer id) {
        boolean flag = bookService.deleteCategoryById(id) > 0;
        return Result.success(flag);
    }

    /**
     * 添加书籍
     *
     * @param book
     * @return com.zihuv.managebooks.vo.Result<java.lang.Boolean>
     */
    @PostMapping("/book")
    public Result<Boolean> insertBook(@RequestBody Book book) {
        boolean flag = bookService.insertBook(book) > 0;
        return Result.success(flag);
    }

    /**
     * 删除书籍
     *
     * @param id
     * @return com.zihuv.managebooks.vo.Result<java.lang.Boolean>
     */
    @PutMapping("/book/{id}")
    public Result<Boolean> deleteBookById(@PathVariable Integer id) {
        boolean flag = bookService.deleteBookById(id) > 0;
        return Result.success(flag);
    }

    /**
     * 修改书籍信息
     *
     * @param book
     * @return com.zihuv.managebooks.vo.Result<java.lang.Boolean>
     */
    @PutMapping("/book")
    public Result<Boolean> updateBook(@RequestBody Book book) {
        boolean flag = bookService.updateBook(book) > 0;
        return Result.success(flag);
    }

    /**
     * 查询所有书籍
     *
     * @return com.zihuv.managebooks.vo.Result<java.util.List<com.zihuv.managebooks.entity.Book>>
     */
    @GetMapping("book")
    public Result<List<Book>> listBook() {
        List<Book> result = bookService.listBook();
        return Result.success(result);
    }
}