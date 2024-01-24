package com.example.service.impl;

import com.example.entity.BillOrder;
import com.example.mapper.BillOrderMapper;
import com.example.service.IBillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Service
public class BillOrderServiceImpl extends ServiceImpl<BillOrderMapper, BillOrder> implements IBillOrderService {

    @Override
    public Boolean movenplate(Integer plateid, Integer oldplateid, Integer id) {
        //账单id  ---》  桌台更换
        //桌台id --》 信息清除  状态改为已结账  --》 需清台
        return null;
    }
}
