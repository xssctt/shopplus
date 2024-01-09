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
@Table(name = "CardCategory")
public class CardCategory {

    @Column(name = "createdAt")
    private String createdAt	;

    @Column(name = "discount")
    private Integer discount	;

    @Column(name = "discountType")
    private Integer discountType;

    @Column(name = "durationDay")
    private Integer durationDay;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Column(name = "intervalDay")
    private Integer intervalDay	;

    @Column(name = "name")
    private String name;

    @Column(name = "planId")
    private Integer planId	;

    @Column(name = "pointPercentage")
    private Integer pointPercentage	;

    @Column(name = "remark")
    private String remark;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "status")
    private Integer status	;

    @Column(name = "tenantId")
    private Integer tenantId;

    @Column(name = "updatedAt")
    private String updatedAt;

    @Column(name = "validType")
    private Integer validType;
}
