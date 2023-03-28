package com.execinema.restfulapi_cinetown.api.model;

public class CustomMessageDTO {

    private String message;

    public CustomMessageDTO(String message) {
        this.message = message;
    }

    public CustomMessageDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomMessageDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
