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
public class PlateDto {
    private Integer areaId;
    private String areaName;
    private String code	;
    private Integer id;
    private String  name;
    private Integer  people;
    private Integer sort;
    private Integer status;
    private Integer use;

}
