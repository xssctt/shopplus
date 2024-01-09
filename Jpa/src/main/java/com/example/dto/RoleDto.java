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
@Table(name = "Role")
public class RoleDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private Integer sort;


    @Column(name = "spec")
    private String spec;

    @Column(name = "status")
    private Integer status;

}
