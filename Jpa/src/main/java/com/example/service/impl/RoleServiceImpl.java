package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.dto.RoleDto;
import com.example.dto.RoleTask;
import com.example.dto.Task;
import com.example.dto.UserDto;
import com.example.entity.ConsumeCraft;
import com.example.entity.Member;
import com.example.entity.Pagination;
import com.example.entity.Role;
import com.example.execption.CustomException;
import com.example.mapper.RoleMapper;
import com.example.mapper.TaskMapper;
import com.example.mapper.UserMapper;
import com.example.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    RoleMapper roleMapper;
    @Resource
    TaskMapper taskMapper;

    @Resource
    UserMapper userMapper;

    @Override
    public ListDto<RoleDto> selectAllByNameAndUseridAndApec(Integer limit, Integer page, String name, String spec, Integer userid) {


        Integer aoffset;
        aoffset = (page - 1) * limit;



        Integer totalCount=roleMapper.selectAllByNameAndUseridAndApec(name,spec,userid);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
            totalPages= totalPages/limit;
            totalPages +=1;
        }

        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();
        List<Role> roles = roleMapper.selectAllByNameAndUseridAndApecpage(name, spec,userid,limit,aoffset);

        List<RoleDto> roleDtoList=new ArrayList<>();

        for (Role r:roles){
           roleDtoList.add(RoleDto.builder()
                   .id(r.getId())
                   .status(r.getStatus())
                   .name(r.getName())
                   .sort(r.getSort())
                   .spec(r.getSpec()).build());
        }


        return new ListDto<RoleDto>(roleDtoList,pagination);


    }

    @Override
    public Set<String> selectAllById(Integer roleid) {

        List<Integer> taskidlist = roleMapper.selectAllById(roleid);

        Set<String> stringSet=new HashSet<>();
        for (Integer id:taskidlist) {
            stringSet.add(taskMapper.selectNameByid(id));
        }

        return stringSet;
    }


    @Override
    public Boolean updateRoleTask(Integer roleid, List<String> taskCodeList) {
        //根据id 找到这个  role-task
        //roleMapper.selectOne(new LambdaQueryWrapper<Role>().eq(Role::getId,roleid));


        //根据 list 找到task对应id  并将它和role关联更新
        List<Integer> taskidList=new ArrayList<>();//new

        for (String name:taskCodeList) {
            taskidList.add(taskMapper.selectIdByName(name));
        }

        List<Integer> roletaskList = roleMapper.selectAllById(roleid);//old

        for (Integer taskid:taskidList) {
            if( !roleMapper.selectByIdAndTaskId(roleid,taskid) ){
                roleMapper.insertAllById(roleid,taskid);
            }
        }


        for (Integer taskid:roletaskList) {

           if( !taskidList.contains(taskid) ){
               if (taskMapper.deleteTaskRoleById(taskid,roleid) > 0){
                  log.info("更新权限中.....");
               }else {
                   log.info("更新权限失败");
                   throw new CustomException("更新权限失败");
               }

           }

        }

        return true;
    }

    @Override
    public Boolean updateUserRole(Integer userid, List<Integer> roleList) {

        List<Integer> roleuserList = userMapper.selectAllById(userid);

        for (Integer roleuserid:roleuserList) {

            if( !roleList.contains(roleuserid) ){
                if (taskMapper.deleteTaskRoleById(userid,roleuserid) > 0){
                    log.info("更新用户角色中.....");
                }else {
                    log.info("更新用户角色失败");
                    throw new CustomException("更新用户角色失败");
                }

            }

        }

        return true;
    }
}
