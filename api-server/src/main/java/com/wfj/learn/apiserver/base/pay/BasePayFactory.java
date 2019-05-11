package com.wfj.learn.apiserver.base.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: WFJ
 * @Date: 2019/4/28 15:45
 * @Description: 支付工厂
 */
@Component
public class BasePayFactory {

    /**
     * BasePay 实现类-会自动注入到context
     */
    @Autowired
    private Map<String, BasePay> context = new ConcurrentHashMap<>();

    public BasePay getcontext(String component) {
        BasePay basePay = context.get(component);
        if (basePay == null) {
            throw new RuntimeException("no basePay defined");
        }
        return basePay;
    }
}
