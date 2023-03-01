package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie>MovieList;
    private HashMap<String,Director>DirectorList;
    private HashMap<String,List<String>>MovieDirectorPair;

    public MovieRepository() {
        MovieList=new HashMap<>();
        DirectorList=new HashMap<>();
        MovieDirectorPair=new HashMap<>();
    }

   public String addMovie(Movie movie){
        MovieList.put(movie.getName(),movie);
        return "success";
    }
    String addDirector(Director director){
        DirectorList.put(director.getName(),director);
        return "success";
    }
    String mapMovieDirector(String movieName,String directorName){
        if(MovieList.containsKey(movieName)&&DirectorList.containsKey(directorName)){
            if(MovieDirectorPair.containsKey(directorName)) {
                MovieDirectorPair.get(directorName).add((movieName));
            }
            else{
                List<String>t=new ArrayList<>();
                t.add(movieName);
                MovieDirectorPair.put(directorName,t);
            }
            return "success";
        }
        return "error";
    }
    Movie getMovie(String movieName){
        return MovieList.get(movieName);
    }
    Director getDirector(String directorName){
        return DirectorList.get(directorName);
    }
    List<String> getListOfMovies(String directorName){
        return MovieDirectorPair.get(directorName);
    }
    HashMap<String,Movie> getAllMovie(){
        return MovieList;
    }
    String deleteByDirector(String directorName){
        if(DirectorList.containsKey(directorName)) {
            DirectorList.remove(directorName);
        }
        List<String>temp=MovieDirectorPair.get(directorName);
        MovieDirectorPair.remove(directorName);
        for(String x:temp){
           MovieList.remove(x);
        }
        return "success";
    }
    String alldelete(){
        for (String x:MovieDirectorPair.keySet()){
            List<String>temp=MovieDirectorPair.get(x);
            MovieDirectorPair.remove(x);
            for(String g:temp){
                MovieList.remove(g);
            }
            MovieDirectorPair.remove(x);
        }
        return "success";
    }

}
