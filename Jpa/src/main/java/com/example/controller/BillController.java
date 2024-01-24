package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.JsonResult;
import com.example.entity.Bill;
import com.example.entity.BillOrder;
import com.example.service.IBillOrderCompleteService;
import com.example.service.IBillOrderService;
import com.example.service.IBillService;
import com.example.until.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/operation/bill")
public class BillController {


    @Resource
    IBillService billService;
    @Resource
    IBillOrderService billOrderService;
//    @Resource
//    IBillOrderCompleteService billOrderCompleteService;

    //    POST
    ///operation/bill/complete  账单完成 //用于和台结账
    @PostMapping("/complete")
    public JsonResult complete(List<Integer> billIdList) {








        return  new JsonResult("200","");
    }
    //    POST
    ///operation/bill/create 账单创建
    @PostMapping("/create")
    public JsonResult create(Integer plateId,String remark,Integer serviceType,Integer totalPerson) {

        billService.save(Bill.builder()
                .serviceType(serviceType)
                .createdAt(TimeUtil.NowTimeToString())
                .plateId(plateId).remark(remark)
                .totalPerson(totalPerson).build());



        return  new JsonResult("200","");
    }
    //    GET
    ///operation/bill/detail 账单详情
    @GetMapping("/detail")
    public JsonResult<Bill> detail(Integer billid) {

        return  new JsonResult(billService.getOne(new LambdaQueryWrapper<Bill>().eq(Bill::getId,billid)));
    }
    //    GET
    ///operation/bill/list 账单列表
    @GetMapping("/list")
    public JsonResult list() {










        return  new JsonResult("200","");
    }
    //    POST
    ///operation/bill/movingPlate 移台接口
    @PostMapping("/movingPlate")
    public JsonResult movingPlate(Integer plateid,Integer oldplateid,Integer id) {

        billOrderService.movenplate(plateid,oldplateid,id);

        return  new JsonResult("200","");
    }
    //    POST
    ///operation/bill/update 账单更新
    @PostMapping("/update")
    public JsonResult update(Integer id,Integer plateId,String remark,Integer serviceType , Integer totalPerson ) {

        billService.saveOrUpdate(Bill.builder().id(id).serviceType(serviceType).totalPerson(totalPerson).remark(remark).plateId(plateId).build());


        return  new JsonResult("200","");
    }
    //    POST
    ///operation/bill/void 账单作废
    @PostMapping("/void")
    public JsonResult Billvoid(Integer billid) {

        //billid 状态改变
        billService.remove(new LambdaQueryWrapper<Bill>().eq(Bill::getId,billid));

        return  new JsonResult("200","");
    }


}
