package com.tomsky.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by j-wangzhitao on 17-7-12.
 */
public class Cache {
    private HashMap<String, String> map = new HashMap<>();

    private static Cache mInstance;

    public static synchronized Cache getInstance() {
        if (mInstance == null) {
            mInstance = new Cache();
        }
        return mInstance;
    }

    public void add(String key, String val) {
        synchronized (map) {
            if (map.containsKey(key)) {
                return;
            }
            System.out.println("add key:"+key+", thread:"+Thread.currentThread().getName());
            map.put(key, val);
        }
    }

    public String get(String key) {
        return map.get(key);
    }

    public void printMap() {
        String currentThread = Thread.currentThread().getName();
        System.out.println("start---map size:"+map.size()+", thread:"+currentThread);
        Set<Map.Entry<String, String>> set = map.entrySet();
        String result;
        for (Map.Entry<String, String> entry: set) {
            result = "key:"+entry.getKey()+", val:"+entry.getValue()+"-------- thread:"+currentThread;
//            System.out.println();
        }
        System.out.println("end---map size:"+map.size()+", thread:"+currentThread);
    }
}
