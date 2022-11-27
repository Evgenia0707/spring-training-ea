package com.cydeo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {//will see this info in API (obj what will see )

    private boolean success;
    private String message;
    private Integer code;
    private Object data;//implement any DTO


    public ResponseWrapper(String message, Object data){//constr to show return
        this.message = message;
        this.data = data;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message){
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }
}
