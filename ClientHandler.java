package com.company.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket client;

    public ClientHandler(Socket socket){
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20000); // Wait for 20 seconds before executing the rest of the code

            InputStream inputStream = this.client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            DataOutputStream outputStream = new DataOutputStream(this.client.getOutputStream());

            //Continuous reading data from client
            String inputData;
            while ((inputData = bufferedReader.readLine()) != null) {
                System.out.println("Client says : " + inputData);
                switch (inputData) {
                    case "Hello from the client.":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I am fine,How are you? \n");
                        break;
                    case "I am fine.":
                        outputStream.writeBytes("Okay, good to know. \n");
                        break;
                    case "Thank You.":
                        outputStream.writeBytes("You are welcome. \n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand that. \n");
                }
                if (inputData.equals("exit")) {
                    break;
                }
            }
            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
