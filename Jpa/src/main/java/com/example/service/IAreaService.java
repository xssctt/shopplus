package com.example.service;

import com.example.common.ListDto;
import com.example.entity.Area;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Craft;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IAreaService extends IService<Area> {
    ListDto<Area> selectAllByIdAndNameAndStatus(String name, Integer limit, Integer page, Integer status);
}
