package com.example.service;

import com.example.common.ListDto;
import com.example.entity.Category;
import com.example.entity.Craft;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface ICraftService extends IService<Craft> {
    ListDto<Craft> selectAllByIdAndNameAndStatus(String name, Integer limit, Integer page, Integer status);
}
