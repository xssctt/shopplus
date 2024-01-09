package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
@TableName("bill_order")
public class BillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String address;

    private String areaName;

    private Integer cardId;

    private String createdAt;

    private String discount;

    private Integer memberId;

    private String name;

    private String number;

    private String paymentStatus;

    private Integer percentage;

    private Integer plateId;

    private String plateName;

    private String productFee;

    private String remark;

    private String smallChange;

    private String status;

    private String telephone;

    private String totalFee;

    private String totalPerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getProductFee() {
        return productFee;
    }

    public void setProductFee(String productFee) {
        this.productFee = productFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSmallChange() {
        return smallChange;
    }

    public void setSmallChange(String smallChange) {
        this.smallChange = smallChange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTotalPerson() {
        return totalPerson;
    }

    public void setTotalPerson(String totalPerson) {
        this.totalPerson = totalPerson;
    }

    @Override
    public String toString() {
        return "BillOrder{" +
        "id = " + id +
        ", address = " + address +
        ", areaName = " + areaName +
        ", cardId = " + cardId +
        ", createdAt = " + createdAt +
        ", discount = " + discount +
        ", memberId = " + memberId +
        ", name = " + name +
        ", number = " + number +
        ", paymentStatus = " + paymentStatus +
        ", percentage = " + percentage +
        ", plateId = " + plateId +
        ", plateName = " + plateName +
        ", productFee = " + productFee +
        ", remark = " + remark +
        ", smallChange = " + smallChange +
        ", status = " + status +
        ", telephone = " + telephone +
        ", totalFee = " + totalFee +
        ", totalPerson = " + totalPerson +
        "}";
    }
}
