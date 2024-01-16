package com.example.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantDto {

    private String address;
    private String  createdAt;
    private Integer id	;
    private String name;
    private String picture	;
    private Integer status;
    private String telephone;
    private String updatedAt;
    private Integer  userId	;
}
