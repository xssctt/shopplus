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
@Table(name = "Plan")
public class Plan {
    @Column(name = "availableTime")
    private String availableTime;
    @Column(name = "beginTimestamp")
    private String beginTimestamp;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "days")
    private String days;
    @Column(name = "endTimestamp")
    private String endTimestamp	;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "name")
    private String name	;
    @Column(name = "remark")
    private String remark	;
    @Column(name = "sort")
    private Integer sort	;
    @Column(name = "status")
    private Integer status;
    @Column(name = "tenantId")
    private Integer tenantId;
    @Column(name = "type")
    private Integer  type	;
    @Column(name = "updatedAt")
    private String updatedAt;
    @Column(name = "week")
    private String week	;
}
