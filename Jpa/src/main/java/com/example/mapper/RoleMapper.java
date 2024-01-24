package com.example.mapper;

import com.example.dto.RoleTask;
import com.example.entity.Role;
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
public interface RoleMapper extends BaseMapper<Role> {

    @Select("<script>" +
            " select count(*) from role " +
            "<where>" +
            " <if test=' id != null and id != \" \" ' > " +
            "and id = #{id}" +
            "</if>"+
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' spec != null and spec != \"all\"  and spec != \" \" ' > " +
            "and spec = #{spec}" +
            "</if>"+
            "</where >"+
            "</script> ")
    Integer selectAllByNameAndUseridAndApec(@Param("name") String name,
                                            @Param("spec")  String spec,
                                            @Param("id")  Integer id);


    @Select("<script>" +
            " select * from role " +
            "<where>" +
            " <if test=' id != null and id != \" \" ' > " +
            "and id = #{id}" +
            "</if>"+
            " <if test=' name != null and name != \"all\" and name != \" \" ' > " +
            "and name = #{name}" +
            "</if>"+
            " <if test=' spec != null and spec != \"all\"  and spec != \" \" ' > " +
            "and spec = #{spec}" +
            "</if>"+
            "</where >"+
            "limit #{alimit} offset #{aoffset}"+
            "</script> ")
    List<Role> selectAllByNameAndUseridAndApecpage(@Param("name") String name,
                                                   @Param("spec")  String spec,
                                                   @Param("id")  Integer id,
                                                   @Param("alimit")  Integer alimit,
                                                   @Param("aoffset") Integer aoffset);

    @Select("select taskid from roletask where roleid=#{roleid}")
    List<Integer> selectAllById(@Param("roleid")  Integer roleid);

    @Select("select * from roletask where roleid=#{roleid} and taskid=#{taskid}")
    Boolean selectByIdAndTaskId(@Param("roleid")  Integer roleid,@Param("taskid")  Integer taskid);

    @Insert("insert  into roletask(roleid,taskid)  values(#{roleid},#{taskid}) ")
    Boolean insertAllById(@Param("roleid")  Integer roleid,@Param("taskid")  Integer taskid);
}
