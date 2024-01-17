package com.example.mapper;

import com.example.entity.Area;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Craft;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Mapper
public interface AreaMapper extends BaseMapper<Area> {
    @Select("<script>" +
            " select count(*) from area " +
            "<where>" +
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' status != null and status != 0 and status != \" \" ' > " +
            "and status = #{status}" +
            "</if>"+
            "</where >"+
            "</script> ")
    Integer selectAllByIdAndNameAndStatus(@Param("name") String name, @Param("status") Integer status);


    @Select("<script>" +
            " select * from area " +
            "<where>" +
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' status != null and status != \" \" ' > " +
            "and status = #{status}" +
            "</if>"+
            "</where >"+
            "limit #{alimit} offset #{aoffset}"+
            "</script> ")
    List<Area> selectAllByIdAndNameAndStatuspage(@Param("name") String name, @Param("status") Integer status, @Param("alimit") Integer alimit, @Param("aoffset") Integer aoffset);

}
