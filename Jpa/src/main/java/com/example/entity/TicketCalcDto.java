package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketCalcDto {

    private String  code;//核销码

    private String orderNumber;//订单号

    private PaymentCreateDto[] paymentCreateList;
}