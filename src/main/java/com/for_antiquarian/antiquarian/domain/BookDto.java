package com.for_antiquarian.antiquarian.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BookDto {

    private Long id;
    private String title;
    private String authorName;
    private String authorSurname;
    private Integer publicationYear;
    private String signature;
    private BookStatus bookStatus;

}

