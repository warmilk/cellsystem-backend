package com.kueen.cellsystem.util.api;

public enum CommandCode implements IErrorCode {
    HANDLE(200, "请求处理");
    private long code;
    private String message;

    private CommandCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
