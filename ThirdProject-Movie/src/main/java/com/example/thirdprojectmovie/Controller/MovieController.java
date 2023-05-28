package com.example.thirdprojectmovie.Controller;

import com.example.thirdprojectmovie.Model.Movie;
import com.example.thirdprojectmovie.Service.MovieServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServices movieServices;
    @GetMapping("/get")
    public ResponseEntity get(){
      List<Movie> movies= movieServices.getMovie();
       return ResponseEntity.status(200).body(movies);
    }
    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid Movie movie){
     Movie movie1= movieServices.addMovie(movie);
      return ResponseEntity.status(200).body(movie1);
    }
    @PutMapping("/updat/{id}")
    public ResponseEntity updateMovie(@Valid Movie movie,@PathVariable Integer id){
        Movie oldMovie=movieServices.updateMovie(movie,id);
        return ResponseEntity.status(200).body(oldMovie);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletMovie(@PathVariable Integer id){
        Movie movie=movieServices.deleteMovie(id);
        return  ResponseEntity.status(200).body(movie);
    }
//The End--PointS
    @GetMapping("/searchBy/{name}")
public ResponseEntity searchByTitle(@PathVariable String name){
    Movie movie1=movieServices.searchByTitle(name);
    return  ResponseEntity.status(200).body(movie1);
}
//    @GetMapping("/get-duration/{name}")
//    public ResponseEntity getDuration(@PathVariable String name){
//        Movie movie=movieServices.gem(name)
//        return ResponseEntity.status(200).body();
//    }
    @GetMapping("/get-director/{name}")
    public ResponseEntity getDirector(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getDirectorName(name));
    }
    @GetMapping("/get-movies-by-director/{name}")
    public ResponseEntity getMoviesByDirector(@PathVariable String name){
        Movie movie2=movieServices.findMovieByGenre(name);
        return ResponseEntity.status(200).body(movie2);
    }
    //Qustion 5
    @GetMapping("/getAbove/{rate}")
    public ResponseEntity getMovieByRate(@PathVariable int rate){
        List<Movie> movie3= movieServices.getMoviesByRatingGreaterThan1(rate);
        return  ResponseEntity.status(200).body(movie3);
    }
    //Qustion 6
    @GetMapping("/searchBy/{gnere}")
    public ResponseEntity findMovieByGenre(@PathVariable String gnere){
        Movie movie2=movieServices.findMovieByGenre(gnere);
        return  ResponseEntity.status(200).body(movie2);
    }


}
