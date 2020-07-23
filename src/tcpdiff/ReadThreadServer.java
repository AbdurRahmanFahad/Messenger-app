package tcpdiff;

import util.NetworkUtil;

import java.util.HashMap;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    public HashMap<String, NetworkUtil> clientMap;
    public HashMap<String, String> userData;

    public ReadThreadServer(NetworkUtil nc, HashMap<String, NetworkUtil> clientMap, HashMap<String, String> userData) {
        this.nc = nc;
        this.clientMap = clientMap;
        this.userData = userData;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                SMessage temp = null;
                CMessage ctemp = null;
                if (o != null) {
                    if (o instanceof SMessage) {
                        temp = (SMessage) o;
                        if (userData.get(temp.getFrom()).equals(temp.getPassword())) {
                            System.out.println(temp.getFrom()+": "+temp.getText());
                        }
                    }
                    else if(o instanceof CMessage) {
                        ctemp = (CMessage)o;
                        ServerToClient t = new ServerToClient(ctemp.getFrom(), ctemp.getText());
                        if (userData.get(ctemp.getFrom()).equals(ctemp.getPassword())) {
                            if(clientMap.get(ctemp.getTo())!= null)
                            {
                                clientMap.get(ctemp.getTo()).write(t);
                            }

                        }
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}