package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.common.JsonResult;
import com.example.dto.CardCategoryDto;
import com.example.dto.CardDto;
import com.example.entity.Card;
import com.example.entity.CardCategory;
import com.example.entity.Member;
import com.example.mapper.CardCategoryMapper;
import com.example.mapper.CardMapper;
import com.example.service.ICardCategoryService;
import com.example.service.ICardService;
import com.example.service.IMemberService;
import com.example.until.TimeUtil;
import com.example.until.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/member/card")
public class CardController {

    @Resource
    ICardService cardService;
    @Resource
    IMemberService memberService;
    @Resource
    ICardCategoryService cardCategoryService;

    @Resource
    CardMapper cardMapper;
    @Resource
    CardCategoryMapper cardCategoryMapper;


    //POST
    ///member/card/create 开卡  //余额 卡类id 会员id status
    @PostMapping("/create")
    public JsonResult<CardDto> create(String balance, Integer cardCategoryId , Integer memberId , Integer status) {

        return  new JsonResult( cardService.KaiKa(balance,cardCategoryId,memberId,status));
    }
    //POST
    ///member/card/delay 会员卡延期
    @PostMapping("/delay")
    public JsonResult delay(Integer cardid,Integer delayPeriod,String timeStamp) {


        return  new JsonResult("200","");
    }
    //POST
    ///member/card/delete 删除会员卡(退卡)
    @PostMapping("/delete")
    public JsonResult delete(Integer cardid) {

        cardService.remove(new LambdaQueryWrapper<Card>().eq(Card::getId,cardid));

        return  new JsonResult("200","");
    }
    //POST
    ///member/card/disable 禁用会员卡
    @PostMapping("/disable")
    public JsonResult disable(Integer cardid) {


        //boolean update = new LambdaUpdateChainWrapper<Card>(cardMapper).eq(Card::getId, cardid).set(Card::getStatus, 2).update();

        cardService.update(new LambdaUpdateWrapper<Card>().set(Card::getStatus,2).eq(Card::getId,cardid));


        return  new JsonResult("200","");
    }
    //POST
    ///member/card/enable 启用会员卡
    @PostMapping("/enable")
    public JsonResult enable(Integer cardid) {

        //boolean update = new LambdaUpdateChainWrapper<Card>(cardMapper).eq(Card::getId, cardid).set(Card::getStatus, 1).update();

        cardService.update(new LambdaUpdateWrapper<Card>().set(Card::getStatus,1).eq(Card::getId,cardid));


        return  new JsonResult("200","");
    }
    //GET
    ///member/card/list 会员卡列表
    @PostMapping("/list")
    public JsonResult<List<CardDto>> list(Integer memberId, Integer status) {

       // cardService.list(new LambdaQueryWrapper<Card>().eq(Card::));



        return  new JsonResult(cardCategoryService.listCard(memberId,status));
    }
}
