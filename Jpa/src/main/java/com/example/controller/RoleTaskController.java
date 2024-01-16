package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.dto.RoleDto;
import com.example.dto.Task;
import com.example.dto.TokenDto;
import com.example.entity.Role;
import com.example.execption.CustomException;
import com.example.service.IRoleService;
import com.example.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/passport/roleTask/")
public class RoleTaskController {

    @Resource
    ITaskService taskService;
    @Resource
    IRoleService roleService;

    //    GET
    ///passport/roleTask/allTask 所有权限
    @GetMapping("/allTask")
    public JsonResult<Map<String,String>> allTask() {
        Map<String,String> taskmap=new HashMap<>();
        List<Task> list = taskService.list(new LambdaQueryWrapper<>());
        for (Task t:list) {
            taskmap.put(t.getTaskname(),t.getSpec());
        }
        return new JsonResult<>(taskmap);
    }
    //    POST
    ///passport/roleTask/createRole 创建角色
    @PostMapping("/createRole")
    public JsonResult<RoleDto> createRole(String name,Integer sort,String spec) {

        if(roleService.getOne(new LambdaQueryWrapper<Role>().eq(Role::getName, name)) != null){
            log.info("角色已存在");
            //throw new CustomException("角色已存在");
            return new JsonResult("101","角色已存在");
        }else {
            if(roleService.save(Role.builder().sort(sort).spec(spec).status(1).name(name).build())){
                return new JsonResult<>();
            }else {
                log.info("角色创建失败");
                //throw new CustomException("角色创建失败");
                return new JsonResult("101","角色创建失败");
            }
        }

    }

        //    POST
    ///passport/roleTask/deleteRole 删除角色
    @PostMapping("/deleteRole")
    public JsonResult deleteRole(Integer roleid) {
        if(roleService.remove(new LambdaQueryWrapper<Role>().eq(Role::getId,roleid))){
            return new JsonResult<>("200","删除角色ok");
        }{
            log.info("删除角色失败");
            return new JsonResult("101","删除角色失败");
        }

    }

    //    POST
    ///passport/roleTask/disableRole 禁用角色
    @PostMapping("/disableRole")
    public JsonResult disableRole(Integer roleid) {
        LambdaUpdateWrapper<Role> roleLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        roleLambdaUpdateWrapper.set(Role::getStatus,2).eq(Role::getId,roleid);

        if(roleService.update(roleLambdaUpdateWrapper)){
            log.info("禁用角色ok");
            return new JsonResult<>("200","禁用角色ok");
        }else {
            log.info("禁用角色失败");
            return new JsonResult<>("1001","禁用角色失败");
        }
    }
    //    POST
    ///passport/roleTask/enableRole 启用角色
    @PostMapping("/enableRole")
    public JsonResult enableRole(Integer roleid) {
        LambdaUpdateWrapper<Role> roleLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        roleLambdaUpdateWrapper.set(Role::getStatus,1).eq(Role::getId,roleid);

        if(roleService.update(roleLambdaUpdateWrapper)){

            log.info("启用角色ok");
            return new JsonResult<>("200","启用角色ok");
        }else {
            log.info("启用角色失败");
            return new JsonResult<>("1001","启用角色失败");
        }
    }
    //    GET
    ///passport/roleTask/listRole 角色列表
    @GetMapping("/listRole")
    public JsonResult<ListDto<RoleDto>> listRole(Integer limit,Integer page,String name,String spec,Integer userid) {


        return new JsonResult<>(roleService.selectAllByNameAndUseridAndApec(limit,page,name,spec,userid));
    }

    //    GET
    ///passport/roleTask/listRoleTask 角色权限列表
    @GetMapping("/listRoleTask")
    public JsonResult<Set<String>> listRoleTask(Integer roleid) {
        return new JsonResult<>( roleService.selectAllById(roleid));
    }

    //    POST
    ///passport/roleTask/updateRole 更新角色信息
    @PostMapping("/updateRole")
    public JsonResult updateRole(Role role) {

        if(roleService.update(new LambdaUpdateWrapper<Role>()
                .set(Role::getName,role.getName())
                .set(Role::getSpec,role.getSpec())
                .set(Role::getSort,role.getSort())
                .eq(Role::getId,role.getId()))){
            log.info("更新角色信息ok");
            return new JsonResult<>("200","更新角色信息ok");
        }else {
            log.info("更新角色信息失败");
            return new JsonResult<>("1001","更新角色信息失败");
        }
    }

    //    POST
    ///passport/roleTask/updateRoleTask 更新角色权限

    @PostMapping("/updateRoleTask")
    public JsonResult updateRoleTask(Integer roleid,List<String> taskCodeList) {

        //roleService;
        if(roleService.updateRoleTask(roleid,taskCodeList)){
            log.info("更新角色权限ok");
            return new JsonResult<>("200","更新角色权限ok");
        }else {
            log.info("更新角色权限失败");
            return new JsonResult<>("1001","更新角色权限失败");
        }

    }

    //    POST
    ///passport/roleTask/updateUserRole 更新用户角色

    @PostMapping("/updateUserRole")
    public JsonResult updateUserRole(Integer userid,List<Integer> taskCodeList) {
        if(roleService.updateUserRole(userid,taskCodeList)){
            log.info("更新用户角色ok");
            return new JsonResult<>("200","更新用户角色ok");
        }else {
            log.info("更新用户角色失败");
            return new JsonResult<>("1001","更新用户角色失败");
        }
    }
}
