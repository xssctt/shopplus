package com.example.entity;


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
@Table(name = "Craft")
public class CraftDto {//加工方式

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Column(name = "name")
    private String name	;

    @Column(name = "sort")
    private Integer sort	;

    @Column(name = "status")
    private Integer status;

}
