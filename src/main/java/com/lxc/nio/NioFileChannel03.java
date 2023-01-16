package com.lxc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel03 {
    public static void main(String[] args) throws IOException {
        String str = "hello lxc";
        File file = new File("/Users/linxianchao3/Desktop/11111");
        // 创建一个输出流-》channel
        FileInputStream fileInputStream = new FileInputStream(file);


        FileOutputStream fileOutputStream = new FileOutputStream("/Users/linxianchao3/Desktop/2.txt");
        // 通过fileOutputStream获取对应的FileChannel
        FileChannel channel = fileInputStream.getChannel();

        FileChannel channel1 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            byteBuffer.clear();
            int read = channel.read(byteBuffer);
            if (read == -1){
                break;
            }
            byteBuffer.flip();
            channel1.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
