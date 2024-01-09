package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Category")
public class CategoryDto {
    @Column(name = "cover")
    private String cover;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "name")
    private Integer name	;
    @Column(name = "sort")
    private Integer sort	;
    @Column(name = "status")
    private Integer status	;

}
