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
@Table(name = "Product")
public class ProductDto {//产品
    @Column(name = "allowDiscount")
    private Integer allowDiscount	;
    @Column(name = "categoryId")
    private Integer categoryId	;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "cover")
    private String cover;
    @Column(name = "description")
    private String description	;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "status")
    private Integer status ;

}
