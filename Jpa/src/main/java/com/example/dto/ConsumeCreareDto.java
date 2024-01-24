package com.example.dto;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ConsumeCreare")
public class ConsumeCreareDto {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Transient  //加工列表
    private Integer[] craftIdList;

    @Column(name = "productId")
    private Integer productId;//商品ID

    @Column(name = "quantity")
    private String quantity;//^[0-9]+(\.[0-9])?$数量

    @Column(name = "remark")
    private String remark;//备注

    @Column(name = "serviceType")
    private Integer serviceType;//服务方式：1、堂食，2、外卖


}
