package com.example.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
@Table(name = "activity")
public class TickerDto {
    @Column(name = "allotTogether")
    private Integer allotTogether	;
    @Column(name = "code")
    private String code	;
    @Column(name = "couponId")
    private Integer couponId;
    @Column(name = "couponName")
    private String  couponName;
    @Column(name = "exchangeDate")
    private String  exchangeDate;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "memberId")
    private Integer  memberId	;
    @Column(name = "orderId")
    private Integer orderId	;
    @Column(name = "reduceCost")
    private String  reduceCost;
    @Column(name = "status")
    private Integer status;
}
