package com.example.common;


import com.example.entity.Pagination;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Collections;
import java.util.List;

@JsonSerialize(using = ListDtoSerializer.class)
public class ListDto<T> {
    private List<T> list;
    private Pagination pagination;

    public ListDto() {
    }

    public ListDto(List<T> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
