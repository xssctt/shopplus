package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private String avatar;
    private String birthday;
    private Integer id	;
    private String memberBalance;
    private String mobile;
    private String  name;
    private Integer point;
    private Integer sex	;
    private Integer status	;
    private Integer tenantId	;

}
