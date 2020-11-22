package com.epam.university.java.core.task031;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerImpl implements Server {

    String str;
    ServerSocket ss;

    @Override
    public String readMessage() throws IOException {
        return str;
    }

    @Override
    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        str = (String) dis.readUTF();
    }

    @Override
    public void stop() throws IOException {
        ss.close();
    }
}
