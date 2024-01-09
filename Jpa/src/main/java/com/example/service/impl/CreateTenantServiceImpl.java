package com.example.service.impl;

import com.example.entity.CreateTenant;
import com.example.mapper.CreateTenantMapper;
import com.example.service.ICreateTenantService;
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
public class CreateTenantServiceImpl extends ServiceImpl<CreateTenantMapper, CreateTenant> implements ICreateTenantService {

}
