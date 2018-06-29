package io.openmessaging.linkedlist;

/**
 * create by zhangjun1 on 2018/6/29
 * 双向链表
 */
public class LinkListFactory {

    /**
     * 构造相应的双向链表并返回头指针。
     *
     * @param capacity
     * @return
     */
    public static ListNode newList(int capacity) {
        ListNode head = new ListNode();
        ListNode tail = head;
        if (capacity == 1) {
        } else {  // 大于1个节点
            for (int i = 1; i < capacity; i++) {
                ListNode listNode = new ListNode();
                tail.next = listNode;
                listNode.prev = tail;
                tail = tail.next;
            }
        }
        head.prev = tail;
        tail.next = head;
        return head;
    }
}
