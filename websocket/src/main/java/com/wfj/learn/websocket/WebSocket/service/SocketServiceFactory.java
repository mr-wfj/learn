package com.wfj.learn.websocket.WebSocket.service;

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
    private Map<String, SocketService> context = new ConcurrentHashMap<>();

    public SocketService getcontext(String component) {
        SocketService socketService = context.get(component);
        if (socketService == null) {
            throw new RuntimeException("no socketService defined");
        }
        return socketService;
    }
}
