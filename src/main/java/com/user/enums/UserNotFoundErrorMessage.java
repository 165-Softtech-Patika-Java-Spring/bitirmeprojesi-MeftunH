package com.user.enums;

import com.general.enums.BaseErrorMessage;

public enum  UserNotFoundErrorMessage implements BaseErrorMessage {
    UserNotFoundErrorMessage("User not found!",404);

    private String message;
    private int responseCode;
    UserNotFoundErrorMessage(String message,int responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
