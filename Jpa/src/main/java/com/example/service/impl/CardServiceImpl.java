package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.dto.CardCategoryDto;
import com.example.dto.CardDto;
import com.example.entity.Card;
import com.example.entity.CardCategory;
import com.example.entity.Member;
import com.example.mapper.CardCategoryMapper;
import com.example.mapper.CardMapper;
import com.example.mapper.MemberMapper;
import com.example.service.ICardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.until.TimeUtil;
import com.example.until.ValidateCodeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Service
public class CardServiceImpl extends ServiceImpl<CardMapper, Card> implements ICardService {

    @Resource
    CardCategoryMapper cardCategoryMapper;
    @Resource
    CardMapper cardMapper;
    @Resource
    MemberMapper memberMapper;

    @Override
    public CardDto KaiKa(String balance, Integer cardCategoryId, Integer memberId, Integer status) {
        Card card=Card.builder()
                .availableEnd(TimeUtil.NextTimeToString(1)).availableStart(TimeUtil.NowTimeToString())
                .balance(balance).status(status).number(ValidateCodeUtils.generateValidateCode4String(16)).build();

        cardMapper.insert(card);

        Integer cardid = cardMapper.selectOne(new LambdaQueryWrapper<Card>().eq(Card::getNumber, card.getNumber())).getId();

        CardCategory cardCategory = cardCategoryMapper.selectOne(new LambdaQueryWrapper<CardCategory>().eq(CardCategory::getId, cardCategoryId));

        cardCategoryMapper.insertCardidAndCategory(cardid,cardCategoryId,memberId,status);


        Member member = memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getId, memberId));

        member.setIdCard(card.getNumber());

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

        return cardDto;
    }
}
