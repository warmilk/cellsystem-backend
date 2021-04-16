package com.kueen.cellsystem.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class WsInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        String query = serverHttpRequest.getURI().getQuery();
        if (query == null) return false;
        String[] params = serverHttpRequest.getURI().getQuery().split("&");
        for (String p : params) {
            String[] keyValue = p.split("=");
            if (keyValue.length == 1) {
                map.put(keyValue[0], true);
            } else if (keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]);
            }
        }
        return map.containsKey("token");
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
    }
}
