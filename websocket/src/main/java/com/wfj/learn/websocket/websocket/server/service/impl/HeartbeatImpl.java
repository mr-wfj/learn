package com.wfj.learn.websocket.websocket.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.wfj.learn.websocket.websocket.message.SocketMessage;
import com.wfj.learn.websocket.websocket.consts.SocketTypeConst;
import com.wfj.learn.websocket.websocket.server.service.SocketService;
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
