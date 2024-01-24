package com.example.controller;

import com.example.common.JsonResult;
import com.example.dto.BillOrderCompleteDto;
import com.example.dto.BillOrderDto;
import com.example.entity.BillOrderComplete;
import com.example.service.IBillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/operation/billOrder")
public class BillOrderController {

    @Resource
    IBillOrderService billOrderService;


    //GET
    ///operation/billOrder/calc 计算总费用
    @GetMapping("/calc")
    public JsonResult<BillOrderDto> calc(BillOrderComplete billOrderComplete) {
    //cardId 会员卡ID
    //discount 折扣金额  string
    //id 订单ID  //消费也有价格 账单也有价格
    //memberId 会员ID
    //percentage 折扣比例
    //remark 备注  string
    //smallChange 抹零，0为不抹零string


        //id 订单ID  //消费也有价格 账单也有价格
        //根据id查出数据信息  计算价格  查出会员信息  是否会员折扣  根据活动有折扣比例  折扣金额等  最后判断抹零


        return  new JsonResult();
    }
    //POST
    ///operation/billOrder/complete 订单结算
    @PostMapping("/complete")
    public JsonResult complete() {



        return  new JsonResult("200","");
    }
    //POST
    ///operation/billOrder/create 订单创建
    @PostMapping("/create")
    public JsonResult create() {



        return  new JsonResult("200","");
    }
    //GET
    ///operation/billOrder/detail 订单详情
    @GetMapping("/detail")
    public JsonResult detail() {



        return  new JsonResult("200","");
    }
    //GET
    ///operation/billOrder/list 账单列表
    @GetMapping("/list")
    public JsonResult list() {



        return  new JsonResult("200","");
    }
    //POST
    ///operation/billOrder/update 订单更新
    @PostMapping("/update")
    public JsonResult update() {



        return  new JsonResult("200","");
    }
    //POST
    ///operation/billOrder/void 订单作废
    @PostMapping("/void")
    public JsonResult BillOrdervoid() {



        return  new JsonResult("200","");
    }
}
