package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.service.BookCategoryService;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param bookCategory 书籍类别对象
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PostMapping("/category")
    public Result<?> insertCategory(@RequestBody BookCategory bookCategory) {
        bookCategoryService.insertCategory(bookCategory.getCategoryName());
        return Result.success();
    }

    /**
     * 删除书籍类别
     *
     * @param id 书籍类别的id
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @PutMapping("/category/{id}")
    public Result<Boolean> deleteCategoryById(@PathVariable Integer id) {
        bookCategoryService.deleteCategoryById(id);
        return Result.success();
    }
}