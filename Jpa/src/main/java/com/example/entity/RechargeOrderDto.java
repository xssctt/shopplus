package com.example.entity;

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
@Table(name = "RechargeOrder")
public class RechargeOrderDto {
    @Column(name = "cardCategoryName")
    private String cardCategoryName;
    @Column(name = "cardId")
    private Integer cardId;
    @Column(name = "createdAt")
    private String createdAt;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "money")
    private String money;
    @Column(name = "number")
    private String number;
    @Column(name = "paymentStatus")
    private Integer paymentStatus;
    @Column(name = "status")
    private Integer status;
    @Column(name = "tenantId")
    private Integer tenantId;
    @Column(name = "updatedAt")
    private String updatedAt;

}
