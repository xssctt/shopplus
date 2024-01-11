package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.common.Result;
import com.example.common.ThreadContxt;
import com.example.dto.TokenDto;
import com.example.dto.UserDto;
import com.example.dto.UserInfoDto;
import com.example.entity.Member;
import com.example.entity.Pagination;
import com.example.execption.CustomException;
import com.example.service.IMemberService;
import com.example.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/passport/user/")
public class UserController {

    @Resource
    IMemberService memberService;

    //    POST
    ///passport/user/create 用户新增
    @PostMapping("/create")
    public JsonResult<TokenDto> create(String username, String password){

        return new JsonResult<>( memberService.save(username,password) );
    }

    //    POST
    ///passport/user/delete 用户删除
    @PostMapping("/delete")
    public JsonResult delete(Integer userid){
       // LambdaQueryWrapper<Member> memberLambdaQueryWrapper=new LambdaQueryWrapper<Member>();
        if( memberService.remove(new LambdaQueryWrapper<Member>().eq(Member::getId,userid)) ){
            log.info("用户删除ok");
            return new JsonResult<>("200","用户删除ok");
        }else {
            log.info("用户删除失败");
            //throw new CustomException("用户删除失败");
            return new JsonResult<>("1001","用户删除失败");
        }
    }


    //    POST
    ///passport/user/disable 用户禁用
    @PostMapping("/disable")
    public JsonResult disable(Integer userid){
//        LambdaUpdateWrapper<Member> memberLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
//        memberLambdaUpdateWrapper.set(Member::getStatus,2).eq(Member::getId,userid);
//        memberService.update().set("status",2).eq("id",userid);
        if(memberService.updateStatusBoolean(userid,2)){
            log.info("用户禁用ok");
            return new JsonResult<>("200","用户禁用ok");
        }else {
            log.info("用户禁用失败");
            //throw new CustomException("用户禁用失败");
            return new JsonResult<>("1001","用户禁用失败");
        }

    }

    /*
    *         LambdaUpdateWrapper<Member> memberLambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        memberLambdaUpdateWrapper.set(Member::getStatus,2).eq(Member::getId,userid);
//        memberService.update().set("status",2).eq("id",userid);
        if(memberService.update(memberLambdaUpdateWrapper)){
            log.info("用户禁用ok");
            return new JsonResult<>();
        }else {
            log.info("用户禁用失败");
            throw new CustomException("用户禁用失败");
        }
    * */

    //    POST
    ///passport/user/enable 用户启用
    @PostMapping("/enable")
    public JsonResult enable(Integer userid){
        if(memberService.updateStatusBoolean(userid,1)){
            log.info("用户启用ok");
            return new JsonResult<>("200","用户启用ok");
        }else {
            log.info("用户启用");
            //throw new CustomException("用户启用失败");
            return new JsonResult("1001","用户启用失败");
        }
    }

    //    POST
    ///passport/user/list 用户列表
    @PostMapping("/list")
    public JsonResult<ListDto<UserDto>> list(Integer userid, String name,@RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status){


        return new JsonResult<>(memberService.selectAllByIdAndNameAndStatus(userid,name,status,limit,page));
    }


    //    GET
    ///passport/user/whoami 当前用户信息
    @PostMapping("/whoami")
    public JsonResult<UserInfoDto> whoami(HttpServletRequest request){

        Member member=ThreadContxt.getCruuser();

        return new JsonResult<>(UserInfoDto.builder().build());
    }


}
