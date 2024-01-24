package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.CardAndCategory;
import com.example.mapper.CardAndCategoryMapper;
import com.example.service.ICardAndCategoryService;
import org.springframework.stereotype.Service;

@Service
public class CardAndCategoryServiceImpl extends ServiceImpl<CardAndCategoryMapper, CardAndCategory> implements ICardAndCategoryService {

}
