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
@Table(name = "Tenant")
public class Tenant {//租户
    @Column(name = "address")
    private String address;
    @Column(name = "createdAt")
    private String createdAt;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String picture	;
    @Column(name = "status")
    private Integer status;
    @Column(name = "telephone")
    private String  telephone	;
    @Column(name = "updatedAt")
    private String  updatedAt;
    @Column(name = "userId")
    private Integer userId;
}
