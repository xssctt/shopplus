package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WechatConfigDto {

    private String   appid;//开发者Id

    private String   encodingAesKey;// 消息加密密匙

    private String    name;//公众号名称

    private String   secret;//开发者密码

    private String   status;//状态

    private String   token;//开发者令牌

    private String   type;//公众号类型
}
