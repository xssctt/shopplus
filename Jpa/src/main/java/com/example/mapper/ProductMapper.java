package com.example.mapper;

import com.example.entity.Member;
import com.example.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
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
public interface ProductMapper extends BaseMapper<Product> {

    @Insert("")
    Boolean insertAllBoolean(@Param("product") Product product);






    @Select("<script>" +
            " select count(*) from product " +
            "<where>" +
            " <if test=' categoryId != null and categoryId != \" \" ' > " +
            "and categoryId = #{categoryId}" +
            "</if>"+
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' status != null and status != 0 and status != \" \" ' > " +
            "and status = #{status}" +
            "</if>"+
            "</where >"+
            "</script> ")
    Integer selectAllByIdAndNameAndStatus(@Param("categoryId") Integer categoryId,@Param("name") String name,@Param("status") Integer status);


    @Select("<script>" +
            " select * from product " +
            "<where>" +
            " <if test=' categoryId != null and categoryId != \" \" ' > " +
            "and categoryId = #{categoryId}" +
            "</if>"+
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' status != null and status != \" \" ' > " +
            "and status = #{status}" +
            "</if>"+
            "</where >"+
            "limit #{alimit} offset #{aoffset}"+
            "</script> ")
    List<Product> selectAllByIdAndNameAndStatuspage(@Param("categoryId") Integer categoryId, @Param("name") String name, @Param("status") Integer status, @Param("alimit") Integer alimit, @Param("aoffset") Integer aoffset);


}
