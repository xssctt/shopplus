package com.example.controller;

import com.example.common.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/buffet/memberConsume")
public class MemberConsumeController {

    //POST
    ///buffet/memberConsume/billCreate 账单创建
    @PostMapping("/billCreate")
    public JsonResult billCreate() {



        return  new JsonResult("200","");
    }
    //GET
    ///buffet/memberConsume/category/list 菜品分类列表
    @GetMapping("/category/list")
    public JsonResult categoryList() {



        return  new JsonResult("200","");
    }
    //GET
    ///buffet/memberConsume/checkPlate 确认桌台状态
    @GetMapping("/checkPlate")
    public JsonResult checkPlate() {



        return  new JsonResult("200","");
    }
    //POST
    ///buffet/memberConsume/consumeCreate 消费新增
    @PostMapping("/consumeCreate")
    public JsonResult consumeCreate() {



        return  new JsonResult("200","");
    }
    //GET
    ///buffet/memberConsume/craft/list 加工方式列表
    @GetMapping("/craft/list")
    public JsonResult craftList() {



        return  new JsonResult("200","");
    }
    //GET
    ///buffet/memberConsume/list 消费列表
    @GetMapping("/list")
    public JsonResult list() {



        return  new JsonResult("200","");
    }
    //GET
    ///buffet/memberConsume/plate 桌台的消费列表
    @GetMapping("/plate")
    public JsonResult plate() {



        return  new JsonResult("200","");
    }
    //GET
    ///buffet/memberConsume/product/list 商品列表
    @GetMapping("/product/list")
    public JsonResult productList() {



        return  new JsonResult("200","");
    }


}
