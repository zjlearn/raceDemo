package io.openmessaging.linkedlist;

/**
 * create by zhangjun1 on 2018/6/29
 * 依照netty和dubbo中的byteBuffer写的ByteBuffer。
 * 主要是使用两个指针记录数据写入的情况。 用于支持多个线程同时访问一个ByteBuffer
 */
public class ByteBufferNetty {
    private int readerIndex;

    private int writerIndex;


}
