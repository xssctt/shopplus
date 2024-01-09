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
@Table(name = "PaymentDetail")
public class PaymentDetailDto {//支付详细信息

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "money")
    private String money	;
    @Column(name = "orderNumber")
    private String orderNumber	;
    @Column(name = "orderType")
    private Integer orderType	;
    @Column(name = "paymentChannelId")
    private Integer paymentChannelId	;
    @Column(name = "paymentChannelName")
    private String  paymentChannelName;
    @Column(name = "tradeNumber")
    private String  tradeNumber;
}
