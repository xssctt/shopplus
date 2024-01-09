package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("recharge_order")
public class RechargeOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cardCategoryName;

    private Integer cardId;

    private String createdAt;

    private String money;

    private String number;

    private Integer paymentStatus;

    private Integer status;

    private Integer tenantId;

    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardCategoryName() {
        return cardCategoryName;
    }

    public void setCardCategoryName(String cardCategoryName) {
        this.cardCategoryName = cardCategoryName;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "RechargeOrder{" +
        "id = " + id +
        ", cardCategoryName = " + cardCategoryName +
        ", cardId = " + cardId +
        ", createdAt = " + createdAt +
        ", money = " + money +
        ", number = " + number +
        ", paymentStatus = " + paymentStatus +
        ", status = " + status +
        ", tenantId = " + tenantId +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
