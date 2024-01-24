package com.example.service;

import com.example.common.ListDto;
import com.example.entity.Product;
import com.example.entity.Tenant;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface ITenantService extends IService<Tenant> {
    ListDto<Tenant> selectAllByIdAndNameAndStatus(String telephone, String name, Integer limit, Integer page, Integer status);
}
