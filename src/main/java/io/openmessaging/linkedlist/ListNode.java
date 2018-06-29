package io.openmessaging.linkedlist;

/**
 * create by zhangjun1 on 2018/6/28
 * 双向链表的中的节点
 */
public class ListNode {
    /**
     * 数据区块的真正存储的大小
     */
    public int size;
    public byte[] data;

    /**
     * 数据库是否空闲的使用。
     * 只有当空闲时， 才可以进行数据写入
     */
    public boolean idle;

    public ListNode prev;

    public ListNode next;
}
