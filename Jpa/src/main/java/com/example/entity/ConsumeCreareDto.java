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
@Table(name = "ConsumeCreare")
public class ConsumeCreareDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Transient
    private Integer[] craftIdList;

    @Column(name = "productId")
    private Integer productId;//商品ID

    @Column(name = "quantity")
    private String quantity;//^[0-9]+(\.[0-9])?$数量

    @Column(name = "remark")
    private String remark;//备注

    @Column(name = "serviceType")
    private Integer serviceType;//服务方式：1、堂食，2、外卖


}
