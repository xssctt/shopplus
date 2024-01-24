package com.example.service;

import com.example.dto.CardDto;
import com.example.entity.Card;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface ICardService extends IService<Card> {

    CardDto KaiKa(String balance, Integer cardCategoryId, Integer memberId, Integer status);
}
