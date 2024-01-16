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
@Table(name = "BookingPrefix")
public class BookingPrefixDto {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;//桌号名
    @Column(name = "prefix")
    private String prefix	;
    @Column(name = "turnout")
    private Integer turnout	;//客人数量
}
