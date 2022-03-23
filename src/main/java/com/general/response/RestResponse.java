package com.general.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> implements Serializable {

    private T data;
    private Date responseDate;
    private boolean isSuccess;
    private String messages;
    private int responseCode;

    public RestResponse(T data, boolean isSuccess,int responseCode) {
        this.data = data;
        this.isSuccess = isSuccess;
        responseDate = new Date();
        this.responseCode = responseCode;
    }
    public static <T> RestResponse<T> success(T t){
        return new RestResponse<>(t, true,200);
    }

    public static <T> RestResponse<T> error(T t,int responseCode){
        return new RestResponse<>(t, false,responseCode);
    }

    public static <T> RestResponse<T> empty(int responseCode){
        return new RestResponse<>(null, true,responseCode);
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
