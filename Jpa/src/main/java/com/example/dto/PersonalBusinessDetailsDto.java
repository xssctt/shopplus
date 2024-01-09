package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalBusinessDetailsDto {
    private DiscountStatisticsDto discountStatistics;
    private IncomeDetailsDto[] incomeDetails;
    private ReceivingStatisticsDto receivingStatistics;
    private TotalRevenueDto totalRevenue;
}
