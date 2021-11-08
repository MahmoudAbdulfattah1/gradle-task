package graaadle;

import java.io.IOException;

public class TestClass {
   public static boolean setPort(String host,int port) throws IOException {
       Server.setServerSocket(port);
       Client.setSocket(host,port);
       Server.acception();
       Client.setClientVal();
       Server.setServerVal();
       return true;
   }

    public static String sendMsg(String string) throws IOException {
        Client.clientSend(string);
        String msg=Server.bufferedReader.readLine();
        return msg;
    }

    public static String replyMsg(String string)throws IOException{
        Server.serverSend(string);
        String msg=Client.bufferedReader.readLine();
        return msg;
    }

}
