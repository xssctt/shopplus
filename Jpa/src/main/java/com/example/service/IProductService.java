package com.example.service;

import com.example.common.ListDto;
import com.example.dto.UserDto;
import com.example.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IProductService extends IService<Product> {

    ListDto<Product> selectAllByIdAndNameAndStatus(Integer categoryId, String name, Integer limit, Integer page, Integer status);
}
