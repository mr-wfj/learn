package com.wfj.learn.websocket.websocket.client.service.impl;

import com.alibaba.fastjson.JSON;
import com.wfj.learn.websocket.websocket.client.service.WebSocketClientService;
import com.wfj.learn.websocket.websocket.message.SocketMessage;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoketClient implements WebSocketClientService {

    @Autowired
    private WebSocketClient webSocketClient;

    @Override
    public void send(SocketMessage message) {
        webSocketClient.send(JSON.toJSONString(message));
    }
}
