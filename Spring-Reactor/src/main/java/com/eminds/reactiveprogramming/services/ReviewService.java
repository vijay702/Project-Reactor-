package com.eminds.reactiveprogramming.services;

import com.eminds.reactiveprogramming.domain.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class ReviewService {

    public Flux<Review> getAllReviews(){

        var reviews = List.of(new Review(1L,1L,10,"nice Book"),
                              new Review(2L,2L,10,"nice Book"),
                              new Review(3L,3L,9,"nice Book")
                         );

        return Flux.fromIterable(reviews);
    }

    public Mono<Review> getReviewById(Long reviewId){

        var review = new Review(reviewId,1L,10,"wonderful Book");

        return Mono.just(review);
    }
}
