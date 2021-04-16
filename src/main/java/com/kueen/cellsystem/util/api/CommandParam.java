package com.kueen.cellsystem.util.api;

import com.alibaba.fastjson.JSONObject;

public class CommandParam<T> {
    private long code;
    private String message;
    private T data;
    protected CommandParam() {
    }

    protected CommandParam(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommandParam<T> handle(T data) {
        return new CommandParam<>(CommandCode.HANDLE.getCode(), CommandCode.HANDLE.getMessage(), data);
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("message", message);
        object.put("data", data);
        return object.toJSONString();
    }
}
