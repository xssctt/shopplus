package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanItemDto {

    private String percentage;
    private String pattern;//: [1-9]|[1-9]\d|100//服务方式
    private String price;//价格
    private String productId;//商品Id
    private String serviceType;//服务方式
    private String type;//计价方式
}
