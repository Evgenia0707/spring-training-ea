package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ResponseWrapper {// what client want to see - put thos fields

    private boolean success;
    private String message;//if success return message(your ..success)
    private Integer code;//my status code
    private Object data;// Obj class - bec want able to sent in diff type//sending dto object

    public ResponseWrapper(String message, Object data){
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
    }
}
