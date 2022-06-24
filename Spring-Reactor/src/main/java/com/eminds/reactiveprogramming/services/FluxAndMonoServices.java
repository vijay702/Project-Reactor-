package com.eminds.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FluxAndMonoServices {

    public Flux<String> fruitFlux(){

      return  Flux.fromIterable(List.of("mango","orange","banana")).log();
    }

    public Flux<String> fruitFluxMap(){

        return  Flux.fromIterable(List.of("mango","orange","banana"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> fruitFluxFilter(int number){

        return  Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .filter(s -> s.length() > number);
    }
    public Flux<String> fruitFluxFilterMap(int number){

        return  Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .filter(s -> s.length() > number)
                .map(String::toUpperCase);
    }


    public Flux<String> fruitFluxFlatMap(){

        return  Flux.fromIterable(List.of("Mango","Banana","Apple"))
                .flatMap(s -> Flux.just(s.split("")))
                .log();
    }
    public Flux<String> fruitFluxFlatMapaSYNC(){

        return  Flux.fromIterable(List.of("Mango","Banana","Apple"))
                .flatMap(s -> Flux.just(s.split("")))
                .delayElements(Duration.ofMillis(
                        new Random().nextInt(1000)))
                .log();
    }


    public Mono<List<String>> monoFruitsFlatMap(){

        return Mono.just("mango").flatMap(s -> Mono.just(List.of(s.split("")))).log();
    }


    public Mono<String> monoFruits(){

        return Mono.just("mango").log();
    }
    public static void main(String[] args) {

        FluxAndMonoServices fluxAndMonoServicesn= new FluxAndMonoServices();

        fluxAndMonoServicesn.fruitFlux().subscribe(m -> System.out.println("m =" +m));

        fluxAndMonoServicesn.monoFruits().subscribe(s -> System.out.println("s =" + s));

        fluxAndMonoServicesn.fruitFluxMap().subscribe(v -> System.out.println("v  ="  + v));

    }


}
