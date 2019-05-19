package com.wfj.learn.gateway.config;

import com.wfj.learn.gateway.filter.JwtGlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitBean {

    @Bean
    public JwtGlobalFilter tokenFilter() {
        return new JwtGlobalFilter();
    }
    
}
