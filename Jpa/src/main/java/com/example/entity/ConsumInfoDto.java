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
@Table(name = "ConsumInfo")
public class ConsumInfoDto {

    @Column(name = "allowDiscount")
    private Integer allowDiscount	;
    @Column(name = "basePrice")
    private String basePrice	;
    @Column(name = "billId")
    private Integer billId	;
    @Column(name = "craft")
    private String craft	;
    @Column(name = "createdAt")
    private String createdAt	;
    @Column(name = "creatorId")
    private Integer creatorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "memberId")
    private Integer memberId	;
    @Column(name = "paymentStatus")
    private Integer paymentStatus;
    @Column(name = "planId")
    private Integer planId	;
    @Column(name = "plateId")
    private Integer plateId	;
    @Column(name = "price")
    private String price	;
    @Column(name = "processStatus")
    private Integer processStatus	;
    @Column(name = "productId")
    private Integer productId	;
    @Column(name = "productName")
    private String productName	;
    @Column(name = "quantity")
    private String quantity	;
    @Column(name = "remark")
    private String remark	;
    @Column(name = "sellerId")
    private Integer sellerId	;
    @Column(name = "serviceType")
    private Integer serviceType	;
    @Column(name = "status")
    private Integer status	;
    @Column(name = "tenantId")
    private Integer tenantId	;
    @Column(name = "updatedAt")
    private String updatedAt;

}
