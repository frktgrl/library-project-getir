package com.ftgrl.library_project_getir.service.impl;


import com.ftgrl.library_project_getir.dto.BorrowRecordDTO;
import com.ftgrl.library_project_getir.dto.BorrowRequestDTO;
import com.ftgrl.library_project_getir.entity.Book;
import com.ftgrl.library_project_getir.entity.BorrowRecord;
import com.ftgrl.library_project_getir.entity.User;
import com.ftgrl.library_project_getir.repository.BookRepository;
import com.ftgrl.library_project_getir.repository.BorrowRecordRepository;
import com.ftgrl.library_project_getir.repository.UserRepository;
import com.ftgrl.library_project_getir.service.BorrowService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    @Override
    public void borrowBook(BorrowRequestDTO request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (!book.isAvailable()) throw new RuntimeException("Book is not available");

        User user = getCurrentUser();

        BorrowRecord record = BorrowRecord.builder()
                .book(book)
                .user(user)
                .borrowDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .build();

        book.setAvailable(false);
        bookRepository.save(book);
        borrowRecordRepository.save(record);
    }

    @Override
    public void returnBook(Long borrowId) {
        BorrowRecord record = borrowRecordRepository.findById(borrowId)
                .orElseThrow(() -> new EntityNotFoundException("Borrow record not found"));

        if (record.getReturnDate() != null)
            throw new RuntimeException("Book already returned");

        record.setReturnDate(LocalDate.now());

        Book book = record.getBook();
        book.setAvailable(true);
        bookRepository.save(book);
        borrowRecordRepository.save(record);
    }

    @Override
    public List<BorrowRecordDTO> getUserHistory() {
        User user = getCurrentUser();
        return borrowRecordRepository.findByUser(user)
                .stream().map(this::toDTO).toList();
    }

    @Override
    public List<BorrowRecordDTO> getAllHistory() {
        return borrowRecordRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public List<BorrowRecordDTO> getOverdueBooks() {
        return borrowRecordRepository.findByReturnDateIsNullAndDueDateBefore(LocalDate.now())
                .stream().map(this::toDTO).toList();
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    private BorrowRecordDTO toDTO(BorrowRecord record) {
        return BorrowRecordDTO.builder()
                .id(record.getId())
                .bookTitle(record.getBook().getTitle())
                .userEmail(record.getUser().getEmail())
                .borrowDate(record.getBorrowDate())
                .dueDate(record.getDueDate())
                .returnDate(record.getReturnDate())
                .build();
    }
}

