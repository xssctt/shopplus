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
@TableName("booking_prefix")
public class BookingPrefix implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String prefix;

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

    public Integer getTurnout() {
        return turnout;
    }

    public void setTurnout(Integer turnout) {
        this.turnout = turnout;
    }

    @Override
    public String toString() {
        return "BookingPrefix{" +
        "id = " + id +
        ", name = " + name +
        ", prefix = " + prefix +
        ", turnout = " + turnout +
        "}";
    }
}
