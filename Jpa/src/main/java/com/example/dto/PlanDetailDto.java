package com.example.dto;

import com.example.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDetailDto {
    private Object keySet;
    private Plan plan;
    private Map<Object,String> planItemMap;
    private Integer[] productIdList;
}
