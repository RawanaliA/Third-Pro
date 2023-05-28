package com.example.thirdprojectmovie.ApiExeption;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ApiExeption extends RuntimeException {
   public ApiExeption(String massage){
       super(massage);
   }
}
