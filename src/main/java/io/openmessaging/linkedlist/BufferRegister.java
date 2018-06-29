package io.openmessaging.linkedlist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by zhangjun1 on 2018/6/28
 * 缓存注册中心，多个线程在第一次新建相应的双向链表的发送缓冲区时到这里注册。
 */
public class BufferRegister {

    // 初始化三十个相应的
    public static Map<Long, ListNode> iteratorMap = new ConcurrentHashMap<>(30);

    /**
     * 保存每个list的空闲状态次数。 当空闲大于2时强制flush所有的数据
     */
    public static Map<ListNode, Integer> writerStatus = new ConcurrentHashMap<>(30);

}

