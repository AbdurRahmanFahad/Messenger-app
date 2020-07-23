package tcpdiff;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import util.NetworkUtil;

public class WriteThreadServer implements Runnable {

    private Thread thr;
    String name;
    public HashMap<String, NetworkUtil> clientMap;

    public WriteThreadServer(HashMap<String, NetworkUtil> map, String name) {
        this.clientMap = map;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                String s = input.nextLine();
                StringTokenizer st = new StringTokenizer(s);
                String cName = st.nextToken();
                NetworkUtil nc = clientMap.get(cName);
                if (nc != null) {
                    nc.write(name + ": " + s);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



