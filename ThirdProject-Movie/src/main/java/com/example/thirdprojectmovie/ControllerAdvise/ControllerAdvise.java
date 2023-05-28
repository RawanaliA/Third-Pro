package com.example.thirdprojectmovie.ControllerAdvise;

import com.example.thirdprojectmovie.ApiExeption.ApiExeption;
import com.example.thirdprojectmovie.ApiReseponce.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
  @ExceptionHandler(value = ApiExeption.class)
    public ResponseEntity<ApiResponse>ApiExeption(ApiExeption e){
      String massage=e.getMessage();
      return ResponseEntity.status(400).body(new ApiResponse(massage));
  }

}
