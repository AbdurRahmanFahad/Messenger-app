package tcpdiff;

import util.NetworkUtil;

public class ReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;
    guiThread x;

    public ReadThread(NetworkUtil nc, guiThread x) {
        this.nc = nc;
        this.thr = new Thread(this);
        this.x = x;
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                CMessage temp = null;
                if (o != null) {
                    if (o instanceof CMessage) {
                        temp = (CMessage)o;
                        ServerToClient mes = new ServerToClient(temp.getFrom(), temp.getText());
                        System.out.println(mes);
                    }
                    else if(o instanceof ServerToClient){
                        ServerToClient t = (ServerToClient)o;
                        x.text_area.appendText(t.getUsername()+": "+t.getText()+'\n');
                        //System.out.println(t.getUsername()+": "+t.getText());
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



