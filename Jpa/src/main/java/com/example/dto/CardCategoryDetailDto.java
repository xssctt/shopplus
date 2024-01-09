package com.example.dto;

import com.example.entity.CardCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardCategoryDetailDto {
    private CardCategory cardCategory;
    private String planName;
}
