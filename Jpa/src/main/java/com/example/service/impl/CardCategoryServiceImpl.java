package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.ThreadContxt;
import com.example.dto.CardCategoryDto;
import com.example.dto.CardDto;
import com.example.dto.Cardcreatevo;
import com.example.entity.*;
import com.example.mapper.*;
import com.example.service.ICardCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.until.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Service
public class CardCategoryServiceImpl extends ServiceImpl<CardCategoryMapper, CardCategory> implements ICardCategoryService {


    @Resource
    CardCategoryMapper cardCategoryMapper;

    @Resource
    CardMapper cardMapper;

    @Resource
    MemberMapper memberMapper;

    @Resource
    TenantMapper tenantMapper;

    @Resource
    CardAndCategoryMapper cardAndCategoryMapper;

    @Override
    public CardCategory addCardcreate(Cardcreatevo cardcreatevo) {
        //discount //消费折扣比例
        //discountType *  //折扣类型
        //durationDay //自领取后多少天内有效
        //intervalDay //领取后多少天开始生效
        //name * //卡类名称
        // planId //折扣方案
        // pointPercentage * //积分比例
        // remark //备注
        // sort //排序
        // status //状态
        // validType *  //有效期类型
        Member cruuser = ThreadContxt.getCruuser();
        Member member = memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getName, cruuser.getName()));
        Tenant tenant = tenantMapper.selectOne(new LambdaQueryWrapper<Tenant>().eq(Tenant::getUserId, member.getId()));

        CardCategory cardCategory= CardCategory.builder()
                .createdAt(TimeUtil.NowTimeToString()).updatedAt(TimeUtil.NowTimeToString())
                .discount(cardcreatevo.getDiscount()).discountType(cardcreatevo.getDiscountType())
                .durationDay(cardcreatevo.getDurationDay()).intervalDay(cardcreatevo.getIntervalDay())
                .pointPercentage(cardcreatevo.getPointPercentage())
                .remark(cardcreatevo.getRemark()).sort(cardcreatevo.getSort())
                .name(cardcreatevo.getName()).status(cardcreatevo.getStatus())
                .planId(cardcreatevo.getPlanId()).tenantId(tenant.getId())
                .validType(cardcreatevo.getValidType())
                .build();

        cardCategoryMapper.insert(cardCategory);

        return cardCategory;
    }

    @Override
    public Boolean saveCard() {
        return null;
    }

    @Override
    public List<CardDto> listCard(Integer memberId, Integer status) {


        List<CardAndCategory> cardAndCategories = cardAndCategoryMapper.selectList(new LambdaQueryWrapper<CardAndCategory>()
                .eq(CardAndCategory::getMemberid, memberId)
                .eq(CardAndCategory::getStatus, status));

        List<CardDto> cardDtoList=new ArrayList<>();

        for (CardAndCategory c:cardAndCategories) {

            //c.getCardid();
            Card card = cardMapper.selectOne(new LambdaQueryWrapper<Card>().eq(Card::getId, c.getCardid()));
            c.getCategoryid();
            CardCategory cardCategory = cardCategoryMapper.selectOne(new LambdaQueryWrapper<CardCategory>().eq(CardCategory::getId, c.getCategoryid()));


            CardCategoryDto cardCategoryDto=CardCategoryDto.builder()
                    .cardCategoryName(cardCategory.getName())
                    .discount(cardCategory.getDiscount())
                    .remark(cardCategory.getRemark())
                    .build();

            CardDto cardDto=CardDto.builder()
                    .cardCategoryDto(cardCategoryDto)
                    .availableEnd(card.getAvailableEnd()).availableStart(card.getAvailableStart())
                    .balance(card.getBalance()).number(card.getNumber()).status(card.getStatus())
                    .build();


            cardDtoList.add(cardDto);

        }

        //  List<Card> cards = cardCategoryMapper.listCard(memberId, status);

        return null;
    }
}
