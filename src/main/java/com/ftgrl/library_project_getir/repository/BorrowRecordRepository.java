package com.ftgrl.library_project_getir.repository;


import com.ftgrl.library_project_getir.entity.BorrowRecord;
import com.ftgrl.library_project_getir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByUser(User user);
    List<BorrowRecord> findByReturnDateIsNullAndDueDateBefore(LocalDate now);
}

