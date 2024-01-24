package com.example.service;

import com.example.common.ListDto;
import com.example.dto.ConsumeCreareDto;
import com.example.dto.ConsumeDto;
import com.example.entity.Consume;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public interface IConsumeService extends IService<Consume> {

    Boolean consumecreate(Integer billId, List<ConsumeCreareDto> consumeCreareList);

    ConsumeDto consumedetail(Integer consumeid);

    Boolean updateConsume(List<Integer> craftIdList,Integer id,Integer quantity,String remark);

    ListDto<ConsumeDto> consumelist(List<Integer> billIdList,
                                    @RequestParam(name = "limit",defaultValue = "20") Integer limit,
                                    Integer page, Integer status,
                                    List<Integer> paymentStatus,
                                    Integer processStatus);
    }
