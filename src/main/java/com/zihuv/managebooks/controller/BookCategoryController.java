package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.service.BookCategoryService;
import com.zihuv.managebooks.vo.BookCategoryAmountVO;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 书籍类别Controller
 *
 * @author: zihuv
 * @date: 2023/1/23
 */
@RestController
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    /**
     * 添加书籍类别
     *
     * @param bookCategory
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/category")
    public Result<?> insertCategory(@RequestParam String bookCategory) {
        bookCategoryService.insertCategory(bookCategory);
        return Result.success();
    }

    /**
     * 删除书籍类别
     *
     * @param id 书籍类别的id
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/category/{id}")
    public Result<?> deleteCategoryById(@PathVariable Integer id) {
        bookCategoryService.deleteCategoryById(id);
        return Result.success();
    }

    /**
     * 查询所有书籍类别
     *
     * @param pageNum
     * @param pageSize
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.entity.BookCategory>>
     */
    @GetMapping("/category/list")
    public Result<List<BookCategory>> listCategory(@RequestParam Integer pageNum,
                                                   @RequestParam Integer pageSize) {
        List<BookCategory> result = bookCategoryService.listCategory(pageNum, pageSize);
        return Result.success(result);
    }

    /**
     * 查询所有类别有多少本书
     *
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.vo.BookCategoryAmountVO>>
     */
    @GetMapping("/category")
    public Result<List<BookCategoryAmountVO>> listCategoryAmount(@RequestParam Integer pageNum,
                                                                 @RequestParam Integer pageSize) {
        List<BookCategoryAmountVO> bookCategoryAmount = bookCategoryService.listCategoryAmount(pageNum, pageSize);
        return Result.success(bookCategoryAmount);
    }
}