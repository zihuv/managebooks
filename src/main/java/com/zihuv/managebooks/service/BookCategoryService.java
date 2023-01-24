package com.zihuv.managebooks.service;

public interface BookCategoryService {
    /**
     * 添加书籍类别
     *
     * @param categoryName 书籍类型名称
     */
    void insertCategory(String categoryName);

    /**
     * 根据id删除书籍类别
     *
     * @param id 书籍类别的id
     */
    void deleteCategoryById(Integer id);
}
