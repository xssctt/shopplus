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
@TableName("booking_response")
public class BookingResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String appid;

    private String createdAt;

    private String date;

    private Integer lineUp;

    private String mobile;

    private String num;

    private String openid;

    private String qr;

    private Integer status;

    private Integer tenantId;

    private Integer turnout;

    private String updatedAt;

    private Integer waitTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getLineUp() {
        return lineUp;
    }

    public void setLineUp(Integer lineUp) {
        this.lineUp = lineUp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
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

    public Integer getTurnout() {
        return turnout;
    }

    public void setTurnout(Integer turnout) {
        this.turnout = turnout;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
        "id = " + id +
        ", appid = " + appid +
        ", createdAt = " + createdAt +
        ", date = " + date +
        ", lineUp = " + lineUp +
        ", mobile = " + mobile +
        ", num = " + num +
        ", openid = " + openid +
        ", qr = " + qr +
        ", status = " + status +
        ", tenantId = " + tenantId +
        ", turnout = " + turnout +
        ", updatedAt = " + updatedAt +
        ", waitTime = " + waitTime +
        "}";
    }
}
