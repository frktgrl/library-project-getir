package com.ftgrl.library_project_getir.service;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addBook_shouldReturnSavedBook() {
        BookRequestDTO request = new BookRequestDTO("Title", "Author", "12345", LocalDate.now(), "Genre");
        Book book = Book.builder().id(1L).title("Title").author("Author").isbn("12345")
                .publicationDate(LocalDate.now()).genre("Genre").available(true).build();

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        var result = bookService.addBook(request);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getTitle()).isEqualTo("Title");
    }

    @Test
    void getBookById_shouldThrowException_ifNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> bookService.getBookById(1L));
    }
}

