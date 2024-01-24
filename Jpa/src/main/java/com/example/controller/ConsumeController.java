package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.dto.ConsumeCreareDto;
import com.example.dto.ConsumeDto;
import com.example.entity.Consume;
import com.example.entity.ConsumeCreare;
import com.example.service.IConsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/operation/consume")
public class ConsumeController {

    @Resource
    IConsumeService consumeService;

    //POST
    ///operation/consume/create 消费新增
    @PostMapping("/create")
    public JsonResult create(Integer billId, List<ConsumeCreareDto> consumeCreareList) {


       if( consumeService.consumecreate(billId,consumeCreareList) ){
           return  new JsonResult("200","ok");
       }else {
           return  new JsonResult("1001","no");
       }

    }

    //GET
    ///operation/consume/detail 消费详情
    @GetMapping("/detail")
    public JsonResult<ConsumeDto> detail(Integer consumeid) {


        return  new JsonResult(consumeService.consumedetail(consumeid));
    }


    //GET
    ///operation/consume/list 消费列表
    @GetMapping("/list")   //状态：0、全部，1、正常，2、退单   || paymentStatus 支付状态：1、未支付，2、支付中，3已支付(多选  多个状态的) || processStatus  加工状态：0、全部，1、排队中，2、准备中，3准备完成
    public JsonResult<ListDto<ConsumeDto>> list(List<Integer> billIdList, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status, List<Integer> paymentStatus, Integer processStatus) {

        consumeService.consumelist(billIdList,limit,page,status,paymentStatus,processStatus);


        return  new JsonResult("200","");
    }


    //POST
    ///operation/consume/update 消费更新
    @PostMapping("/update")
    public JsonResult update(List<Integer> craftIdList,Integer id,Integer quantity,String remark) {

       consumeService.updateConsume(craftIdList,id,quantity,remark);

        return  new JsonResult("200","");
    }

    //POST
    ///operation/consume/void 消费作废
    @PostMapping("/void")
    public JsonResult Consumevoid(Integer consumeid) {

        consumeService.remove(new LambdaQueryWrapper<Consume>().eq(Consume::getId,consumeid));

        return  new JsonResult("200","ok");
    }


}
