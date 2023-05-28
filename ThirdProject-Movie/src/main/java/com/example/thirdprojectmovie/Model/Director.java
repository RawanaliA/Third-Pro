package com.example.thirdprojectmovie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table
public class Director {
    @Id
    @Min(3)
    private Integer id;
    @NotEmpty
    @Min(2)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
}
