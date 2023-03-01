package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("//movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
   public  ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String s=movieService.addMovie(movie);
         return new ResponseEntity<>(s, HttpStatus.CREATED);
     }
     @PostMapping("/add-director")
     public ResponseEntity addDirector(@RequestBody Director director){
        return new ResponseEntity<>(movieService.addDirector(director),HttpStatus.CREATED);
     }
     @PutMapping("/add-movie-director-pair")
     public ResponseEntity  addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        return new ResponseEntity<>(movieService.mapMovieDirector(movie,director),HttpStatus.CREATED);
     }
    public @GetMapping("/get-movie-by-name/{name}")
     ResponseEntity getMovieByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getMovie(name),HttpStatus.CREATED);
     }
    public  @GetMapping("get-director-by-name/{name}")
     ResponseEntity getDirectorByName(@PathVariable String name){
        return  new ResponseEntity<>(movieService.getDirector(name),HttpStatus.CREATED);
     }
    public @GetMapping("get-movies-by director-name/{name}")
     ResponseEntity getMoviesByDirectorName(@PathVariable String name){
        return new ResponseEntity<>(movieService.getListOfMovies(name),HttpStatus.CREATED);
     }
    public @GetMapping("find-all-movies")
     ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovie(),HttpStatus.CREATED);
     }
    public  @DeleteMapping("delete-directors-by-name/{name}")
     ResponseEntity deleteDirectorByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.deleteByDirector(name),HttpStatus.CREATED);
     }
    public @DeleteMapping("/delete-all-directors")
     ResponseEntity deleteAllDirectors(){
        return new ResponseEntity<>(movieService.alldelete(),HttpStatus.CREATED);
     }

}
