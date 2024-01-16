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
@Table(name = "CreateTenant")
public class CreateTenantDto {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "address")
    private String address;//地址

    @Column(name = "name")
    private String name;//商家名称

    @Column(name = "picture")
    private String picture;//封面图片

    @Column(name = "telephone")
    private String telephone;//电话
}
