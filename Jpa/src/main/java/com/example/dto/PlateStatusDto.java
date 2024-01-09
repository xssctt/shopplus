package com.example.dto;

import com.example.entity.Plate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlateStatusDto {

    private Integer billId;
    private Plate plate;
}
