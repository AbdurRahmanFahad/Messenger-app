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
  * Under the `guiThread class`, change this line in the second machine.
```javascript 
  String serverAddress = "127.0.0.1";
``` 
  * If not in same LAN, run `Server.main()` in the machine that has a Public IP. If running in the same LAN then any machine is fine.
  * Set `serverAddress` according to the IP address of the machine in which the `Server.main()` is running
  * Now run `guiThread.main()` 

**After running the application**
* Type username and any random password, as the password verification and sign up functions has not been implemented yet.
* Click the `Choose User` button and type the user's name you want to send message to, the user should do the same.
* Now all good to go. Many users can chat at the same time as multiple clients are handled with `Java Threads`.
* Pressing Enter Key also works as send.

# Sample images from the application

Here are some demonstrations from the Messenger application.

**Login Screen**
![Image 1](/sample/sample1.png)

**Chatting Screen**
![Image 2](/sample/sample2.png)
![Image 3](/sample/sample3.png)
