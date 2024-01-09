package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TotalRevenueDto {

    private String  customerPrice;
    private String  hourlyIncome;
    private String  passengerTraffic;
    private String   totalIncome;

}
