package com.example.dto;


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
@Table(name = "BillOrderComplete")
public class BillOrderCompleteDto {

    @Column(name = "cardId")
    private Integer cardId	;//会员卡id

    @Column(name = "code")
    private String code	;//短信验证码

    @Column(name = "discount")
    private String discount;//折扣金额

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;//订单id

    @Column(name = "memberId")
    private Integer memberId;//会员id

    @Column(name = "mobile")
    private String  mobile;//手机号

    @Column(name = "percentage")
    private Integer  percentage;//折扣比例

    @Column(name = "remark")
    private String  remark;//备注

    @Column(name = "smallChange")
    private String  smallChange;//抹零 0-不抹零

    @Transient
    private PaymentCreateDto[] paymentCreateList;//个渠道收款金额
}
