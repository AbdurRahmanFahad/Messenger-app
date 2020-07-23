# Messenger-app

**Intro**

This is a client to client messaging app written in Java using the help of JavaFx library. It supports multiple users simultaneously. It can be used in the 
same Local Area Network also over the net. For using
over the net, at least one user require Public IP, who
will run the server.

# User Manual
**Requirements**
* Java Runtime Environment installed
* Any IDE for Java. Example : Intellij, Eclipse, 	Netbeans.
* Java SE 11.0.1 or higher
* Java Fx library integrated

**Steps**
* For testing in the same machine
  * Run `Server.main()` first
  * Run `guiThread.main()` as many times as the number of users you want to create
* For testing in the different machine
  * Under the `guiThread class`, change this line in the second machine
  ```javascript 
  String serverAddress = "127.0.0.1";
  ``` 
  * If not in same LAN, run `Server.main()` in the machine that has a Public IP. If running in the same LAN then any machine is fine.
  * Set `serverAddress` according to the IP address of the machine in which the `Server.main()` is running
  * Now run `guiThread.main()` 
