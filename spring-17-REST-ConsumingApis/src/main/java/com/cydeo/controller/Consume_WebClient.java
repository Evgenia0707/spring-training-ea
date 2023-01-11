package com.cydeo.controller;


import com.cydeo.dto.GenreDTO;
import com.cydeo.dto.MovieCinemaDTO;
import com.cydeo.service.GenreService;
import com.cydeo.service.MovieCinemaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();//consume 3d party//send request 3d party(create Clientobj)
   //base URl - hit without URI --give endPoint + combine in up url
    private final MovieCinemaService movieCinemaService;
    private final GenreService genreService;

    public Consume_WebClient(MovieCinemaService movieCinemaService, GenreService genreService) {
        this.movieCinemaService = movieCinemaService;
        this.genreService = genreService;
    }
//creating reactive API

    @GetMapping("/flux-movie-cinemas")//return/answer in reactive way/ multipl elems
    public Flux<MovieCinemaDTO> readAllCinemaFlux(){

        return Flux.fromIterable(movieCinemaService.findAll());//Flux == Array

    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinemaDTO> readById(@PathVariable("id") Long id){
//
//        return Mono.just(movieCinemaService.findById(id));
//
//    }

    @GetMapping("/mono-movie-cinema/{id}")//return 1 obj
    public ResponseEntity<Mono<MovieCinemaDTO>> readById(@PathVariable("id") Long id){

        return ResponseEntity.ok(Mono.just(movieCinemaService.findById(id)));

    }

    @PostMapping("/create-genre")
    public Mono<GenreDTO> createGenre(@RequestBody GenreDTO genre){

        GenreDTO createdGenre = genreService.save(genre);

        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));

    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){

        genreService.deleteById(id);

        return Mono.empty();//return can be mono
    }

//    ---------------------------WEBCLIENT---------------------------
//can implement in Server or Controller Layer (Service better)
    @GetMapping("/flux")
    public Flux<MovieCinemaDTO> readWithWebClient(){

        return webClient
                .get()
                .uri("/flux-movie-cinemas")//give endPoint + combine in up url
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()//get responce
                .bodyToFlux(MovieCinemaDTO.class);//what we do witn responce - give multiple obj//return directly

    }

    @GetMapping("/mono/{id}")//consume react way
    public Mono<MovieCinemaDTO> readMonoWithWebClient(@PathVariable("id") Long id){

        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinemaDTO.class);//return 1 obj//assigne

    }
}