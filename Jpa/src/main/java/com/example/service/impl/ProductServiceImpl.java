package com.example.service.impl;

import com.example.common.ListDto;
import com.example.dto.UserDto;
import com.example.entity.Member;
import com.example.entity.Pagination;
import com.example.entity.Product;
import com.example.mapper.ProductMapper;
import com.example.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public ListDto<Product> selectAllByIdAndNameAndStatus(Integer categoryId, String name, Integer limit, Integer page, Integer status) {

        //limit  每页多少数据
        // offset  跳过多少数据
        // totalCount
        //totalPages  多少页
        //page

//        if(status == 0){
//            status = null;
//        }

        Integer aoffset;
        aoffset = (page - 1) * limit;



        Integer totalCount=productMapper.selectAllByIdAndNameAndStatus(categoryId,name,status);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
            totalPages= totalPages/limit;
            totalPages +=1;
        }

        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();
        List<Product> productsroduct = productMapper.selectAllByIdAndNameAndStatuspage(categoryId, name, status, limit, aoffset);


        return new ListDto<Product>(productsroduct,pagination);
    }
}
