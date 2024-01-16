package com.example.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@Table(name = "Consume")
public class ConsumeDto {
    @Column(name = "basePrice")
    private String basePrice;

    @Column(name = "billId")
    private Integer billId;

    @Transient
    private CraftDto craft;

    @Column(name = "createdAt")
    private String createdAt;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "price")
    private String price	;
    @Column(name = "productId")
    private Integer productId	;
    @Column(name = "productName")
    private String productName	;
    @Column(name = "quantity")
    private String quantity	;
    @Column(name = "remark")
    private String remark	;
}
