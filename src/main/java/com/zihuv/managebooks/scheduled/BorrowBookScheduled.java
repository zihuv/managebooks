package com.zihuv.managebooks.scheduled;

import com.zihuv.managebooks.dao.BorrowBookDao;
import com.zihuv.managebooks.entity.BorrowBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 有关借书的任务调度
 *
 * @author: zihuv
 * @date: 2023/2/12
 */
@Slf4j
@Component
public class BorrowBookScheduled {
    @Value("${managebooks.borrowBookMonthDuration:2}")
    private Integer borrowBookMonthDuration;
    @Autowired
    private BorrowBookDao borrowBookDao;

    /**
     * 每天某时刻检查有是否有书籍逾期
     */
    @Scheduled(cron = "${managebooks.borrowBookCheckTime}")
    public void checkOverdueBorrowBook() {
        List<BorrowBook> borrowBooks = borrowBookDao.listBorrowBook();
        List<BorrowBook> overdueBorrowBooks = new ArrayList<>();
        //判断是否有书籍逾期
        for (BorrowBook borrowBook : borrowBooks) {
            LocalDate returnDate = LocalDate.parse(borrowBook.getBorrowDate()).plusMonths(borrowBookMonthDuration);
            if (LocalDate.now().isAfter(returnDate)) {
                overdueBorrowBooks.add(borrowBook);
            }
        }
        //将书籍借阅逾期信息打印到控制台上
        if (!overdueBorrowBooks.isEmpty()) {
            log.warn("==========书籍借阅逾期信息==========");
            for (BorrowBook borrowBook : overdueBorrowBooks) {
                log.warn("借阅id:{},借阅用户id:{},书籍id:{},借阅时间:{}",
                        borrowBook.getBookId(), borrowBook.getUserId(),
                        borrowBook.getBookId(), borrowBook.getBorrowDate());
            }
        }
    }
}