package com.fandou.springboot.validation.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    private String code;
    private String message;
    private T data;
}
