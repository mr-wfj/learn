package com.wfj.learn.websocket.WebSocket.service.impl;

import com.alibaba.fastjson.JSON;
import com.wfj.learn.websocket.WebSocket.SocketMessage;
import com.wfj.learn.websocket.WebSocket.WebSocketServer;
import com.wfj.learn.websocket.WebSocket.consts.SocketTypeConst;
import com.wfj.learn.websocket.WebSocket.service.SocketService;
import com.wfj.learn.websocket.entity.Im;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component(SocketTypeConst.IM)
public class IMServiceImpl implements SocketService {

    private Logger logger = LoggerFactory.getLogger(IMServiceImpl.class);

    @Override
    public void onMessage(String message) {
        SocketMessage socketMessage = JSON.parseObject(message, SocketMessage.class);
        Im im = JSON.parseObject(String.valueOf(socketMessage.getData()), Im.class);
        logger.info("im ...{}", im);

        try {
            WebSocketServer.sendMessage(im.getRecipient(), im.getMsg());
        } catch (IOException e) {
            logger.error("im Exception", e);
        }

    }
}
