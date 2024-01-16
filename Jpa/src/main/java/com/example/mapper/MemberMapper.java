package com.example.mapper;

import com.example.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface MemberMapper extends BaseMapper<Member> {

    @Update("update member set status=#{status} where id=#{userid}")
    int updateStatusBoolean(@Param("userid")  Integer userid,@Param("status") Integer status);


    @Select("<script>" +
            " select count(*) from member " +
            "<where>" +
            " <if test=' id != null and id != \" \" ' > " +
            "and id = #{id}" +
            "</if>"+
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' status != null and status != 0 and status != \" \" ' > " +
            "and status = #{status}" +
            "</if>"+
            "</where >"+
            "</script> ")
    Integer selectAllByIdAndNameAndStatus(@Param("id") Integer id,@Param("name") String name,@Param("status") Integer status);


    @Select("<script>" +
            " select * from member " +
            "<where>" +
            " <if test=' id != null and id != \" \" ' > " +
            "and id = #{id}" +
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
    List<Member> selectAllByIdAndNameAndStatuspage(@Param("id") Integer id,@Param("name") String name,@Param("status") Integer status,@Param("alimit") Integer alimit,@Param("aoffset") Integer aoffset);


}
