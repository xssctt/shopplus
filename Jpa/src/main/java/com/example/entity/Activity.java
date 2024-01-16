package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer couponId;

    private String couponName;

    private Integer createdAt;

    private Integer eventType;

    private Integer quantity;

    private Integer status;

    private Integer allotTogether;

    private String code;

    private String exchangeDate;

    private Integer memberId;

    private Integer orderId;

    private String reduceCost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAllotTogether() {
        return allotTogether;
    }

    public void setAllotTogether(Integer allotTogether) {
        this.allotTogether = allotTogether;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(String reduceCost) {
        this.reduceCost = reduceCost;
    }

    @Override
    public String toString() {
        return "Activity{" +
        "id = " + id +
        ", couponId = " + couponId +
        ", couponName = " + couponName +
        ", createdAt = " + createdAt +
        ", eventType = " + eventType +
        ", quantity = " + quantity +
        ", status = " + status +
        ", allotTogether = " + allotTogether +
        ", code = " + code +
        ", exchangeDate = " + exchangeDate +
        ", memberId = " + memberId +
        ", orderId = " + orderId +
        ", reduceCost = " + reduceCost +
        "}";
    }
}
