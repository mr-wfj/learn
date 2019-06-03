package com.wfj.learn.gateway.cache;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: WFJ
 * @Date: 2019/5/29 13:44
 * @Description: 用户信息-缓存
 */
@Data
@Builder
public class UserInfo {

    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 设备唯一标识:必填
     */
    private String uniqueSn;
    /**
     * 推送标识
     */
    private String pushSign;
    /**
     * 开启推送
     */
    private Boolean pushOpen;

}
