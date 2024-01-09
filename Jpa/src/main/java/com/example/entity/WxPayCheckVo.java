package com.example.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WxPayCheckVo {

    private String   money;
    private String   orderNumber;
    private String   status;

}
