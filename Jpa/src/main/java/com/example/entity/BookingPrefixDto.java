package com.example.entity;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
