package com.example.thirdprojectmovie.Repository;

import com.example.thirdprojectmovie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    //Create endpoint that search for a specific movie by title
//        Create endpoint that takes movie name and return the duration of the movie
    Movie findMovieByName(String name);
    Movie getMovieById(int id);
    List<Movie> getMoviesByDirctorId(String dirctor);
 //Create endpoint that takes movie name and return the rate of the movie
   List<Movie> getMoviesByRatingGreaterThan(int rate);
    Movie findMoviesByRating(String rating);
  // Create endpoint that returns all movies by a specific genre
    Movie findMoviesByGenre(String genre);

}
