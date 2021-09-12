package client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Server {
    public static Map<String, String> makeQA() {
        Map<String, String> qa = new HashMap<String, String>();
        qa.put("Hi", "Hello");
        qa.put("How are you?", "I am fine. And you?");
        qa.put("I am also fine.", "Have a relax. See you not for mind.");
        qa.put("Bye", "See you later.");
        qa.put("stop", "Ok, bye. I quit.");
        return qa;
    }
    public static String replyMessage(String clientMessage) {
        Map<String, String> qa = makeQA();
        return qa.get(clientMessage) == null ? "Murkho Borbor, Vlo question kor." : qa.get(clientMessage);
    }
    public static void main(String[] args) throws IOException {
        String clientMessage = "", serverMessage = "";
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!clientMessage.equals("stop")) {
            // read input stream as client message
            clientMessage = dis.readUTF();
            // write to the output stream
            dos.writeUTF(replyMessage(clientMessage));
            // flush the server message
            dos.flush();
        }
        // close input stream
        dis.close();
        // close the stream line
        s.close();
        // close the server
        ss.close();
    }
}