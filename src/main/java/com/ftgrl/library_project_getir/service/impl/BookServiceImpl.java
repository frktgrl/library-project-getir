package com.ftgrl.library_project_getir.service.impl;

import com.ftgrl.library_project_getir.dto.BookDTO;
import com.ftgrl.library_project_getir.dto.BookRequestDTO;
import com.ftgrl.library_project_getir.entity.Book;
import com.ftgrl.library_project_getir.repository.BookRepository;
import com.ftgrl.library_project_getir.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDTO addBook(BookRequestDTO request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .publicationDate(request.getPublicationDate())
                .genre(request.getGenre())
                .available(true)
                .build();
        return toDTO(bookRepository.save(book));
    }

    @Override
    public BookDTO updateBook(Long id, BookRequestDTO request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublicationDate(request.getPublicationDate());
        book.setGenre(request.getGenre());

        return toDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    @Override
    public Page<BookDTO> searchBooks(String keyword, Pageable pageable) {
        var list = bookRepository
                .findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbnContainingIgnoreCaseOrGenreContainingIgnoreCase(
                        keyword, keyword, keyword, keyword);
        return new PageImpl<>(list.stream().map(this::toDTO).toList(), pageable, list.size());
    }

    private BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publicationDate(book.getPublicationDate())
                .genre(book.getGenre())
                .available(book.isAvailable())
                .build();
    }
}
