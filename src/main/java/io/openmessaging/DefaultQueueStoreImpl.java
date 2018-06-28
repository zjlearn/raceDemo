package io.openmessaging;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这是一个简单的基于内存的实现，以方便选手理解题意；
 * 实际提交时，请维持包名和类名不变，把方法实现修改为自己的内容；
 */
public class DefaultQueueStoreImpl extends QueueStore {

    Map<String, List<String>> queueMap = new ConcurrentHashMap<String, List<String>>();


    /**
     * 进行消息的合并， 减少消息读写调用的次数
     * @param queueName 代表queue名字，如果是第一次put，则自动生产一个queue
     * @param message message，代表消息的内容，评测时内容会随机产生，大部分长度在64字节左右，会有少量消息在1k左右
     */
    public synchronized void put(String queueName, String message) {
        MessageWriter.write(queueName, message.getBytes());
    }

    public synchronized Collection<String> get(String queueName, long offset, long num) {
        return null;
    }
}
