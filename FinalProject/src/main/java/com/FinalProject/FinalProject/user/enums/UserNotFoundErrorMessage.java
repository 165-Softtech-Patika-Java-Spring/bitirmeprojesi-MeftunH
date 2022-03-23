package com.FinalProject.FinalProject.user.enums;

import com.FinalProject.FinalProject.general.enums.BaseErrorMessage;

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
