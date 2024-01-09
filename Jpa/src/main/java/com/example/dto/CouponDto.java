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
@Table(name = "Coupon")
public class CouponDto {

    @Column(name = "allotTogether")
    private Integer  allotTogether	;
    @Column(name = "beginDate")
    private String  beginDate	;
    @Column(name = "createdAt")
    private String  createdAt	;
    @Column(name = "description")
    private String  description	;
    @Column(name = "discount")
    private Integer  discount	;
    @Column(name = "distribute")
    private Integer  distribute	;
    @Column(name = "endDate")
    private String  endDate	;
    @Column(name = "fixedBeginTerm")
    private Integer  fixedBeginTerm	;
    @Column(name = "fixedTerm")
    private Integer  fixedTerm	;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer  id	;
    @Column(name = "leastCost")
    private String  leastCost	;
    @Column(name = "name")
    private String  name	;
    @Column(name = "notice")
    private String  notice	;
    @Column(name = "quantity")
    private Integer  quantity	;
    @Column(name = "reduceCost")
    private String  reduceCost	;
    @Column(name = "reduceMax")
    private String  reduceMax;
    @Column(name = "status")
    private Integer  status	;
    @Column(name = "type")
    private Integer  type	;
    @Column(name = "validType")
    private Integer  validType;
}
