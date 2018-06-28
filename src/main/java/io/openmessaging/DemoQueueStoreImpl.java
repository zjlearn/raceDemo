package io.openmessaging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by zhangjun1 on 2018/6/23
 * 这个是官方提供的demo代码
 */
public class DemoQueueStoreImpl {
    public static Collection<String> EMPTY = new ArrayList<String>();
    Map<String, List<String>> queueMap = new ConcurrentHashMap<String, List<String>>();

    public synchronized void put(String queueName, String message) {
        if (!queueMap.containsKey(queueName)) {
            queueMap.put(queueName, new ArrayList<String>());
        }
        queueMap.get(queueName).add(message);
    }
    public synchronized Collection<String> get(String queueName, long offset, long num) {
        if (!queueMap.containsKey(queueName)) {
            return EMPTY;
        }
        List<String> msgs = queueMap.get(queueName);
        return msgs.subList((int) offset, offset + num > msgs.size() ? msgs.size() : (int) (offset + num));
    }
}
