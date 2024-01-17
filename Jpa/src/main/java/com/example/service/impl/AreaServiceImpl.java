package com.example.service.impl;

import com.example.common.ListDto;
import com.example.entity.Area;
import com.example.entity.Craft;
import com.example.entity.Pagination;
import com.example.mapper.AreaMapper;
import com.example.service.IAreaService;
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
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {

    @Resource
    AreaMapper areaMapper;
    @Override
    public ListDto<Area> selectAllByIdAndNameAndStatus(String name, Integer limit, Integer page, Integer status) {
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



        Integer totalCount=areaMapper.selectAllByIdAndNameAndStatus(name,status);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
            totalPages= totalPages/limit;
            totalPages +=1;
        }


        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();

        List<Area> arealist = areaMapper.selectAllByIdAndNameAndStatuspage( name, status, limit, aoffset);


        return new ListDto<Area>(arealist,pagination);
    }
}
