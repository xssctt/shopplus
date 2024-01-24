package com.example.service;

import com.example.entity.BillOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IBillOrderService extends IService<BillOrder> {

    Boolean movenplate(Integer plateid,Integer oldplateid,Integer id);
}
