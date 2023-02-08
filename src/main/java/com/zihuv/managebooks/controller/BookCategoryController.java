package com.zihuv.managebooks.controller;

import com.zihuv.managebooks.annotation.OptLog;
import com.zihuv.managebooks.entity.BookCategory;
import com.zihuv.managebooks.service.BookCategoryService;
import com.zihuv.managebooks.utils.CommonUtils;
import com.zihuv.managebooks.vo.BookCategoryAmountVO;
import com.zihuv.managebooks.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 书籍类别管理
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
     * @param bookCategory 书籍类别名称
     * @return com.zihuv.managebooks.vo.Result<?>
     */
    @OptLog(value = "添加书籍类别")
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
    @OptLog(value = "删除书籍类别")
    @DeleteMapping("/category/{id}")
    public Result<?> deleteCategoryById(@PathVariable Integer id) {
        bookCategoryService.deleteCategoryById(id);
        return Result.success();
    }

    /**
     * 查询所有书籍类别
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List < com.zihuv.managebooks.entity.BookCategory>>
     */
    @OptLog(value = "查询所有书籍类别")
    @GetMapping("/category/list")
    public Result<List<BookCategory>> listCategory(@RequestParam Integer pageNum,
                                                   @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<BookCategory> result = bookCategoryService.listCategory(pageNum, pageSize);
        return Result.success(result);
    }

    /**
     * 查询所有类别有多少本书
     *
     * @param pageNum 页码
     * @param pageSize 显示条数
     * @return com.zihuv.managebooks.vo.Result<java.util.List<com.zihuv.managebooks.vo.BookCategoryAmountVO>>
     */
    @OptLog(value = "查询所有类别有多少本书")
    @GetMapping("/category")
    public Result<List<BookCategoryAmountVO>> listCategoryAmount(@RequestParam Integer pageNum,
                                                                 @RequestParam Integer pageSize) {
        //检查页码和显示条数的数据是否合法
        CommonUtils.checkPageNumAndSize(pageNum,pageSize);
        List<BookCategoryAmountVO> bookCategoryAmount = bookCategoryService.listCategoryAmount(pageNum, pageSize);
        return Result.success(bookCategoryAmount);
    }
}