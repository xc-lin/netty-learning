package com.lxc.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Frank_lin
 * @date 2023/1/15
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        // 创建一个线程池

        // 如果有客户端连接，就创建一个县城与之通讯

        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true) {
            System.out.println("等待连接");
            // 监听等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("连接到u一个客户端");
            executorService.execute(() -> {
                handler(socket);
            });
        }
    }

    // 编写一个handler方法，与客户端通讯
    public static void handler(Socket socket) {
        try {
            System.out.println("线程信息： id = " + Thread.currentThread().getId() + "名字=" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            // 循环读取客户端发送的消息
            while (true) {
                System.out.println("线程信息： id = " + Thread.currentThread().getId() + "名字=" + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
