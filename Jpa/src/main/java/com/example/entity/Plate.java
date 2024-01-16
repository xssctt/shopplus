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
@Table(name = "Plate")
public class Plate {

    @Column(name = "areaId")
    private Integer areaId;
    @Column(name = "code")
    private String code;
    @Column(name = "createdAt")
    private String createdAt;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "name")
    private String name;
    @Column(name = "people")
    private Integer people;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "status")
    private Integer status	;
    @Column(name = "tenantId")
    private Integer tenantId;
    @Column(name = "updatedAt")
    private String updatedAt;

    @Column(name = "use")
    private Integer use;
}
