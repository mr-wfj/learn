package com.wfj.learn.websocket.websocket.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.wfj.learn.websocket.websocket.message.SocketMessage;
import com.wfj.learn.websocket.websocket.server.WebSocketServer;
import com.wfj.learn.websocket.websocket.consts.SocketTypeConst;
import com.wfj.learn.websocket.websocket.server.service.SocketService;
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
