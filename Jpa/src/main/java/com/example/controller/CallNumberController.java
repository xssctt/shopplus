package com.example.controller;

import com.example.common.JsonResult;
import com.example.entity.Area;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/queuing/callnumber")
public class CallNumberController {
//    POST
///queuing/callnumber/delete 将一个或多个号删除
@PostMapping("/delete")
public JsonResult delete() {


    return  new JsonResult("200","");
}
//POST
///queuing/callnumber/sendmessage 给一个或多个号发公众号消息
@PostMapping("/sendmessage")
public JsonResult sendmessage( ) {


    return  new JsonResult("200","");
}
//POST
///queuing/callnumber/skip 将一个或多个号跳过
@PostMapping("/skip")
public JsonResult skip( ) {


    return  new JsonResult("200","");
}
//POST
///queuing/callnumber/used 将一个或多个号标记为使用过
@PostMapping("/used")
public JsonResult used( ) {


    return  new JsonResult("200","");
}
}
