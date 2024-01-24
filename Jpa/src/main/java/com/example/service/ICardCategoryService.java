package com.example.service;

import com.example.common.ListDto;
import com.example.dto.CardDto;
import com.example.dto.Cardcreatevo;
import com.example.entity.CardCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Product;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface ICardCategoryService extends IService<CardCategory> {


    CardCategory addCardcreate(Cardcreatevo cardcreatevo);
    Boolean saveCard();

    List<CardDto> listCard(Integer memberId, Integer status);
}
