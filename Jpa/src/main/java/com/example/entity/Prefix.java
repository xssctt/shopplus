package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lbw
 * @since 2024-01-01
 */
public class Prefix implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String prefix;

    private Integer status;

    private Integer tenantId;

    private Integer turnout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

    @Override
    public String toString() {
        return "Prefix{" +
        "id = " + id +
        ", name = " + name +
        ", prefix = " + prefix +
        ", status = " + status +
        ", tenantId = " + tenantId +
        ", turnout = " + turnout +
        "}";
    }
}
