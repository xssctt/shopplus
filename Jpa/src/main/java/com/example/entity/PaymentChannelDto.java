package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentChannelDto {//支付通道/方式
    private String code;
    private Integer id;
    private String name;
    private Integer sort	;
    private Integer status;

}
