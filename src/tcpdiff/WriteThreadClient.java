package tcpdiff;

import java.util.Scanner;


import util.NetworkUtil;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    String receipient;
    guiThread x;


    public WriteThreadClient(NetworkUtil nc, String reciever, guiThread x) {
        this.nc
                = nc;
        receipient = reciever;
        this.x = x;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            String message, username = x.s1, password = x.s2;
            CMessage cm;

            while (true)
            {
                message = x.tmessage;
                //System.out.println(message);

                if(message!=null)
                {cm = new CMessage(username, password, receipient, message);
                    nc.write(cm);}
                message = null;

            }



        } catch (Exception e) {
            System.out.println(e);
        } finally {
            nc.closeConnection();
        }
    }
}



