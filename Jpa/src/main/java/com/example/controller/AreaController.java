package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.entity.Area;
import com.example.entity.Craft;
import com.example.service.IAreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/manage/area/")
public class AreaController {

    @Resource
    IAreaService areaService;
    //    POST
    ///manage/area/create 区域创建

    @PostMapping("/create")
    public JsonResult create(Area area) {

        areaService.save(area);
        return  new JsonResult("200","");
    }

    //POST
    ///manage/area/delete 区域删除
    @PostMapping("/delete")
    public JsonResult delete(Integer areaid) {

        areaService.remove(new LambdaQueryWrapper<Area>().eq(Area::getId,areaid));
        return  new JsonResult("200","");
    }


    //GET
    ///manage/area/detail 区域详情
    @GetMapping("/detail")
    public JsonResult<Area> detail(Integer areaid) {

        areaService.getOne(new LambdaQueryWrapper<Area>().eq(Area::getId,areaid));
        return  new JsonResult("200","");
    }

    //POST
    ///manage/area/disable 区域停用
    @PostMapping("/disable")
    public JsonResult disable(Integer areaid) {

        areaService.update(new LambdaUpdateWrapper<Area>().set(Area::getStatus,2).eq(Area::getId,areaid));
        return  new JsonResult("200","");
    }


    //POST
    ///manage/area/enable 区域启用
    @PostMapping("/enable")
    public JsonResult enable(Integer areaid) {

        areaService.update(new LambdaUpdateWrapper<Area>().set(Area::getStatus,1).eq(Area::getId,areaid));
        return  new JsonResult("200","");
    }


    //GET
    ///manage/area/list 区域列表
    @GetMapping("/list")
    public JsonResult<ListDto<Area>> list(String name, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status) {

        return  new JsonResult(areaService.selectAllByIdAndNameAndStatus(name,limit,page,status));
    }

    //POST
    ///manage/area/update 区域信息更新
    @PostMapping("/update")
    public JsonResult update(Area area) {

        areaService.saveOrUpdate(area);
        return  new JsonResult("200","");
    }


}
