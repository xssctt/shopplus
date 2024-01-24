package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Activity;
import com.example.entity.ConsumeCraft;
import com.example.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConsumeCraftMapper  extends BaseMapper<ConsumeCraft> {

    @Select("select craftid from consume_craft where consumeid=#{id} ")
    List<Integer> selectListByconsumeid(@Param("id") Integer id);








}
