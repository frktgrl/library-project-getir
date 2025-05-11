package com.ftgrl.library_project_getir.controller;

import com.ftgrl.library_project_getir.dto.BorrowRecordDTO;
import com.ftgrl.library_project_getir.dto.BorrowRequestDTO;
import com.ftgrl.library_project_getir.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;

    @PostMapping
    public void borrowBook(@RequestBody BorrowRequestDTO request) {
        borrowService.borrowBook(request);
    }

    @PutMapping("/return/{id}")
    public void returnBook(@PathVariable Long id) {
        borrowService.returnBook(id);
    }

    @GetMapping("/my")
    public List<BorrowRecordDTO> myHistory() {
        return borrowService.getUserHistory();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('LIBRARIAN')")
    public List<BorrowRecordDTO> allHistory() {
        return borrowService.getAllHistory();
    }

    @GetMapping("/overdue")
    @PreAuthorize("hasRole('LIBRARIAN')")
    public List<BorrowRecordDTO> overdueBooks() {
        return borrowService.getOverdueBooks();
    }
}

