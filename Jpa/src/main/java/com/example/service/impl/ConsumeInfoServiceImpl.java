package com.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.ConsumeInfo;

import com.example.mapper.ConsumeInfoMapper;


import com.example.service.IConsumeInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Service
public class ConsumeInfoServiceImpl extends ServiceImpl<ConsumeInfoMapper, ConsumeInfo> implements IConsumeInfoService {

}
