package com.zihuv.managebooks.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zihuv.managebooks.entity.Book;
import com.zihuv.managebooks.service.BookService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * excel监听器
 *
 * @author: zihuv
 * @date: 2023/2/14
 */
@Slf4j
public class BookListener extends AnalysisEventListener<Book> {
    /**
     * 每隔5条存储数据库，实际使用中可以1000条，然后清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    private final List<Book> list = new ArrayList<>();
    private BookService bookService;

    private BookListener() {
    }

    public BookListener(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 每一条数据解析都会调用
     *
     * @param data            数据
     * @param analysisContext 解析内容
     */
    @SneakyThrows
    @Override
    public void invoke(Book data, AnalysisContext analysisContext) {
        ObjectMapper mapper = new ObjectMapper();
        log.info("解析到一条数据:{}", mapper.writeValueAsString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了都会来调用
     *
     * @param analysisContext 解析内容
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //再保存一次数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 存储数据库
     */
    private void saveData() {
        int dataSize = list.size();
        log.info("开始存入{}条存储数据库！", dataSize);
        if (dataSize != 0) {
            bookService.insertBookByList(list);
        }
        log.info("数据存储成功！");
    }
}