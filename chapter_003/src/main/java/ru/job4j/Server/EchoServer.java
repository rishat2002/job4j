package ru.job4j.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
       public static void main(String[] args) throws IOException {
           try (ServerSocket server = new ServerSocket(9000)) {
               while (true) {
                   Socket socket = server.accept();
                   try (OutputStream out = socket.getOutputStream();
                         BufferedReader in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()))) {
                       String str;
                       String massage="";
                       while (!(str = in.readLine()).isEmpty()) {
                           System.out.println(str);
                          massage=str;
                       }
                       if (("Hello").equals(massage)) {
                           out.write("Hello, dear friend.".getBytes());
                       }
                       else if (massage.equals("Bye")) {
                           in.close();
                           out.flush();
                           return;
                       }
                    }
                }
            }
       }
}
