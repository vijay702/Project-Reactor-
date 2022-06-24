package com.eminds.reactiveprogramming.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {

    private BookInfo bookInfo;
    private List<Review> reviewList;
}
