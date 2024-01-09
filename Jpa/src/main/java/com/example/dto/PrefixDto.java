package com.example.dto;

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
@Table(name = "Prefix")
public class PrefixDto {//前缀

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;
    @Column(name = "name")
    private String name	;
    @Column(name = "prefix")
    private String prefix	;
    @Column(name = "status")
    private Integer status;
    @Column(name = "tenantId")
    private Integer tenantId;
    @Column(name = "turnout")
    private Integer turnout	;

}
