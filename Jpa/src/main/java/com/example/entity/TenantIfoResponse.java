package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantIfoResponse {

    private String address;
    private Integer id	;
    private String name;
    private String picture;
    private String telephone;
}
