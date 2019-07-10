package com.wfj.learn.websocket.websocket.client.service;

import com.wfj.learn.websocket.websocket.message.SocketMessage;

/**
 * websocket client 接口
 */
public interface WebSocketClientService {
    
    /**
     * 发送
     *
     * @param message SocketMessage
     */
    void send(SocketMessage message);


}
