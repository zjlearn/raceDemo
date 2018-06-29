package io.openmessaging.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * create by zhangjun1 on 2018/6/29
 * 双向链表的使用dmeo
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("adfa");
        list.add("test");
        list.add("aew");
        ListIterator iter = list.listIterator();
        int i = 0;
        while (i < 30) {
            if (iter.hasNext()) {
                System.out.println(iter.next());
                iter.add(i);
                i++;
            } else {
                iter = list.listIterator();
            }
        }
    }
}
