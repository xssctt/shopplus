package com.example.service.impl;

import com.example.common.ListDto;
import com.example.entity.Pagination;
import com.example.entity.Product;
import com.example.entity.Tenant;
import com.example.mapper.TenantMapper;
import com.example.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

    @Resource
    TenantMapper tenantMapper;

    @Override
    public ListDto<Tenant> selectAllByIdAndNameAndStatus(String telephone, String name, Integer limit, Integer page, Integer status) {


        Integer aoffset;
        aoffset = (page - 1) * limit;



        Integer totalCount=tenantMapper.selectAllByIdAndNameAndStatus(telephone,name,status);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
            totalPages= totalPages/limit;
            totalPages +=1;
        }

        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();
        List<Tenant> tenantroduct = tenantMapper.selectAllByIdAndNameAndStatuspage(telephone, name, status, limit, aoffset);


        return new ListDto<Tenant>(tenantroduct,pagination);
    }
}
