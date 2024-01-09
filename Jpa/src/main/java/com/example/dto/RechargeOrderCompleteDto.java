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
@Table(name = "RechargeOrderComplete")
public class RechargeOrderCompleteDto {
    @Column(name = "cardId")
    private Integer cardId;//会员卡Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;//充值订单Id
    @Column(name = "memberId")
    private Integer memberId;//会员Id
    @Column(name = "number")
    private Integer number;//订单号
    @Transient
    private PaymentCreateDto[] paymentCreateDtoList;//充值总金额
    @Column(name = "totalMoney")
    private String totalMoney;//充值总金额
}
