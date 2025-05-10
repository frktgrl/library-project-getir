package com.ftgrl.library_project_getir.service;


import com.ftgrl.library_project_getir.dto.BookDTO;
import com.ftgrl.library_project_getir.dto.BookRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDTO addBook(BookRequestDTO request);
    BookDTO updateBook(Long id, BookRequestDTO request);
    void deleteBook(Long id);
    BookDTO getBookById(Long id);
    Page<BookDTO> searchBooks(String keyword, Pageable pageable);
}

