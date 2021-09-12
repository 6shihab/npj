package client_server;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String clientMessage = "", serverMessage = "";
        Socket s = new Socket("localhost", 3000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!clientMessage.equals("stop")) {
            // get client message from system
            clientMessage = br.readLine();
            // write client message to the output stream
            dos.writeUTF(clientMessage);
            // flush the stream
            dos.flush();
            // get server message from input stream
            serverMessage = dis.readUTF();
            // show the server message
            System.out.println("Server: "+serverMessage);
        }
        // close the output stream
        dos.close();
        // close the socket
        s.close();
    }
}
