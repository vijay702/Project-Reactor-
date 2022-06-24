package com.eminds.reactiveprogramming.services;

import com.eminds.reactiveprogramming.domain.Book;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j

public class BookService {

    private BookInfoService bookInfoService;

    private ReviewService reviewService;

    public Flux<Book> getBook(){

        var allBooks = bookInfoService.getBooks();

        return  allBooks
                .flatMap(bookInfo -> {

                    reviewService.getAllReviews()
                })


    }
}
