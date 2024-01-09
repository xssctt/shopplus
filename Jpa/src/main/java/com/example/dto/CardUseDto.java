package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardUseDto {
    private String balanceAfter	;
    private String cardCategoryName	;
    private String cardNumber;
    private String createdAt;
    private String money;
    private Integer status;
    private String updatedAt;

}
