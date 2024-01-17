package com.example.service;

import com.example.common.ListDto;
import com.example.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Product;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface ICategoryService extends IService<Category> {

    ListDto<Category> selectAllByIdAndNameAndStatus( String name, Integer limit, Integer page, Integer status);
}
