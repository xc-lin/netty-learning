package com.lxc.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel {
    public static void main(String[] args) throws IOException {
        String str = "hello lxc";
        // 创建一个输出流-》channel
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/linxianchao3/Desktop/11111");
        // 通过fileOutputStream获取对应的FileChannel
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
