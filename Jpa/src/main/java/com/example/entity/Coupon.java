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
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer allotTogether;

    private String beginDate;

    private String createdAt;

    private String description;

    private Integer discount;

    private Integer distribute;

    private String endDate;

    private Integer fixedBeginTerm;

    private Integer fixedTerm;

    private String leastCost;

    private String name;

    private String notice;

    private Integer quantity;

    private String reduceCost;

    private String reduceMax;

    private Integer status;

    private Integer type;

    private Integer validType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAllotTogether() {
        return allotTogether;
    }

    public void setAllotTogether(Integer allotTogether) {
        this.allotTogether = allotTogether;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getDistribute() {
        return distribute;
    }

    public void setDistribute(Integer distribute) {
        this.distribute = distribute;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getFixedBeginTerm() {
        return fixedBeginTerm;
    }

    public void setFixedBeginTerm(Integer fixedBeginTerm) {
        this.fixedBeginTerm = fixedBeginTerm;
    }

    public Integer getFixedTerm() {
        return fixedTerm;
    }

    public void setFixedTerm(Integer fixedTerm) {
        this.fixedTerm = fixedTerm;
    }

    public String getLeastCost() {
        return leastCost;
    }

    public void setLeastCost(String leastCost) {
        this.leastCost = leastCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReduceCost() {
        return reduceCost;
    }

    public void setReduceCost(String reduceCost) {
        this.reduceCost = reduceCost;
    }

    public String getReduceMax() {
        return reduceMax;
    }

    public void setReduceMax(String reduceMax) {
        this.reduceMax = reduceMax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValidType() {
        return validType;
    }

    public void setValidType(Integer validType) {
        this.validType = validType;
    }

    @Override
    public String toString() {
        return "Coupon{" +
        "id = " + id +
        ", allotTogether = " + allotTogether +
        ", beginDate = " + beginDate +
        ", createdAt = " + createdAt +
        ", description = " + description +
        ", discount = " + discount +
        ", distribute = " + distribute +
        ", endDate = " + endDate +
        ", fixedBeginTerm = " + fixedBeginTerm +
        ", fixedTerm = " + fixedTerm +
        ", leastCost = " + leastCost +
        ", name = " + name +
        ", notice = " + notice +
        ", quantity = " + quantity +
        ", reduceCost = " + reduceCost +
        ", reduceMax = " + reduceMax +
        ", status = " + status +
        ", type = " + type +
        ", validType = " + validType +
        "}";
    }
}
