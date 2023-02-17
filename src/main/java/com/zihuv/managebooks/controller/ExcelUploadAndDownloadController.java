package com.zihuv.managebooks.controller;

import com.alibaba.excel.EasyExcel;
import com.zihuv.managebooks.dao.BookDao;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.enums.StatusCodeEnums;
import com.zihuv.managebooks.exception.BizException;
import com.zihuv.managebooks.listener.BookListener;
import com.zihuv.managebooks.service.BookService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 导入excel文件和下载excel文件
 *
 * @author: zihuv
 * @date: 2023/2/14
 */
@RestController
public class ExcelUploadAndDownloadController {
    @Value("${managebooks.excel.fileName:demo01}")
    private String fileName;
    @Value("${managebooks.excel.sheet:sheet01}")
    private String sheetName;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;

    /**
     * 将excel转成数据库数据导入
     *
     * @param file 要上传的excel文件
     */
    @PostMapping("/excel")
    public void excelToDatabase(MultipartFile file) throws IOException {
        //判断file是否存在
        if (file == null) {
            throw new BizException(StatusCodeEnums.PARAM_ERROR);
        }
        //将excel转成数据库数据导入
        EasyExcel.read(file.getInputStream(), Book.class, new BookListener(bookService)).sheet().doRead();
    }

    /**
     * 数据库信息转成excel保存到本地
     *
     * @param response response
     */
    @GetMapping("/excel")
    public void databaseToExcel(HttpServletResponse response) throws IOException {
        //设置响应数据格式和编码
        response.setContentType("application/x-excel;charset=UTF-8");
        //指定文件的名称和扩展名
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", StandardCharsets.UTF_8));
        EasyExcel.write(response.getOutputStream(), Book.class)
                .sheet(sheetName).doWrite(() -> bookDao.listBook());
    }
}