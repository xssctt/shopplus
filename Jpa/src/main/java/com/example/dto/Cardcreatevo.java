package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cardcreatevo {
    private Integer discount ;//消费折扣比例
    private Integer discountType;  //折扣类型
    private Integer durationDay; //自领取后多少天内有效
    private Integer intervalDay; //领取后多少天开始生效
    private String name;  //卡类名称
    private Integer planId; //折扣方案
    private Integer  pointPercentage;  //积分比例
    private String  remark; //备注
    private Integer sort; //排序
    private Integer status ;//状态
    private Integer  validType;   //有效期类型
}
