package com.ftgrl.library_project_getir.controller;

import com.ftgrl.library_project_getir.dto.BookDTO;
import com.ftgrl.library_project_getir.dto.BookRequestDTO;
import com.ftgrl.library_project_getir.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookDTO addBook(@RequestBody BookRequestDTO request) {
        return bookService.addBook(request);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody BookRequestDTO request) {
        return bookService.updateBook(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public Object searchBooks(@RequestParam String keyword,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return bookService.searchBooks(keyword, PageRequest.of(page, size));
    }
}

