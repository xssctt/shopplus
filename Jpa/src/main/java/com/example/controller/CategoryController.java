package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/manage/category/")
public class CategoryController {

    @Resource
    ICategoryService categoryService;

        //    POST
        ///manage/category/create 分类新增
        @PostMapping("/create")
        public JsonResult create(Category category) {

            categoryService.save(category);
            return  new JsonResult("200","");
        }

        //POST
        ///manage/category/delete 分类删除
        @PostMapping("/delete")
        public JsonResult delete(Integer categoryid) {

            categoryService.remove(new LambdaQueryWrapper<Category>().eq(Category::getId,categoryid));
            return  new JsonResult("200","");
        }

        //GET
        ///manage/category/detail 分类详情
        @GetMapping("/detail")
        public JsonResult<Category> detail(Integer categoryid) {


            return  new JsonResult(categoryService.getOne(new LambdaQueryWrapper<Category>().eq(Category::getId,categoryid)));
        }

        //POST
        ///manage/category/disable 分类隐藏
        @PostMapping("/disable")
        public JsonResult disable(Integer categoryid) {
            categoryService.update(new LambdaUpdateWrapper<Category>().set(Category::getStatus,2).eq(Category::getId,categoryid));
            return  new JsonResult("200","");
        }

        //POST
        ///manage/category/enable 分类显示
        @PostMapping("/enable")
        public JsonResult enable(Integer categoryid) {
            categoryService.update(new LambdaUpdateWrapper<Category>().set(Category::getStatus,1).eq(Category::getId,categoryid));
            return  new JsonResult("200","");
        }


        //GET
        ///manage/category/list 分类列表
        @GetMapping("/list")
        public JsonResult<ListDto<Category>> list(String name, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status) {


            return  new JsonResult<>(categoryService.selectAllByIdAndNameAndStatus(name,limit,page,status));
        }

        //POST
        ///manage/category/update 分类信息更新
        @PostMapping("/update")
        public JsonResult update(Category category) {
            categoryService.saveOrUpdate(category);
            return  new JsonResult("200","");
        }


}
