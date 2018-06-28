package io.openmessaging.linkedlist;

import java.util.Iterator;
import java.util.Map;

/**
 * create by zhangjun1 on 2018/6/28
 * 负责将缓存数据flusher到磁盘中
 */
public class Flusher {

    /**
     * 循环遍历缓冲池，将数据flush到磁盘中去
     */
    public void flush() {
        for (Map.Entry<Long, Iterator> entry : BufferRegister.iteratorMap.entrySet()) {
            Iterator begin, cur = entry.getValue();
            while (cur.hasNext()){

            }
        }
    }
}
