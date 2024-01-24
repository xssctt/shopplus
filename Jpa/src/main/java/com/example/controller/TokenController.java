package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.JsonResult;
import com.example.common.ThreadContxt;
import com.example.dto.TokenDto;
import com.example.entity.Member;
import com.example.entity.Tenant;
import com.example.mapper.MemberMapper;
import com.example.mapper.TenantMapper;
import com.example.service.IMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/passport/token")
public class TokenController {

    @Resource
    IMemberService memberService;
    @Resource
    MemberMapper memberMapper;
    @Resource
    TenantMapper tenantMapper;

    //    POST/passport/token/createtokenCreate
    @PostMapping("/create")
    public JsonResult<TokenDto> create(String username, String password, HttpServletResponse response){

        TokenDto tokenDto=memberService.createtokenCreate(username,password);
        String token=tokenDto.getToken();

        Member member = memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getName, username));
        ThreadContxt.setCruuser(member);

        // 将token写入浏览器的Cookie中
        Cookie cookie = new Cookie("usertoken", token);
        cookie.setMaxAge(3600); // 设置Cookie的过期时间，单位为秒
        cookie.setPath("/"); // 设置Cookie的路径，这里是整个应用的根路径
        response.addCookie(cookie);
        return new JsonResult<>(tokenDto);
    }

    //    GET/passport/token/userIdgetUserIdByToken
    @GetMapping("/userIdgetUserIdByToken")
    public JsonResult<Map<String,String>> userIdgetUserIdByToken(HttpServletRequest request){
//"userId": 1,
//        "userName": "admin",
//        "userMobile": "",
//        "userEmail": "",
//        "userAvatar": "",
//        "userCreatedAt": "2023-04-08 14:17:48",
//        "userUpdatedAt": "2023-05-06 16:31:37",
//        "tenantId": 1,
//        "tenantName": "22212312312",
//        "tenantPhone": "222 123123",
//        "tenantAddress": "22123123",
//        "tenantStatus": 1,
//        "tenantCreatedAt": "2023-04-08 14:17:48",
//        "tenantUpdatedAt": "2023-05-19 23:07:14",
//        "userStatus": 1
        Member cruuser = ThreadContxt.getCruuser();
        Member member = memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getName, cruuser.getName()));
        Tenant tenant = tenantMapper.selectOne(new LambdaQueryWrapper<Tenant>().eq(Tenant::getUserId, member.getId()));

        Map<String,String> map=new HashMap<>();
        map.put("userId", String.valueOf(member.getId()));
        map.put("userName", String.valueOf(member.getName()));
        map.put("userMobile", String.valueOf(member.getMobile()));
       // map.put("userEmail", String.valueOf(member.get()));
        map.put("userAvatar", String.valueOf(member.getAvatar()));
        map.put("userCreatedAt", String.valueOf(member.getCreateAt()));
        map.put("userUpdatedAt", String.valueOf(member.getUpdateAt()));
        map.put("userStatus", String.valueOf(member.getStatus()));
        map.put("tenantId", String.valueOf(tenant.getId()));
        map.put("tenantPhone", String.valueOf(tenant.getTelephone()));
        map.put("tenantName", String.valueOf(tenant.getName()));
        map.put("tenantAddress", String.valueOf(tenant.getName()));
        map.put("tenantStatus", String.valueOf(tenant.getStatus()));
        map.put("tenantCreatedAt", String.valueOf(tenant.getCreatedAt()));
        map.put("tenantUpdatedAt", String.valueOf(tenant.getUpdatedAt()));




        return new JsonResult(map);
    }

}
