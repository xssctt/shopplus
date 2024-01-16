package com.example.mapper;

import com.example.dto.Task;
import com.example.entity.Tenant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
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
public interface TaskMapper extends BaseMapper<Task> {

    @Select("select taskname from task where id=#{id}")
    String selectNameByid(@Param("id") Integer id);

    @Select("select id from task where taskname=#{taskname}")
    Integer selectIdByName(@Param("taskname") String taskname);

    @Delete("delete from roletask where taskid=#{taskid} and roleid=#{roleid} ")
    Integer deleteTaskRoleById(@Param("taskid") Integer taskid,@Param("roleid") Integer roleid);

//    @Select("select id from task where name=#{name}")
//    List<Integer> selectAllByRoleId(@Param("roleid") Integer roleid );
}
