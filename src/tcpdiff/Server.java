package tcpdiff;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import util.NetworkUtil;

public class Server {

    private ServerSocket serverSocket;
    public int i = 1;
    public HashMap<String, NetworkUtil> clientMap;
    public HashMap<String, String> userData;
    Server() {
        clientMap = new HashMap<>();
        userData = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33333);
            new WriteThreadServer(clientMap, "Server");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        Object o = nc.read();
        //System.out.println("read rm from client");
        RMessage temp = null;
        if (o != null) {
            if( o instanceof RMessage)
            {
                temp = (RMessage)o;
            }
            clientMap.put(temp.getUsername(), nc);
            userData.put(temp.getUsername(), temp.getPassword());
        }
        new ReadThreadServer(nc, clientMap, userData);
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
