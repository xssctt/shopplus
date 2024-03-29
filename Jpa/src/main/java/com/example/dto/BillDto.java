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
@Table(name = "bill")
public class BillDto {

    @Column(name = "createdAt")
    private String createdAt;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "id", type = IdType.AUTO)
    @Column(name = "id")
    @Id
    private Integer id	;

    @Column(name = "plateId")
    private Integer plateId	;

    @Column(name = "remark")
    private String remark	;

    @Column(name = "serviceType")
    private Integer serviceType	;

    @Column(name = "totalPerson")
    private Integer totalPerson	;
}
