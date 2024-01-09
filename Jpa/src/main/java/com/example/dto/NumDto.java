package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumDto {
    private Integer freeTotalTables;
    private StatusDto[] statusDtos;
    private String title;
    private Integer waitingTotalTables;

}
