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


    @Test
    void fruitsFluxTransform() {

        var fluxfruits
                = fluxAndMonoServices.fruitsFluxTransform(5);

        StepVerifier.create(fluxfruits)
                .expectNext("Orange", "Banana")
                .verifyComplete();

    }


    @Test
    void fruitsFluxTransformDefaultIfEmpty() {


        var fluxfruits
                = fluxAndMonoServices.fruitsFluxTransformDefaultIfEmpty(10);

        StepVerifier.create(fluxfruits)
                .expectNext("Default")
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformSwitchIfEmpty() {


        var fluxfruits
                = fluxAndMonoServices.fruitsFluxTransformSwitchIfEmpty(10);

        StepVerifier.create(fluxfruits)
                .expectNext("pineapple","Orange","Apple")
                .verifyComplete();

    }

    @Test
    void fruitsFluxMerge() {


        var fluxfruits
                = fluxAndMonoServices.fruitsFluxMerge();

        StepVerifier.create(fluxfruits)
                .expectNext("Banana","Tomato","orange","kathirikkai")
                .verifyComplete();
    }


    @Test
    void fruitsFluxMergeWithSequential() {

        var fluxfruits
                = fluxAndMonoServices.fruitsFluxMergeWithSequential().log();

        StepVerifier.create(fluxfruits)
                .expectNext("Banana","orange","Tomato","kathirikkai")
                .verifyComplete();


    }


    @Test
    void fruitsFluxZip() {

        var fluxfruits
                = fluxAndMonoServices.fruitsFluxZip().log();

        StepVerifier.create(fluxfruits)
                .expectNext("BananaTomato","orangekathirikkai")
                .verifyComplete();

    }


    @Test
    void fruitFluxFilterDoOn() {


            var fluxfruits = fluxAndMonoServices.fruitFluxFilterDoOn(5).log();

            StepVerifier.create(fluxfruits)
                    .expectNext( "Orange","Banana")
                    .verifyComplete();
    }


    @Test
    void fruitsFluxOnErrorReturn() {


        var fluxfruits = fluxAndMonoServices.fruitsFluxOnErrorReturn().log();

        StepVerifier.create(fluxfruits)
                .expectNext( "Apple","Mango","orange")
                .verifyComplete();


    }
}
