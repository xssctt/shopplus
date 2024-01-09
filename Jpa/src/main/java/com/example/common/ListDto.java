package com.example.common;


import com.example.entity.Pagination;

public class ListDto<T> {
    private T list;
    private Pagination pagination;

    public ListDto() {
    }

    public ListDto(T list,Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }
}
