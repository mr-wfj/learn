package com.wfj.learn.websocket.WebSocket.service.impl;

import com.alibaba.fastjson.JSON;
import com.wfj.learn.websocket.WebSocket.SocketMessage;
import com.wfj.learn.websocket.WebSocket.consts.SocketTypeConst;
import com.wfj.learn.websocket.WebSocket.service.SocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(SocketTypeConst.HEARTBEAT)
public class HeartbeatImpl implements SocketService {

    private Logger logger = LoggerFactory.getLogger(HeartbeatImpl.class);

    @Override
    public void onMessage(String message) {
        SocketMessage socketMessage = JSON.parseObject(message, SocketMessage.class);
        logger.info("心跳 ... {}", socketMessage);
    }
}
