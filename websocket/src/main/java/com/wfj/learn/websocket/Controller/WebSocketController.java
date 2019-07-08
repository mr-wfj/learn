package com.wfj.learn.websocket.controller;

import com.wfj.learn.websocket.websocket.server.WebSocketServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ws")
public class WebSocketController {


    /**
     * 群发消息
     *
     * @param message 消息
     * @return
     */
    @PostMapping("/sendAll")
    String sendAllMessage(@RequestParam(required = true) String message) {
        try {
            WebSocketServer.broadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 指定会话ID发消息
     *
     * @param message 消息
     * @param id      sessionId
     * @return String
     */
    @PostMapping("/sendOne")
    String sendOneMessage(@RequestParam(required = true) String message, @RequestParam(required = true) String id) {
        try {
            WebSocketServer.sendMessage(id, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
