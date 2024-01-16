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
@Table(name = "Member")
public class Member {//成员
    @Column(name = "avatar")
    private String avatar	;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "createAt")
    private String createAt	;

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @TableId(value = "id",type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "idCard")
    private String idCard;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "passwordHash")
    private String passwordHash	;
    @Column(name = "passwordSalt")
    private String passwordSalt	;

    @Column(name = "point")
    private Integer point;

    @Column(name = "sex")
    private Integer sex	;

    @Column(name = "status")
    private Integer status;

    @Column(name = "tenantId")
    private Integer tenantId;

    @Column(name = "updateAt")
    private String updateAt;
}
