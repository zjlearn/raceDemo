package io.openmessaging.linkedlist;

/**
 * create by zhangjun1 on 2018/6/29
 * 负责将数据写入到缓存中去
 */
public class Writer {
    /**
     * @param queueName
     * @param data
     */
    public void write(String queueName, byte[] data) {
        Thread thread = Thread.currentThread();
        Long id = thread.getId();
        if (!BufferRegister.iteratorMap.containsKey(id)) {
            ListNode head = LinkListFactory.newList(5);
            BufferRegister.iteratorMap.put(id, head);
            BufferRegister.writerStatus.put(id, head);
        }
        ListNode listNode = BufferRegister.writerStatus.get(id);
    }
}
