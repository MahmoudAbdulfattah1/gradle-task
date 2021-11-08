/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graaadle;

import java.io.IOException;
import java.util.Scanner;

import static graaadle.Server.*;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Enter command..");
        boolean isConnected = false;
        boolean clientConnected = false;
        while (true) {
            String string = input.next();
            if (string.equals("connIPport")) isConnected = true;
            while (!isConnected) {
                System.out.println("Please enter the command 'connIPport' to connect");
                string = input.next();
                if (string.equals("connIPport")) {
                    isConnected = true;
                    break;
                }
            }
            if (string.equals("connIPport")) {
                if (clientConnected)
                    Client.closeClient();
                System.out.println("Enter host: ");
                String localhost = input.next();
                System.out.println("Enter port number: ");
                int port = input.nextInt();
                Server.setServerSocket(port);
                Client.setSocket(localhost, port);
                Server.acception();
                Client.setClientVal();
                Server.setServerVal();
                clientConnected = true;

            } else if (string.equals("send")) {
                String clientMsg = input.nextLine();
                Client.clientSend(clientMsg);
                System.out.println("Client to server: " + Server.bufferedReader.readLine());


            } else if (string.equals("reply")) {
                String serverMsg = input.nextLine();
                Server.serverSend(serverMsg);
                System.out.println("Server to client: " + Client.bufferedReader.readLine());


            } else if (string.equals("end")) {
                System.out.println("Server terminated");
                Server.serverClose();
                break;
            }
        }
    }

}