package com.wfj.learn.websocket.websocket.server.service;

import org.springframework.stereotype.Component;

@Component
public interface SocketService {

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message SocketMessage
     */
    void onMessage(String message);

}
