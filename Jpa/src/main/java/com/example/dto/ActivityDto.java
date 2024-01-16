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
public class ActivityDto {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Column(name = "couponId")
    private Integer couponId;//优惠卷

    @Column(name = "couponName")
    private String  couponName	;

    @Column(name = "createdAt")
    private Integer createdAt	;

    @Column(name = "eventType")
    private Integer eventType	;//活动类型



    @Column(name = "quantity")
    private Integer quantity	;//数量

    @Column(name = "status")
    private Integer status	;//状态

}
