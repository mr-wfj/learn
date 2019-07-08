package com.wfj.learn.websocket.controller;

import com.wfj.learn.websocket.websocket.client.service.impl.ScoketClient;
import com.wfj.learn.websocket.websocket.consts.SocketTypeConst;
import com.wfj.learn.websocket.websocket.message.SocketMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/websocket/client")
public class WebSocketClientController {

    @Autowired
    private ScoketClient scoketClient;

    /**
     * 心跳
     *
     * @param message 消息
     * @return String
     */
    @PostMapping("/ok")
    String ok(String message) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        SocketMessage socketMessage = SocketMessage.builder().id(uuid).type(SocketTypeConst.HEARTBEAT).data(message).build();
        scoketClient.send(socketMessage);
        return "ok";
    }
}
