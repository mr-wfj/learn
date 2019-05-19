package com.wfj.learn.gateway.filter;

import com.wfj.learn.gateway.consts.JwtConst;
import com.wfj.learn.gateway.result.Result;
import com.wfj.learn.gateway.result.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * 全局过滤器:JWT-token 验证
 */
public class JwtGlobalFilter implements GlobalFilter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(JwtGlobalFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("JwtGlobalFilter ...");

        ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst(JwtConst.AUTH_HEADER);

        if (StringUtils.isNotEmpty(token) && token.startsWith(JwtConst.TOKEN_HEAD)) {
            token = token.substring(JwtConst.TOKEN_HEAD_LENGTH);
        } else {
            logger.info("认证失败,token:{},格式错误", token);
            
            // 不按规范,不允许通过验证
            token = null;
        }

        if (token == null || token.isEmpty()) {

            logger.info("认证失败:{}", token);

            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            // 指定 JSON类型 UTF-8编码
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");

            Result result = Result.failure(ResultCode.VERIFY_CODE_FAILURE);
            DataBuffer buffer = response.bufferFactory().wrap(result.toString().getBytes(StandardCharsets.UTF_8));

            return response.writeWith(Mono.just(buffer));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
