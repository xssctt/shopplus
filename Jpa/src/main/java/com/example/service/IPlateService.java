package com.example.service;

import com.example.common.ListDto;
import com.example.dto.PlateDto;
import com.example.entity.Craft;
import com.example.entity.Plate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IPlateService extends IService<Plate> {

    Boolean create(Integer areaid,String name,Integer sort,Integer people);

    Boolean updateplate(Integer id,Integer areaid,String name,Integer sort,Integer people);

    PlateDto detail(Integer plateid);

    ListDto<PlateDto> selectAllByIdAndNameAndStatus(Integer areaid,String name, Integer limit, Integer page, Integer status);

}
