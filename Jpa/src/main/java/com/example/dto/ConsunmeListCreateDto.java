package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsunmeListCreateDto {
    private String billId;//账单ID

    private ConsumeCreareDto[] consumeCreateList;
}
