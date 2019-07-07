package com.wfj.learn.websocket.entity;

import lombok.Data;

@Data
public class Im {

    /**
     * 发送者
     */
    private String sender;
    /**
     * 接收者
     */
    private String recipient;

    /**
     * 消息
     */
    private String msg;
}
