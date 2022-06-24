package com.eminds.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

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

    public Flux<String> fruitsFluxTransform(int number){

        Function<Flux<String>,Flux<String>> filterData =
                                                     data -> data.filter(s -> s.length() > number);


        return  Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .transform(filterData).log();
             //   .filter(s -> s.length() > number);

    }


    public Flux<String> fruitsFluxTransformDefaultIfEmpty(int number){

        Function<Flux<String>,Flux<String>> filterData =
                data -> data.filter(s -> s.length() > number);


        return  Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .transform(filterData)
                .defaultIfEmpty("Default").log();
        //   .filter(s -> s.length() > number);

    }
    public Flux<String> fruitsFluxMerge(){

        var fruits = Flux.just("Banana","orange")
                .delayElements(Duration.ofMillis(50));
        var veggies = Flux.just("Tomato","kathirikkai")
                .delayElements(Duration.ofMillis(50));



        return Flux.merge(fruits,veggies);

    }

    public Flux<String> fruitsFluxMergeWithSequential(){

        var fruits = Flux.just("Banana","orange")
                .delayElements(Duration.ofMillis(50));
        var veggies = Flux.just("Tomato","kathirikkai")
                .delayElements(Duration.ofMillis(50));



        return Flux.mergeSequential(fruits,veggies);

    }

    public Flux<String> fruitsFluxZip(){
        var fruits = Flux.just("Banana","orange");
        var veggies = Flux.just("Tomato","kathirikkai");

        return Flux.zip(fruits,veggies,(first,second) -> first+second).log();

    }

    public Flux<String> fruitsFluxTransformSwitchIfEmpty(int number){

        Function<Flux<String>,Flux<String>> filterData =
                data -> data.filter(s -> s.length() > number);


        return  Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .transform(filterData)
                .switchIfEmpty(Flux.just("pineapple","Orange","Apple")).log();
        //   .filter(s -> s.length() > number);

    }

    public Flux<String> fruitFluxFilterDoOn(int number){

        return  Flux.fromIterable(List.of("Mango","Orange","Banana"))
                .filter(s -> s.length() > number).doOnNext(s -> System.out.println("s  " + s));
    }

    public Flux<String> fruitsFluxOnErrorContinue(){

        return Flux.just("Apple","Mango","Orange")
                .map(s -> {

                    if ( s.equalsIgnoreCase("Mango"))
                            throw new RuntimeException("Exception Occured");
                    return s.toUpperCase();
                })
                .onErrorContinue((e,f) ->{

                    System.out.println("e"  +e);
                    System.out.println("f"  +f);

        });
    }

    public Flux<String> fruitsFluxOnErrorReturn(){

        return Flux.just("Apple","Mango")
                .concatWith(Flux.error(
                                   new RuntimeException("Exception Occured")))
                .onErrorReturn("orange");
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
