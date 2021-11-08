package graaadle;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    static Scanner input = new Scanner(System.in);
    static Socket socket = null;
    static BufferedWriter bufferedWriter = null;
    static OutputStreamWriter outputStreamWriter = null;
    static InputStreamReader inputStreamReader = null;
    static BufferedReader bufferedReader = null;


    public static void setSocket(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public static void setClientVal() throws IOException {

        inputStreamReader = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        bufferedWriter = new BufferedWriter(outputStreamWriter);

    }

    public static void clientSend(String string) throws IOException {
        bufferedWriter.write(string);
        bufferedWriter.newLine();
        bufferedWriter.flush();

    }

    public static void closeClient() throws IOException {
        socket.close();
        bufferedReader.close();
        bufferedWriter.close();
        inputStreamReader.close();
        outputStreamWriter.close();

    }


}

