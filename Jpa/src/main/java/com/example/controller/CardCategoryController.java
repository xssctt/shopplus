package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.JsonResult;
import com.example.dto.CardCategoryDetailDto;
import com.example.dto.Cardcreatevo;
import com.example.entity.CardCategory;
import com.example.entity.Plan;
import com.example.service.ICardCategoryService;
import com.example.service.IPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
@RequestMapping("/member/cardCategory")
public class CardCategoryController {

    @Resource
    ICardCategoryService cardCategoryService;

    @Resource
    IPlanService planService;
//POST
///member/cardCategory/create 新增卡类
@PostMapping("/create")
public JsonResult<CardCategory> create(Cardcreatevo cardcreatevo) {

    cardCategoryService.addCardcreate(cardcreatevo);

    return  new JsonResult("200","");
}

//POST
///member/cardCategory/delete 删除卡类
@PostMapping("/delete")
public JsonResult delete(Integer cardid) {

    cardCategoryService.remove(new LambdaQueryWrapper<CardCategory>().eq(CardCategory::getId,cardid));

    return  new JsonResult("200","");
}
//POST
///member/cardCategory/detail 卡类详情
@PostMapping("/detail")
public JsonResult<CardCategoryDetailDto> detail( Integer cardid) {

    CardCategory cardCategory = cardCategoryService.getOne(new LambdaQueryWrapper<CardCategory>().eq(CardCategory::getId, cardid));
//
    Plan plan = planService.getOne(new LambdaQueryWrapper<Plan>().eq(Plan::getId, cardCategory.getPlanId()));
    //CardCategoryDetailDto.builder().cardCategory(cardCategory).planName(plan.getName()).build();

    return  new JsonResult(CardCategoryDetailDto.builder().cardCategory(cardCategory).planName(plan.getName()).build());
}

//POST
///member/cardCategory/disable 禁用卡类
@PostMapping("/disable")
public JsonResult disable( Integer cardid) {

    cardCategoryService.update(new LambdaUpdateWrapper<CardCategory>().set(CardCategory::getStatus,2).eq(CardCategory::getId,cardid));

    return  new JsonResult("200","");
}

//POST
///member/cardCategory/enable 启用卡类
@PostMapping("/enable")
public JsonResult enable(Integer cardid ) {
    cardCategoryService.update(new LambdaUpdateWrapper<CardCategory>().set(CardCategory::getStatus,1).eq(CardCategory::getId,cardid));


    return  new JsonResult("200","");
}

//GET
///member/cardCategory/list 卡类列表
@PostMapping("/list")
public JsonResult<List<CardCategory>> list(Integer status ) {
   // List<CardCategory> list = cardCategoryService.list(new LambdaQueryWrapper<CardCategory>().eq(CardCategory::getStatus, status));

    return  new JsonResult(cardCategoryService.list(new LambdaQueryWrapper<CardCategory>().eq(CardCategory::getStatus, status)));
}


}
