package com.hui.bobcat.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author lihui
 * @title: GatewayConfiguration
 * @projectName self_discipline_freedom
 * @description: TODO
 * @date 2020/12/914:27
 */
@Component
public class GatewayConfiguration {

    /**
     * 初始化限流或者降级的回调函数
     */
    @PostConstruct
    public void doInit(){
        //设置限流或者降级的回调函数
        GatewayCallbackManager.setBlockHandler(new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
                return ServerResponse.status(200).syncBody("系统繁忙，请稍后");
            }
        });
    }
}
