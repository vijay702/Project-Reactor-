package com.eminds.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {


    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitFlux() {

        var fruitsFlux = fluxAndMonoServices.fruitFlux();

        StepVerifier.create(fruitsFlux)
                .expectNext("mango","orange","banana")
                .verifyComplete();
    }

    @Test
    void monoFruits() {

        var monoFruitss = fluxAndMonoServices.monoFruits();

        StepVerifier.create(monoFruitss)
                .expectNext("mango")
                .verifyComplete();
    }

    @Test
    void fruitFluxMap(){


        var fluxFruitss = fluxAndMonoServices.fruitFluxMap();

        StepVerifier.create(fluxFruitss)
                .expectNext("MANGO","ORANGE","BANANA")
                .verifyComplete();
    }


    @Test
    void fruitFluxFilter() {

        var fluxfruits = fluxAndMonoServices.fruitFluxFilter(6).log();

        StepVerifier.create(fluxfruits)
                .expectNext( "Banana")
                .verifyComplete();


    }

    @Test
    void fruitFluxFilterMap() {

        var fluxfruits = fluxAndMonoServices.fruitFluxFilterMap(5).log();

        StepVerifier.create(fluxfruits)
                .expectNext("ORANGE", "BANANA")
                .verifyComplete();



    }

    @Test
    void fruitFluxFlatMap() {

        var fluxFruits = fluxAndMonoServices.fruitFluxFlatMap();
        StepVerifier.create(fluxFruits)
                .expectNextCount(16)
                .verifyComplete();
    }


    @Test
    void monoFruitsFlatMap() {

        var fluxFruits = fluxAndMonoServices.monoFruitsFlatMap();
        StepVerifier.create(fluxFruits)
                .expectNextCount(1)
                .verifyComplete();


    }

    @Test
    void fruitFluxFlatMapaSYNC() {


        var fluxFruits = fluxAndMonoServices.fruitFluxFlatMapaSYNC();
        StepVerifier.create(fluxFruits)
                .expectNextCount(16)
                .verifyComplete();
    }

 












}
