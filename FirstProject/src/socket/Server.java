package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerThread {

    public static void main(String[] args) {
        System.out.println("运行中……");
        try{
            ServerSocket serversocket = new ServerSocket(9612);
            System.out.println("服务器等待连接");
            Socket socket = serversocket.accept();
            // 设置服务器监听的端口
            ReceiveClient(socket);
            SendClient(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReceiveClient(Socket socket) {
        new Thread() {

            @Override
            public void run() {
                try (
                        InputStream ins = socket.getInputStream();
                        DataInputStream dins = new DataInputStream(ins);
                ){
                    while (true) {
                        String msg = dins.readUTF();
                        System.out.println("接受客户端的信息："+msg);
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }.start();
    }

    private static void SendClient(Socket socket) {
        new Thread() {
            @Override
            public void run() {
                //synchronized (socket) {
                try (OutputStream os = socket.getOutputStream();
                     DataOutputStream dos = new DataOutputStream(os);
                     Scanner scann = new Scanner(System.in);) {
                    while (true) {
                        String msg = scann.nextLine();
                        dos.writeUTF(msg);
                    }

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //}
            }

        }.start();
    }



}