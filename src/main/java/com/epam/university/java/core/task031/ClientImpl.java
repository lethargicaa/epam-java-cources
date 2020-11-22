package com.epam.university.java.core.task031;

import java.io.*;
import java.net.Socket;

public class ClientImpl implements Client {
    DataOutputStream dout;
    Socket s;

    @Override
    public void sendMessage(String message) throws IOException {
        dout.writeUTF(message);
    }

    @Override
    public void start() throws IOException {
        Socket s = new Socket("localhost", 6666);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void stop() throws IOException {
        dout.close();
        s.close();
    }
}