package com.example.board_practice.message;

import lombok.Data;

@Data
public class MessageEntity {
    private StatusEnum status;
    private String message;
    private Object data;

    public MessageEntity() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
}