package com.shop.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;



public class ResponseData<T> extends ResponseModel {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private T data;

    public ResponseData(String code){
        super(code);
    }


}
