package com.example.controller;

import com.example.common.JsonResult;
import com.example.dto.TokenDto;
import com.example.service.IMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/passport/token/")
public class TokenController {

    @Resource
    IMemberService memberService;

    //    POST/passport/token/createtokenCreate
    @PostMapping("/create")
    public JsonResult<TokenDto> create(String username, String password, HttpServletResponse response){

        TokenDto tokenDto=memberService.createtokenCreate(username,password);
        String token=tokenDto.getToken();

        // 将token写入浏览器的Cookie中
        Cookie cookie = new Cookie("usertoken", token);
        cookie.setMaxAge(3600); // 设置Cookie的过期时间，单位为秒
        cookie.setPath("/"); // 设置Cookie的路径，这里是整个应用的根路径
        response.addCookie(cookie);
        return new JsonResult<>(tokenDto);
    }

    //    GET/passport/token/userIdgetUserIdByToken
    @GetMapping("/userIdgetUserIdByToken")
    public JsonResult userIdgetUserIdByToken(){

        return new JsonResult();
    }

}
