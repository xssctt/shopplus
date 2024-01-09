package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member/activity")
public class ActivityController {

    // POST
    ///member/activity/changeStatus
    //停用/启用活动
    @PostMapping("/changeStatus")
    public void changeStatus(){

    }


    //POST
    ///member/activity/create
    //新建卡券营销活动
    @PostMapping("/create")
    public void create(){

    }

    //POST
    ///member/activity/delete
    //删除活动
    @PostMapping("/delete")
    public void delete(){

    }

    //GET
    ///member/activity/list
    //活动列表
    @GetMapping("/list")
    public List list(){

        return null;
    }



}
