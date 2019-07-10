package com.wfj.learn.websocket.websocket.message;

import lombok.Data;

@Data
public class SocketMessage {

    /**
     * 消息ID;
     */
    private String id;

    /**
     * 类型:SocketTypeConst
     */
    private String type;

    /**
     * 数据
     */
    private Object data;

    public SocketMessage() {

    }

    public SocketMessage(String id, String tye, Object data) {
        this.id = id;
        this.type = tye;
        this.data = data;
    }

    public SocketMessage(String id, String tye) {
        this.id = id;
        this.type = tye;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"type\":" + type +
                ", \"data\":" + data +
                '}';
    }
}
