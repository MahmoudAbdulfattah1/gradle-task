package graaadle;

import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Server {

    static Scanner input = new Scanner(System.in);

    public static ServerSocket serverSocket = null;
    public static Socket socket = null;
    public static BufferedWriter bufferedWriter = null;
    public static BufferedReader bufferedReader = null;
    public static InputStreamReader inputStreamReader = null;
    public static OutputStreamWriter outputStreamWriter = null;

    public static void setServerSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public static void acception() throws IOException {
        socket = serverSocket.accept();
        System.out.println("Connection accepted from the server");

    }

    public static void setServerVal() throws IOException {

        inputStreamReader = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        bufferedWriter = new BufferedWriter(outputStreamWriter);

    }

    public static void serverSend(String string) throws IOException {
        bufferedWriter.write(string);
        bufferedWriter.newLine();
        bufferedWriter.flush();

    }

    public static void serverClose() throws IOException {
        serverSocket.close();
        socket.close();
        bufferedWriter.close();
        bufferedReader.close();
        inputStreamReader.close();
        outputStreamWriter.close();
    }


}


