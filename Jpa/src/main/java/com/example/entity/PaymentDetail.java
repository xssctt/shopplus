package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("payment_detail")
public class PaymentDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String money;

    private String orderNumber;

    private Integer orderType;

    private Integer paymentChannelId;

    private String paymentChannelName;

    private String tradeNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPaymentChannelId() {
        return paymentChannelId;
    }

    public void setPaymentChannelId(Integer paymentChannelId) {
        this.paymentChannelId = paymentChannelId;
    }

    public String getPaymentChannelName() {
        return paymentChannelName;
    }

    public void setPaymentChannelName(String paymentChannelName) {
        this.paymentChannelName = paymentChannelName;
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" +
        "id = " + id +
        ", money = " + money +
        ", orderNumber = " + orderNumber +
        ", orderType = " + orderType +
        ", paymentChannelId = " + paymentChannelId +
        ", paymentChannelName = " + paymentChannelName +
        ", tradeNumber = " + tradeNumber +
        "}";
    }
}
