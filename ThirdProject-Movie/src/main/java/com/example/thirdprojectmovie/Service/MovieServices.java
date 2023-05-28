package com.example.thirdprojectmovie.Service;
import com.example.thirdprojectmovie.ApiExeption.ApiExeption;
import com.example.thirdprojectmovie.Model.Director;
import com.example.thirdprojectmovie.Model.Movie;
import com.example.thirdprojectmovie.Repository.DirectorRepository;
import com.example.thirdprojectmovie.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServices {
    private final MovieRepository movieRepository;
    private final DirectorService directorService;
    //crud
    public List<Movie> getMovie(){
        List<Movie> allMovies=movieRepository.findAll();
        return allMovies;
    }
    public Movie addMovie(Movie movie,int id) {
        Movie movie1= movieRepository.getById(id);
            if (movie1.getId()!=directorService.get()) {
                throw new ApiExeption("You should ADD  a dirctor first for your Movie");
    }return movieRepository.save(movie);
    }
    public Movie updateMovie(Movie movie,Integer id) {
        Movie oldmovie = movieRepository.getById(id);
        if (oldmovie == null) {
            throw new ApiExeption("Enter correct id");
        }
        oldmovie.setName(movie.getName());
        oldmovie.setGenre(movie.getGenre());
        oldmovie.setRating(movie.getRating());
        oldmovie.setDuration(movie.getDuration());
        movieRepository.save(oldmovie);
        return oldmovie;
    }
    public Movie deleteMovie(Integer id){
        Movie movie=movieRepository.getById(id);
        if (movie == null) {
            throw new ApiExeption("Enter correct id");
        }
        movieRepository.deleteById(id);
        return movie;
    }
    //The EndPointse
    public Movie searchByTitle(String name){
        Movie movie=movieRepository.findMovieByName(name);
        if (movie==null){
            throw new ApiExeption("Enter correct title");
        }
        return movie;
    }
    //   2 Create endpoint that takes movie name and return the director name
    public Integer durationOfMovie(String name){
        Movie movie=movieRepository.findMovieByName(name);
    if(movie==null){
        throw new ApiExeption("Enter correct title");
    }
        return directorService.getDirctorByName().getId();
    }
    //3
public List<Movie> dirctorOfMovie(String name){
    Movie movie=movieRepository.findMovieByName(name);
    if(movie==null) {
        throw new ApiExeption("Enter correct title");
    }
    return  directorService.getDirctorByName(name).getId();
    }
//    4-Create endpoint to list movies to a specific director
public List<Movie> getMoviesByDirctor(String dirctor){
    List<Movie> movie=movieRepository.getMoviesByDirctorId(dirctor);
    return movie;
}
//    Create endpoint that takes movie name and return the rate of the movie
       public Integer getMovieRate(String rating){
        Movie movie=movieRepository.findMoviesByRating(rating);
        if (movie==null){
            throw new ApiExeption("Enter correct Rating Between 1-5");
        }
        return movie.getRating();
    }
//    Create endpoint that returns all movies above that rate
    public List<Movie> getMoviesByRatingGreaterThan1(int rating){
        List<Movie> movie=movieRepository.getMoviesByRatingGreaterThan(rating);
        return movie;
    }
//    Create endpoint that returns all movies by a specific genre
public Movie findMovieByGenre(String gnere){
    Movie movie=movieRepository.findMoviesByGenre(gnere);
    if (movie==null){
        throw new ApiExeption("Enter correct Genre");
    }
    return movie;
}
}
