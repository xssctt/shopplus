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

public class PlanCreateDto {

    private String availableTime;//string

    private String pattern;// ^[\d\:\-\,]*$ 每天有效的时间段

    private String beginTimestamp;//YYYY-MM-DD方案有效起始时间

    private String days;// 每月有效日期

    private String endTimestamp;//YYYY-MM-DD//方案有效结束时间

    private String name;//买一送一//方案名称

    private Integer planId;//价格计划Id

    private PlanItemDto[]  planItemList;//

    private String remark;//备注

    private Integer sort;//方案排序

    private Integer status;//状态

    private Integer type;//方案类型

    private String week;//方案有效星期数数组
}
