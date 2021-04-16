package com.kueen.cellsystem.util;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ConcurrentHashMap;

public class WsThreadManager {
    private static ConcurrentHashMap<String, Thread> THREAD_POOL = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, JSONObject> OBJECT_POOL = new ConcurrentHashMap<>();
    public static void add(String key, Thread thread) {
        THREAD_POOL.put(key, thread);
    }
    public static Thread remove(String key) {
        return THREAD_POOL.remove(key);
    }

    public static Thread get(String key) {
        return THREAD_POOL.get(key);
    }

    public static JSONObject removeObject(String key) {
        return OBJECT_POOL.remove(key);
    }

    public static void addObject(String key, JSONObject object) {
        OBJECT_POOL.put(key, object);
    }

}
