package com.eminds.reactiveprogramming.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long reviewId;

    private Long bookid;
    private double ratings;
    private String  comments;


}
