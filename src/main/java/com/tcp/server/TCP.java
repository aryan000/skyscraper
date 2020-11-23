package com.tcp.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCP {
  public static void main(String[] args) throws IOException {
//    System.out.println("HEllo");
//    ServerSocket serverSocket = new ServerSocket(6868);
//    Socket socket = serverSocket.accept();
//    InputStream input = socket.getInputStream();
//    System.out.println(input);
//    if (args.length < 1) return;

    int port = 6868;

    try (ServerSocket serverSocket = new ServerSocket(port)) {

      System.out.println("Server is listening on port " + port);

      while (true) {
        Socket socket = serverSocket.accept();

        System.out.println("New client connected");

        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);

        writer.println(new Date().toString());
      }

    } catch (IOException ex) {
      System.out.println("Server exception: " + ex.getMessage());
      ex.printStackTrace();
    }
  }
}
