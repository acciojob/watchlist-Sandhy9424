package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
   public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    String addDirector(Director director){
        return movieRepository.addDirector(director);
    }
    String mapMovieDirector(String movieName,String directorName){
        return movieRepository.mapMovieDirector(movieName,directorName);
    }
    Movie getMovie(String movieName){
        return movieRepository.getMovie(movieName);
    }
    Director getDirector(String directorName){
        return movieRepository.getDirector(directorName);
    }
    List<String> getListOfMovies(String directorName) {
        return movieRepository.getListOfMovies(directorName);
    }
   List<Movie> getAllMovie(){
       HashMap<String,Movie>temp=movieRepository.getAllMovie();
       List<Movie>allMovies=new ArrayList<>();
       for(String x:temp.keySet()){
           allMovies.add(temp.get(x));
       }
       return allMovies;
   }
    String deleteByDirector(String directorName){
        return movieRepository.deleteByDirector(directorName);
    }
    String alldelete(){
        return movieRepository.alldelete();
    }

}
