package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.common.ThreadContxt;
import com.example.dto.TenantDto;
import com.example.dto.TokenDto;
import com.example.dto.UserDto;
import com.example.dto.UserInfoDto;
import com.example.entity.Member;
import com.example.entity.Product;
import com.example.entity.Tenant;
import com.example.service.IMemberService;
import com.example.service.ITenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/platform/tenant/")
public class TenantController {
    @Resource
    ITenantService tenantService;
//    POST
///platform/tenant/create 新增租户
@PostMapping("/create")
public JsonResult<Tenant> create(Tenant tenant){

    tenantService.save(tenant);
    return  new JsonResult("200","");
}

//    POST
///platform/tenant/delete 删除租户
@PostMapping("/delete")
public JsonResult delete(Integer tenantid){
    tenantService.remove(new LambdaQueryWrapper<Tenant>().eq(Tenant::getId,tenantid));
    return  new JsonResult("200","");
}



//    POST
///platform/tenant/disable 禁用租户

    @PostMapping("/disable")
    public JsonResult disable(Integer tenantid){
        tenantService.update(new LambdaUpdateWrapper<Tenant>().set(Tenant::getStatus,2).eq(Tenant::getId,tenantid));

        return  new JsonResult("200","");

    }

//    POST
///platform/tenant/enable 启用租户
@PostMapping("/enable")
public JsonResult enable(Integer tenantid){
    tenantService.update(new LambdaUpdateWrapper<Tenant>().set(Tenant::getStatus,1).eq(Tenant::getId,tenantid));

    return  new JsonResult("200","");
}

//    POST
///platform/tenant/list 租户列表
@PostMapping("/list")
public JsonResult<ListDto<Tenant>> list(String telephone, String name, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status){


    return new JsonResult<>(tenantService.selectAllByIdAndNameAndStatus(telephone,name,status,limit,page));
}



//    POST
///platform/tenant/update 编辑租户基础信息
@PostMapping("/update")
public JsonResult update(Tenant tenant) {

    tenantService.saveOrUpdate(tenant);

    return  new JsonResult("200","");
}









}
