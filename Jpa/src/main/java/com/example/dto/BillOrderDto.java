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
@Table(name = "BillOrder")
public class BillOrderDto {


    @Column(name = "address")
    private String address	;
    @Column(name = "areaName")
    private String areaName	;
    @Column(name = "cardId")
    private Integer cardId	;
    @Column(name = "createdAt")
    private String createdAt	;
    @Column(name = "discount")
    private String discount	;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "memberId")
    private Integer memberId	;
    @Column(name = "name")
    private String name	;
    @Column(name = "number")
    private String number	;
    @Column(name = "paymentStatus")
    private String paymentStatus	;
    @Column(name = "percentage")
    private Integer percentage	;
    @Column(name = "plateId")
    private Integer plateId	;
    @Column(name = "plateName")
    private String plateName;
    @Column(name = "productFee")
    private String productFee;
    @Column(name = "remark")
    private String remark	;
    @Column(name = "smallChange")
    private String smallChange	;
    @Column(name = "status")
    private String status	;
    @Column(name = "telephone")
    private String telephone	;
    @Column(name = "totalFee")
    private String totalFee	;
    @Column(name = "totalPerson")
    private String totalPerson	;

    @Transient
    private PaymentDetailDto[] paymentList;
    @Transient
    private ConsumeDto[] consumeList;
    @Transient
    private CouponDto[] couponList;



}
