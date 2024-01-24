package com.example.controller;

import com.example.common.JsonResult;
import com.example.dto.BookingPrefixCreateDto;
import com.example.dto.BookingPrefixDto;
import com.example.dto.BookingResponseDto;
import com.example.entity.BookingPrefix;
import com.example.entity.Craft;
import com.example.service.IBookingPrefixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/queuing/bookingPrefi")
public class BookingPrefixController {
    @Resource
    IBookingPrefixService bookingPrefixService;

//    POST
///queuing/bookingPrefix/create 排号前缀新增
@PostMapping("/create")
public JsonResult create(BookingPrefix bookingPrefix) {


    return  new JsonResult("200","");
}
//POST
///queuing/bookingPrefix/delete 排号前缀删除

//POST
///queuing/bookingPrefix/disable 禁用排号前缀

//POST
///queuing/bookingPrefix/enable 启用排号前缀

//GET
///queuing/bookingPrefix/list 排号前缀列表

//POST
///queuing/bookingPrefix/update 排号前缀信息更新

}
