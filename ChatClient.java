package com.company.client;

import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();

        //What if you can capture user input using the scanner class???
        client.sendMessage("Hello from the client.");
        client.sendMessage("How are you?");
        client.sendMessage("I am fine.");
        client.sendMessage("Thank You.");
        client.sendMessage("exit");

        System.out.println("Client finished the execution");

    }
}
