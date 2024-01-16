package com.example.entity;

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
@Table(name = "WechatTemplate")
public class WechatTemplate {

    @Column(name = "appid")
    private String   appid;
    @Column(name = "booking")
    private String   booking;
    @Column(name = "createdAt")
    private String   createdAt;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer   id;
    @Column(name = "note")
    private String    note;
    @Column(name = "status")
    private Integer    status;
    @Column(name = "tenantId")
    private Integer    tenantId;
    @Column(name = "updatedAt")
    private String    updatedAt	;
}
