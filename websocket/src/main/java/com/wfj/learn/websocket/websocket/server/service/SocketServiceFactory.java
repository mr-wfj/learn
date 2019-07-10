package com.wfj.learn.websocket.websocket.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SocketServiceFactory {

    /**
     * SocketService 实现类-会自动注入到context
     */
    @Autowired
    private Map<String, com.wfj.learn.websocket.websocket.server.service.SocketService> context = new ConcurrentHashMap<>();

    public com.wfj.learn.websocket.websocket.server.service.SocketService getcontext(String component) {
        com.wfj.learn.websocket.websocket.server.service.SocketService socketService = context.get(component);
        if (socketService == null) {
            throw new RuntimeException("no socketService defined");
        }
        return socketService;
    }
}
