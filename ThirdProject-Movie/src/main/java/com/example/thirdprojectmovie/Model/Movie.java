package com.example.thirdprojectmovie.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
//name :
//        Cannot be null
//
//        Length more than 2
//        genre :
//        Cannot be null
//        Validation (Drama|Action|Comedy)
//        rating :
//        Cannot be null
//        I must be between 1 - 5
//        duration :
//        Cannot be null

//        It must be more than 60
//        Director Class: ID, name
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The genre cannot be null")
    @Length(min=2)
    private String name;
    @NotEmpty(message = "The Genre cannot be null")
    @Column(columnDefinition = "varchar(20) check (genre='drama' or genre='action' or genre='comedy')")
    private String genre;
    @Pattern(regexp = " ^[0-9]*$")
//   @Column(columnDefinition = "varchar(20) not null")
    private int rating;
    @NotNull
    @Min(60)
    @Column(columnDefinition = "varchar(20) not null")
    private int duration;
    @NotNull
    private  int dirctorId;


}
