package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lzx
 * @date 2020/5/13 14:39
 * @Description TODO
 **/
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
    @Bean
    public RouteLocator routes2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu_guoji",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"));
        return routes.build();
    }
}
