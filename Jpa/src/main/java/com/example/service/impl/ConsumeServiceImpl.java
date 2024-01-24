package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.common.ListDto;
import com.example.common.ThreadContxt;
import com.example.dto.BillDto;
import com.example.dto.ConsumeInfoDto;
import com.example.dto.ConsumeCreareDto;
import com.example.dto.ConsumeDto;
import com.example.entity.*;
import com.example.mapper.*;
import com.example.service.IConsumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.until.StringCNumlist;
import com.example.until.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ConsumeServiceImpl extends ServiceImpl<ConsumeMapper, Consume> implements IConsumeService {

    @Resource
    ConsumeMapper consumeMapper;

    @Resource
    ProductMapper productMapper;

    @Resource
    ConsumeCraftMapper consumeCraftMapper;

    @Resource
    CraftMapper craftMapper;

    @Resource
    ConsumeInfoMapper consumeInfoMapper;

    @Resource
    BillOrderMapper billOrderMapper;
    @Resource
    BillMapper billMapper;
    @Resource
    MemberMapper memberMapper;
    @Resource
    TenantMapper tenantMapper;



    @Override
    public Boolean consumecreate(Integer billId, List<ConsumeCreareDto> consumeCreareList) {

        //billId 账单id
        for (ConsumeCreareDto c:consumeCreareList) {
            //加工列表
            // 商品ID
            //数量
            //备注
            //服务方式：1、堂食，2、外卖//默认堂食
            String serviceType=new String();
            switch (c.getServiceType()){
                case 1:
                    serviceType="堂食";
                    break;
                case 2:
                    serviceType="外卖";
                    break;
                default:
                    serviceType="外卖";
                    break;
            }

            Product product = productMapper.selectOne(new LambdaQueryWrapper<Product>().eq(Product::getId, c.getProductId()));
            Integer basePrice= Integer.parseInt(c.getQuantity()) * Integer.parseInt(product.getPrice());
            Integer price=basePrice*1;
            consumeMapper.insert(Consume.builder()
                    .billId(billId)
                    .basePrice(String.valueOf(basePrice)).price(String.valueOf(price))
                    .createdAt(TimeUtil.NowTimeToString())
                    .productId(product.getId()).productName(product.getName()).quantity(c.getQuantity())
                    .remark(c.getRemark()+serviceType).build());

            Consume consume = consumeMapper.selectOne(new LambdaQueryWrapper<Consume>().eq(Consume::getProductId, product.getId()).eq(Consume::getProductName, product.getName()));

            Integer[] craftIdList = c.getCraftIdList();
            String craftname="";
            for (Integer craftid:craftIdList) {
                craftname += craftMapper.selectOne( new LambdaQueryWrapper<Craft>().eq(Craft::getId,craftid) ).getName();
                consumeCraftMapper.insert(ConsumeCraft.builder().consumeid(consume.getId()).craftid(craftid).build());
            }
            //String craftids=StringCNumlist.NumToString(Arrays.asList(craftIdList));
                    //craftIdList.toString().substring(1,craftIdList.toString().length()-1);

            Bill bill = billMapper.selectOne(new LambdaQueryWrapper<Bill>().eq(Bill::getId, billId));
            Member member= ThreadContxt.getCruuser();
            //whoami  -->   member || tenantid
            Member cruusera = ThreadContxt.getCruuser();
            Member membera = memberMapper.selectOne(new LambdaQueryWrapper<Member>().eq(Member::getName, cruusera.getName()));
            Tenant tenanta = tenantMapper.selectOne(new LambdaQueryWrapper<Tenant>().eq(Tenant::getUserId, membera.getId()));


            consumeInfoMapper.insert(ConsumeInfo.builder()
                    .billId(billId).memberId(member.getId()).planId(null).plateId(bill.getPlateId()).tenantId(tenanta.getId()).sellerId(null).creatorId(null)
                    .basePrice(String.valueOf(basePrice)).price(String.valueOf(price))
                    .allowDiscount(product.getAllowDiscount()).craft(craftIdList.toString()).createdAt(TimeUtil.NowTimeToString()).updatedAt(TimeUtil.NowTimeToString())
                    .paymentStatus(1).processStatus(1).status(1)
                    .productId(product.getId()).productName(product.getName())
                    .remark(c.getRemark()).quantity(c.getQuantity()).serviceType(c.getServiceType())
                    .build());

        }

        return true;
    }

    @Override
    public ConsumeDto consumedetail(Integer consumeid) {
        Consume consume = consumeMapper.selectOne(new LambdaQueryWrapper<Consume>().eq(Consume::getId, consumeid));
        List<ConsumeCraft> consumeCrafts = consumeCraftMapper.selectList(new LambdaQueryWrapper<ConsumeCraft>().eq(ConsumeCraft::getConsumeid,consumeid));
        List<Craft> craftList=new ArrayList<>();

        for (ConsumeCraft c:consumeCrafts) {
            craftList.add(craftMapper.selectOne(new LambdaQueryWrapper<Craft>().eq(Craft::getId,c.getCraftid())));
        }



        return ConsumeDto.builder().basePrice(consume.getBasePrice()).price(consume.getPrice())
                .billId(consume.getBillId())
                .craft(craftList)
                .createdAt(consume.getCreatedAt())
                .productId(consume.getProductId()).productName(consume.getProductName()).quantity(consume.getQuantity())
                .remark(consume.getRemark()).build();
    }

    @Override
    public Boolean updateConsume(List<Integer> craftIdList, Integer id, Integer quantity, String remark) {



        consumeMapper.update(null,new LambdaUpdateWrapper<Consume>()
                .set(Consume::getQuantity,quantity)
                .set(Consume::getRemark,remark)
                .eq(Consume::getId,id));
        List<Integer> oldCraftids = consumeCraftMapper.selectListByconsumeid(id);

        for (Integer craftid:craftIdList) {
            if(consumeCraftMapper.selectOne(new LambdaQueryWrapper<ConsumeCraft>()
                    .eq(ConsumeCraft::getConsumeid, id)
                    .eq(ConsumeCraft::getCraftid, craftid)) ==null){
             consumeCraftMapper.insert(ConsumeCraft.builder().craftid(craftid).consumeid(id).build());
            }

        }

        for (Integer craftid:oldCraftids) {
            if( !craftIdList.contains(craftid)){
                consumeCraftMapper.delete(new LambdaQueryWrapper<ConsumeCraft>().eq(ConsumeCraft::getConsumeid,id).eq(ConsumeCraft::getCraftid,craftid));
            }

        }

        return true;
    }

    @Override
    public ListDto<ConsumeDto> consumelist(List<Integer> billIdList, @RequestParam(name = "limit",defaultValue = "20") Integer limit, Integer page, Integer status, List<Integer> paymentStatus, Integer processStatus) {

        Pagination pagination=new Pagination();
       // List<Consume> consumeroduct =new ArrayList<>();
        List<ConsumeDto> consumeDtoroduct=new ArrayList<>();

            Integer aoffset;
            aoffset = (page - 1) * limit;
            Integer totalCount = consumeInfoMapper.selectAllByAllStatus(billIdList,status,paymentStatus,processStatus);


            Integer totalPages = totalCount;
            if (totalCount % limit != 0){
                totalPages= totalPages/limit;
                totalPages +=1;
            }



            //ConsumeDto.builder().build();

             pagination=Pagination.builder().total(totalPages).page(page).limit(limit).build();
            List<ConsumeInfo> consumeInfos = consumeInfoMapper.selectAllByIdAndNameAndStatuspage(billIdList, status, paymentStatus, processStatus, limit, aoffset);

            for (ConsumeInfo info:consumeInfos) {
                List<Integer> craftidList = StringCNumlist.StringToNumlist(info.getCraft());
                List<Craft> craftList=new ArrayList<>();
                for (Integer craftid:craftidList) {
                    craftList.add( craftMapper.selectOne( new LambdaQueryWrapper<Craft>().eq(Craft::getId,craftid) ) );
                }

                consumeDtoroduct.add(ConsumeDto.builder()
                        .id(info.getId())
                        .quantity(info.getQuantity()).productName(info.getProductName()).productId(info.getProductId())
                        .billId(info.getBillId()).basePrice(info.getBasePrice()).price(info.getPrice())
                        .remark(info.getRemark()).createdAt(info.getCreatedAt())
                        .craft(craftList)
                        .build());
            }




        return new ListDto<ConsumeDto>(consumeDtoroduct,pagination);
    }


}
