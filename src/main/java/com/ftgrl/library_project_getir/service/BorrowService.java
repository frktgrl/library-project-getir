package com.ftgrl.library_project_getir.service;


import com.ftgrl.library_project_getir.dto.BorrowRecordDTO;
import com.ftgrl.library_project_getir.dto.BorrowRequestDTO;

import java.util.List;

public interface BorrowService {
    void borrowBook(BorrowRequestDTO request);
    void returnBook(Long borrowId);
    List<BorrowRecordDTO> getUserHistory();
    List<BorrowRecordDTO> getAllHistory();
    List<BorrowRecordDTO> getOverdueBooks();
}

