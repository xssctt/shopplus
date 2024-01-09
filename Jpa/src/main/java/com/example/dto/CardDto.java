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
@Table(name = "Card")
public class CardDto {

    @Column(name = "availableEnd")
    private String availableEnd	;

    @Column(name = "availableStart")
    private String availableStart;

    @Column(name = "balance")
    private String balance;

    @Transient
    private CardCategoryDto cardCategoryDto;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "number")
    private String number	;
    @Column(name = "status")
    private Integer status;
}
