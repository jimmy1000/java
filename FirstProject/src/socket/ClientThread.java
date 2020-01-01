package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientThread {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
            Socket socket = new Socket("127.0.0.1",9612);
            SendServer(socket);
            ReceiveServer(socket);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void SendServer(Socket socket) {
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
            }
            //}

        }.start();
    }

    private static void ReceiveServer(Socket socket) {
        new Thread() {
            @Override
            public void run() {
                synchronized (socket) {
                    try (InputStream ins = socket.getInputStream(); DataInputStream dins = new DataInputStream(ins);) {
                        while (true) {
                            //System.out.println("从服务器收到的信息：");
                            String msg = dins.readUTF();
                            System.out.println("从服务器收到的信息："+msg);
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}