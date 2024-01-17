package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.ListDto;
import com.example.dto.PlateDto;
import com.example.entity.Area;
import com.example.entity.Craft;
import com.example.entity.Pagination;
import com.example.entity.Plate;
import com.example.mapper.AreaMapper;
import com.example.mapper.PlateMapper;
import com.example.service.IPlateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.until.TimeUtil;
import com.example.until.ValidateCodeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Service
public class PlateServiceImpl extends ServiceImpl<PlateMapper, Plate> implements IPlateService {

    @Resource
    PlateMapper plateMapper;
    @Resource
    AreaMapper areaMapper;
    @Override
    public Boolean create(Integer areaid, String name, Integer sort, Integer people) {

        Integer tentanid=1;

        Plate plate=Plate.builder()
                .name(name).areaId(areaid).people(people).sort(sort)
                .createdAt(TimeUtil.NowTimeToString()).updatedAt(TimeUtil.NowTimeToString())
                .tenantId(tentanid).use(0).code(ValidateCodeUtils.getNumToken()).status(1)
                .build();

        if ( plateMapper.insert(plate) > 0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Boolean updateplate(Integer id, Integer areaid, String name, Integer sort, Integer people) {




        if ( plateMapper.update(null, new LambdaUpdateWrapper<Plate>()
                .set(Plate::getAreaId,areaid)
                .set(Plate::getName,name)
                .set(Plate::getSort,sort)
                .set(Plate::getPeople,people).eq(Plate::getId,id)) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public PlateDto detail(Integer plateid) {
        Plate plate = plateMapper.selectOne(new LambdaQueryWrapper<Plate>().eq(Plate::getId, plateid));

        String areaName=areaMapper.selectOne(new LambdaQueryWrapper<Area>().eq(Area::getId,plate.getAreaId())).getName();
        return PlateDto.builder()
                .id(plate.getId())
                .name(plate.getName()).areaName(areaName)
                .areaId(plate.getAreaId())
                .code(plate.getCode()).people(plate.getPeople())
                .sort(plate.getSort()).status(plate.getStatus())
                .use(plate.getUse())
                .build();
    }

    @Override
    public ListDto<PlateDto> selectAllByIdAndNameAndStatus(Integer areaid, String name, Integer limit, Integer page, Integer status) {
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



        Integer totalCount=plateMapper.selectAllByIdAndNameAndStatus(areaid,name,status);

        Integer totalPages = totalCount;
        if (totalCount % limit != 0){
            totalPages= totalPages/limit;
            totalPages +=1;
        }


        Pagination pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();

        List<PlateDto> craftlist = plateMapper.selectAllByIdAndNameAndStatuspage( areaid, name, status, limit, aoffset);


        return new ListDto<PlateDto>(craftlist,pagination);
    }


}
