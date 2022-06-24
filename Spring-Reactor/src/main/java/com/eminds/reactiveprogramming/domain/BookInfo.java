package com.eminds.reactiveprogramming.domain;

import lombok.*;

@Getter@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {

    private Long bookId;
    private String title;
    private String author;
    private String ISBN;
}
