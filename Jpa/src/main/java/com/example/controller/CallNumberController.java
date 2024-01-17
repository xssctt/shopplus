package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/manage/plate")
public class CallNumberController {
//    POST
///queuing/callnumber/delete 将一个或多个号删除

//POST
///queuing/callnumber/sendmessage 给一个或多个号发公众号消息

//POST
///queuing/callnumber/skip 将一个或多个号跳过

//POST
///queuing/callnumber/used 将一个或多个号标记为使用过

}
