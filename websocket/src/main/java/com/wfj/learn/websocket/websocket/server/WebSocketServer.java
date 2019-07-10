package com.wfj.learn.websocket.websocket.server;

import com.alibaba.fastjson.JSON;
import com.wfj.learn.websocket.websocket.message.SocketMessage;
import com.wfj.learn.websocket.websocket.server.service.SocketServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/ws/connect")
@Component
public class WebSocketServer {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<>();

    //  这里使用静态，让 service 属于类
    private static SocketServiceFactory socketServiceFactory;


    Map<String,Session> concurrentHashMap = new ConcurrentHashMap<>();


    // 注入的时候，给类的 service 注入
    @Autowired
    public void setChatService(SocketServiceFactory socketServiceFactory) {
        WebSocketServer.socketServiceFactory = socketServiceFactory;
    }


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        sessionSet.add(session);
        int cnt = onlineCount.incrementAndGet(); // 在线数加1
        logger.info("有连接加入，当前连接数为：{}", cnt);
        sendMessage(session, "连接成功");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        sessionSet.remove(session);
        int cnt = onlineCount.decrementAndGet();
        logger.info("有连接关闭，当前连接数为：{}", cnt);
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 消息
     * @param session Session
     */
    @OnMessage
    public void onMessage(String message, Session session) {

        logger.info("来自客户端 {} 的消息：{}", session.getId(), message);
        SocketMessage socketMessage = JSON.parseObject(message, SocketMessage.class);

        socketServiceFactory.getcontext(socketMessage.getType()).onMessage(message);

        sendMessage(session, "{" +
                "\"id\":" + socketMessage.getId() +
                "\",type\":" + socketMessage.getType() +
                '}');
    }

    /**
     * 出现错误
     *
     * @param session 消息
     * @param error   异常
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误：{}，Session ID： {}", error.getMessage(), session.getId());
        error.printStackTrace();
    }


    /**
     * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
     *
     * @param session Session
     * @param message 消息
     */
    private static void sendMessage(Session session, String message) {

        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.error("发送消息出错：{}", e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * 群发消息
     *
     * @param message 消息
     * @throws IOException Exception
     */
    public static void broadCastInfo(String message) throws IOException {
        for (Session session : sessionSet) {
            if (session.isOpen()) {
                sendMessage(session, message);
            }
        }
    }


    /**
     * 指定Session发送消息
     *
     * @param sessionId sessionId
     * @param message   消息
     * @throws IOException Exception
     */
    public static void sendMessage(String sessionId, String message) throws IOException {
        Session session = null;
        for (Session s : sessionSet) {
            if (s.getId().equals(sessionId)) {
                session = s;
                break;
            }
        }
        if (session != null) {
            sendMessage(session, message);
        } else {
            logger.warn("没有找到你指定ID的会话：{}", sessionId);
        }
    }


}
