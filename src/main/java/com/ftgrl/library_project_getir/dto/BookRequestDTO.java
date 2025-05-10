package com.ftgrl.library_project_getir.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestDTO {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private String genre;
}
