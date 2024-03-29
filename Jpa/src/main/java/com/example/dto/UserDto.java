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
@Table(name = "User")
public class UserDto {

    @Column(name = "avatar")
    private String avatar;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "email")
    private String email;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id;
    @Column(name = "mobile")
    private String mobile	;
    @Column(name = "name")
    private String  name;
    @Column(name = "status")
    private Integer status;
}
