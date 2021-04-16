package com.kueen.cellsystem.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kueen.cellsystem.util.api.CommonResult;
import com.kueen.cellsystem.util.api.ResultCode;

import java.io.*;
import java.net.Socket;

public class ModelSocket {

    public static final int SOCK_BUFFER_SIZE = 1024;

    private Socket socket;
    private int port;
    private String host;
    private OutputStream os;
    private DataOutputStream dos;
    private InputStream is;
    private DataInputStream dis;

    public ModelSocket(int port) throws Exception{
        this(port, "localhost");
    }

    public ModelSocket(int port, String host) throws Exception{
        this.port = port;
        this.host = host;
        buildSocket();
    }

    protected void buildSocket() {
        try {
            socket = new Socket(this.host, this.port);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            is = socket.getInputStream();
            dis = new DataInputStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String message) throws Exception{
        send(message.getBytes());
    }

    public void send(byte[] message) throws Exception{
        dos.write(message);
        dos.flush();
    }

    public CommonResult read() throws Exception {
        byte[] message = new byte[SOCK_BUFFER_SIZE];
        int len = dis.read(message);
        String response = new String(message);
        JSONObject responseJSON = JSON.parseObject(response);
        if (responseJSON.getIntValue("code") == ResultCode.SUCCESS.getCode()) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    public void close() throws IOException {
        dos.close();
        dis.close();
        is.close();
        os.close();
        socket.close();
    }

}
