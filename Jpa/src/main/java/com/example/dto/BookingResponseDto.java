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
@Table(name = "BookingResponse")
public class BookingResponseDto {
    @Column(name = "appid")
    private String appid	;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "date")
    private String date	;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "lineUp")
    private Integer lineUp	;
    @Column(name = "mobile")
    private String mobile	;
    @Column(name = "num")
    private String num;
    @Column(name = "openid")
    private String openid	;
    @Column(name = "qr")
    private String qr	;
    @Column(name = "status")
    private Integer status	;
    @Column(name = "tenantId")
    private Integer tenantId	;
    @Column(name = "turnout")
    private Integer turnout;
    @Column(name = "updatedAt")
    private String updatedAt	;
    @Column(name = "waitTime")
    private Integer waitTime	;

}
