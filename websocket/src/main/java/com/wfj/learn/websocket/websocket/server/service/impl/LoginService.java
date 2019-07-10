package com.wfj.learn.websocket.websocket.server.service.impl;

import com.wfj.learn.websocket.websocket.consts.SocketTypeConst;
import com.wfj.learn.websocket.websocket.server.service.SocketService;
import org.springframework.stereotype.Component;

/**
 * @Author: WFJ
 * @Date: 2019/7/10 14:39
 * @Description:
 */
@Component(SocketTypeConst.LOGIN)
public class LoginService implements SocketService {
    
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message SocketMessage
     */
    @Override
    public void onMessage(String message) {

    }
}
