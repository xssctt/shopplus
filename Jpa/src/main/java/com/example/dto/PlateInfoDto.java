package com.example.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlateInfoDto {

    private Integer areaId;
    private String areaName;
    private String  code;
    private ConsumeInfoDto[] consumeInfoList;
    private String createdAt;
    private Integer id	;
    private String name;
    private String people;
    private Integer sort;
    private Integer status	;
    private Integer enantId;
    private String updatedAt;
    private Integer use;
}
