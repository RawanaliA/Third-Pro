package com.example.thirdprojectmovie.Repository;

import com.example.thirdprojectmovie.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Create endpoint that search for a specific movie by title
//        Create endpoint that takes movie name and return the duration of the movie
//        Create endpoint that takes movie name and return the director name
//        Create endpoint to list movies to a specific director
//        Create endpoint that takes movie name and return the rate of the movie
//        Create endpoint that returns all movies above that rate
//        Create endpoint that returns all movies by a specific genre
@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer>{
Director getDirectorById(Integer id);
    Director getDirectorByName(String name);


}
