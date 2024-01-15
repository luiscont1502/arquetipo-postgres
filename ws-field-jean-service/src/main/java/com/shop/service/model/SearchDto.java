package com.shop.service.model;

import lombok.Data;

@Data
public class SearchDto {
    private static final long serialVersionUID = 1L;

    private Integer page;
    private Integer size;
    private String order;
    private String data;
    private String filter;
    private String state;
    private Integer code;
    private Integer value;


}
