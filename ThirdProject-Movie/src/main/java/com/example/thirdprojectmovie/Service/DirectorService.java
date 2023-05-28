package com.example.thirdprojectmovie.Service;

import com.example.thirdprojectmovie.ApiExeption.ApiExeption;
import com.example.thirdprojectmovie.Model.Director;
import com.example.thirdprojectmovie.Model.Movie;
import com.example.thirdprojectmovie.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
private final DirectorRepository directorRepository;

public List<Director>get(){
    List<Director> directors=directorRepository.findAll();

    return directors;
}
    public Director addDirctor(Director director){
        Director director1=directorRepository.save(director);
        return  director1;
    }
    public Director updateDirector(Director director,Integer id) {
        Director olddirector = directorRepository.getById(id);
        if (olddirector == null) {
            throw new ApiExeption("Enter correct id");
        }
        olddirector.setName(director.getName());
        directorRepository.save(olddirector);
        return olddirector;
    }
    public Director deleteDirctor (Integer id){
        Director director=directorRepository.getById(id);
        if (director == null) {
            throw new ApiExeption("Enter correct id");
        }
        directorRepository.deleteById(id);
        return director;
    }
    public Director getDirctorByid(Integer id){
       return directorRepository.getDirectorById(id);
    }
    public Director getDirctorByName(String name){
        return directorRepository.getDirectorByName(name);
    }

}