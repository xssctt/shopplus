package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.common.ListDto;
import com.example.dto.ProductDto;
import com.example.dto.TokenDto;
import com.example.entity.Product;
import com.example.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/manage/product/")
public class ProductController {

    @Resource
    IProductService productService;


        //    POST
        ///manage/product/create 添加商品
        @PostMapping("/create")
        public JsonResult create(Product product) {

            productService.save(product);
            return  new JsonResult("200","");

        }

        //    POST
        ///manage/product/delete 删除商品
        @PostMapping("/delete")
        public JsonResult delete(Integer productId) {
            productService.remove(new LambdaQueryWrapper<Product>().eq(Product::getId,productId));
            return  new JsonResult("200","");
        }

        //    GET
        ///manage/product/detail 商品详情
        @GetMapping("/detail")
        public JsonResult<Product> detail(Integer produstid) {

            return  new JsonResult<>(productService.getOne(new LambdaQueryWrapper<Product>().eq(Product::getId,produstid)));
        }

        //    POST
        ///manage/product/halt 下架商品
        @PostMapping("/halt")
        public JsonResult halt(Integer produstid) {

            productService.update(new LambdaUpdateWrapper<Product>().set(Product::getStatus,2).eq(Product::getId,produstid));

            return  new JsonResult("200","");
        }

        //    GET
        ///manage/product/list 商品列表
        @GetMapping("/list")
        public JsonResult<ListDto<Product>> list(Integer categoryId, String name, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status) {


            return  new JsonResult<>(productService.selectAllByIdAndNameAndStatus(categoryId,name,limit,page,status));
        }

        //    POST
        ///manage/product/onSale  上架商品
        @PostMapping("/onSale")
        public JsonResult onSale(Integer produstid) {
            productService.update(new LambdaUpdateWrapper<Product>().set(Product::getStatus,1).eq(Product::getId,produstid));
            return  new JsonResult("200","");
        }


        //    POST
        ///manage/product/update 更新商品信息
        @PostMapping("/update")
        public JsonResult update(Product product) {

            productService.saveOrUpdate(product);

            return  new JsonResult("200","");
        }


}
