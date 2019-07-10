package com.wfj.learn.websocket.websocket.message;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SocketMessage<T> {

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
    private T data;

    public SocketMessage(String tye, T data) {
        this.type = tye;
        this.data = data;
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
