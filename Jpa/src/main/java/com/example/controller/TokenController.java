package com.example.controller;

import com.example.common.JsonResult;
import com.example.dto.TokenDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passport/token/")
public class TokenController {

    //    POST/passport/token/createtokenCreate
    @PostMapping("/createtokenCreate")
    public JsonResult<TokenDto> createtokenCreate(){



        return new JsonResult<>(TokenDto.builder().build());
    }

    //    GET/passport/token/userIdgetUserIdByToken
    @GetMapping("/userIdgetUserIdByToken")
    public JsonResult userIdgetUserIdByToken(){

        return new JsonResult();
    }

}
