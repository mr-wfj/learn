package com.wfj.learn.websocket.websocket.consts;

/**
 * @Author: WFJ
 * @Date: 2019/7/10 11:48
 * @Description: Socket 消息 类型-常量
 */
public final class SocketTypeConst {
    private SocketTypeConst() {
    }

    /**
     * 登录
     */
    public static final String LOGIN = "LOGIN";

    /**
     * 心跳
     */
    public static final String HEARTBEAT = "HEARTBEAT";

    /**
     * IM - 聊天
     */
    public static final String IM = "IM";


    /**
     * 获取用户信息
     */
    public static final String getuser = "GETUSER";

}
