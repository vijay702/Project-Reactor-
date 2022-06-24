package com.eminds.reactiveprogramming.services;

import com.eminds.reactiveprogramming.domain.BookInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class BookInfoService {

    public Flux<BookInfo> getBooks(){
        var books = List.of(new BookInfo(1L,"Book One","Author Two","12121212"),
                            new BookInfo(2L,"Book Two","AUthor Two","365374"),
                             new BookInfo(3L,"Book Three","author 3","37873873")
        );
        return Flux.fromIterable(books);
    }

    public Mono<BookInfo> GetBookById(Long bookId){

        var book = new BookInfo(bookId,"BookOne","author one","76776776");

        return Mono.just(book);
    }
}
