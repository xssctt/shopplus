package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.dto.PlateDto;
import com.example.entity.Area;
import com.example.entity.Craft;
import com.example.entity.Plate;
import com.example.service.IAreaService;
import com.example.service.IPlateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/manage/plate")
public class PlateController {

    @Resource
    IPlateService plateService;
//    @Resource
//    IAreaService areaService;

        //POST
        ///manage/plate/create 桌台创建
        @PostMapping("/create")
        public JsonResult create(Integer areaid,String name,Integer sort,Integer people) {

            plateService.create( areaid, name, sort, people);

            return  new JsonResult("200","");
        }

        //POST
        ///manage/plate/delete 桌台删除
        @PostMapping("/delete")
        public JsonResult delete(Integer plateid) {

            plateService.remove(new LambdaQueryWrapper<Plate>().eq(Plate::getId,plateid));
            return  new JsonResult("200","");
        }

        //GET
        ///manage/plate/detail 桌台详情
        @GetMapping("/detail")
        public JsonResult<PlateDto> detail(Integer plateid) {
           PlateDto plateDto=plateService.detail(plateid) ;
            return  new JsonResult(plateDto);
        }

        //POST
        ///manage/plate/disable 桌台停用
        @PostMapping("/disable")
        public JsonResult disable(Integer plateid) {
            plateService.update(new LambdaUpdateWrapper<Plate>().set(Plate::getStatus,2).eq(Plate::getId,plateid));
            return  new JsonResult("200","");
        }

        //POST
        ///manage/plate/enable 桌台启用
        @PostMapping("/enable")
        public JsonResult enable(Integer plateid) {
            plateService.update(new LambdaUpdateWrapper<Plate>().set(Plate::getStatus,1).eq(Plate::getId,plateid));
            return  new JsonResult("200","");
        }

        //GET
        ///manage/plate/list 桌台列表
        @GetMapping("/list")
        public JsonResult<ListDto<PlateDto>> list(@RequestParam(name = "areaid",required = false,defaultValue = "0") Integer areaid,String name, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status) {


            return  new JsonResult(plateService.selectAllByIdAndNameAndStatus(areaid,name,limit,page,status));
        }

        //POST  plate /空闲/开台/下单/结账
        ///manage/plate/reset 桌台重新恢复空闲状态
        @PostMapping("/reset")
        public JsonResult reset(Integer plateid) {

            plateService.update(new LambdaUpdateWrapper<Plate>().set(Plate::getUse,0).eq(Plate::getId,plateid));
            return  new JsonResult("200","");
        }

        //POST
        ///manage/plate/update 桌台信息更新
        @PostMapping("/update")
        public JsonResult update(Integer id,Integer areaid,String name,Integer sort,Integer people) {
            plateService.updateplate(id,areaid,name,sort,people);
            return  new JsonResult("200","");
        }

}
