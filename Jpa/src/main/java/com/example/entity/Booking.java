package com.example.entity;
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
@Table(name = "Booking")
public class Booking {

    @Column(name = "appid")
    private String appid	;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "date")
    private String date	;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Column(name = "mobile")
    private String mobile	;
    @Column(name = "num")
    private String num	;
    @Column(name = "openid")
    private String openid	;
    @Column(name = "status")
    private Integer status	;
    @Column(name = "tenantId")
    private Integer tenantId	;
    @Column(name = "turnout")
    private Integer turnout	;
    @Column(name = "updatedAt")
    private String updatedAt	;
}
