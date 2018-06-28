package io.openmessaging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * create by zhangjun1 on 2018/6/23
 * 将消息写入磁盘的任务逻辑
 */
public class MessageWriter {

    public final static String BASE_DATA_DIR = "/alidata1/race2018/data/";
    public final static int SEGMENT_SIZE = 1024 * 1024 * 1024;
    public static int nameStart = 0;
    public static FileChannel fc = null;
    public static int offset = 0;

    static {
        File f = new File(BASE_DATA_DIR + nameStart);
        RandomAccessFile acf = null;
        try {
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            acf = new RandomAccessFile(f, "rw");
            fc = acf.getChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(String queueName, byte[] bs) {
        try {
            int len = bs.length;
            MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len);
            mbuf.put(bs);
            offset = offset + len;
            if (offset > SEGMENT_SIZE) { //更换新的文件
                fc.close();
                fc = getFc(BASE_DATA_DIR + (++nameStart));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileChannel getFc(String file) {
        File f = new File(file);
        try {
            RandomAccessFile acf = null;
            if (!f.exists()) {
                f.createNewFile();
            }
            acf = new RandomAccessFile(f, "rw");
            fc = acf.getChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fc;
    }

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        byte[] data = "test.gexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxttest.gexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxt".getBytes();
        for (int i = 0; i < 500000; i++) {
            MessageWriter.write("queue1", data);
        }
        System.out.println("used: " + (System.currentTimeMillis() - t));
    }
}
