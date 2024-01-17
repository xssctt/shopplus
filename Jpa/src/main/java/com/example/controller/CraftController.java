package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.ListDto;
import com.example.entity.Craft;
import org.springframework.web.bind.annotation.*;
import com.example.common.JsonResult;
import com.example.entity.Category;
import com.example.service.ICraftService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */

@Slf4j
@RestController
@RequestMapping("/manage/craft")
public class CraftController {

    @Resource
    ICraftService craftService;

    //    POST
    ///manage/craft/create 加工方式创建
    @PostMapping("/create")
    public JsonResult create(Craft craft) {

        craftService.save(craft);
        return  new JsonResult("200","");
    }
    //POST
    ///manage/craft/delete 加工方式删除
    @PostMapping("/delete")
    public JsonResult delete(Integer craftid) {

        craftService.remove(new LambdaQueryWrapper<Craft>().eq(Craft::getId,craftid));
        return  new JsonResult("200","");
    }
    //GET
    ///manage/craft/detail 加工方式详情
    @GetMapping("/detail")
    public JsonResult<Craft> detail(Integer craftid) {


        return  new JsonResult(craftService.getOne(new LambdaQueryWrapper<Craft>().eq(Craft::getId,craftid)));
    }

    //POST
    ///manage/craft/disable 加工方式停用
    @PostMapping("/disable")
    public JsonResult disable(Integer craftid) {

        craftService.update(new LambdaUpdateWrapper<Craft>().set(Craft::getStatus,2).eq(Craft::getId,craftid));
        return  new JsonResult("200","");
    }

    //POST
    ///manage/craft/enable 加工方式启用
    @PostMapping("/enable")
    public JsonResult enable(Integer craftid) {

        craftService.update(new LambdaUpdateWrapper<Craft>().set(Craft::getStatus,1).eq(Craft::getId,craftid));
        return  new JsonResult("200","");
    }

    //GET
    ///manage/craft/list 加工方式列表
    @GetMapping("/list")
    public JsonResult<ListDto<Craft>> list(String name, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status) {

        return  new JsonResult(craftService.selectAllByIdAndNameAndStatus(name,limit,page,status));
    }

    //POST
    ///manage/craft/update 加工方式信息更新
    @PostMapping("/update")
    public JsonResult update(Craft craft) {

        craftService.saveOrUpdate(craft);
        return  new JsonResult("200","");
    }

}
