package com.example.service.impl;

import com.example.entity.Count;
import com.example.mapper.CountMapper;
import com.example.service.ICountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CountServiceImpl extends ServiceImpl<CountMapper, Count> implements ICountService {

}
