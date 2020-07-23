package tcpdiff;

import util.NetworkUtil;

public class Client {

    guiThread x;
    public NetworkUtil nc;
    public Client(String serverAddress, int serverPort, guiThread x) {
        try {
            nc = new NetworkUtil(serverAddress, serverPort);
            this.x = x;

            String username, password;
            username = x.s1;
            password = x.s2;

            System.out.println("Sent RM to server");
            RMessage newuser = new RMessage(username, password);

            nc.write(newuser);

            new ReadThread(nc, x);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

