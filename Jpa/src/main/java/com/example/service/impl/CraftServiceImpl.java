package com.example.service.impl;

import com.example.common.ListDto;
import com.example.entity.Category;
import com.example.entity.Craft;
import com.example.entity.Pagination;
import com.example.mapper.CraftMapper;
import com.example.service.ICraftService;
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
public class CraftServiceImpl extends ServiceImpl<CraftMapper, Craft> implements ICraftService {
    @Resource
    CraftMapper craftMapper;

    @Override
    public ListDto<Craft> selectAllByIdAndNameAndStatus(String name, Integer limit, Integer page, Integer status) {
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



        Integer totalCount=craftMapper.selectAllByIdAndNameAndStatus(name,status);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
            totalPages= totalPages/limit;
            totalPages +=1;
        }


        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();

        List<Craft> craftlist = craftMapper.selectAllByIdAndNameAndStatuspage( name, status, limit, aoffset);


        return new ListDto<Craft>(craftlist,pagination);
    }
}
