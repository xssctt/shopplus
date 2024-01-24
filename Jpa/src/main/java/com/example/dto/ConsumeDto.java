package com.example.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.entity.Craft;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Consume")
public class ConsumeDto {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;


    @Column(name = "basePrice")
    private String basePrice;

    @Column(name = "price")
    private String price	;

    @Column(name = "billId")
    private Integer billId;

    @Transient
    private List<Craft> craft;

    @Column(name = "createdAt")
    private String createdAt;


    @Column(name = "productId")
    private Integer productId	;
    @Column(name = "productName")
    private String productName	;
    @Column(name = "quantity")
    private String quantity	;
    @Column(name = "remark")
    private String remark	;
}
