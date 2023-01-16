package com.lxc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel02 {
    public static void main(String[] args) throws IOException {
        String str = "hello lxc";
        File file = new File("/Users/linxianchao3/Desktop/11111");
        // 创建一个输出流-》channel
        FileInputStream fileInputStream = new FileInputStream(file);
        // 通过fileOutputStream获取对应的FileChannel
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        channel.read(byteBuffer);


        System.out.println(new String(byteBuffer.array()));

    }
}
