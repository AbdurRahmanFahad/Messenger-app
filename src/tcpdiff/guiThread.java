package tcpdiff;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class guiThread  extends Application{

    public static TextArea text_area;
    public static TextField input_name;
    public static TextField input_pass;
    public static TextField input_message;
    public static TextField input_chooseUsername;
    public static String chosenUser;
    public static String tmessage;

    public String s1, s2;
    Client client;

    Stage mystage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        mystage = primaryStage;
        mystage.setTitle("my messenger");
        Image im=new Image(guiThread.class.getResourceAsStream("logo.png"));
        mystage.getIcons().add(im);

        GridPane mygrid = new GridPane();
        mygrid.setPadding(new Insets(10, 10, 10, 10));
        mygrid.setHgap(20);
        mygrid.setVgap(30);

        Label name = new Label("Username: ");
        GridPane.setConstraints(name, 3, 4);
        name.setStyle("-fx-text-fill: #F7F9F9");

        input_name = new TextField();
        GridPane.setConstraints(input_name, 4, 4);

        Label pass = new Label("Password:   ");
        GridPane.setConstraints(pass, 3, 5);
        pass.setStyle("-fx-text-fill: #F7F9F9");

        input_pass = new TextField();
        input_pass.setPromptText("Type your password here");
        GridPane.setConstraints(input_pass, 4, 5);

        Button login = new Button("LogIn");
        GridPane.setConstraints(login, 5, 7);

        mygrid.getChildren().addAll(name, pass, input_name, input_pass, login);

        Scene my = new Scene(mygrid, 700, 480);
        mystage.setScene(my);
        my.getStylesheets().add("viper.css");

        GridPane mygrid2 = new GridPane();
        mygrid2.setPadding(new Insets(10, 10, 10, 10));
        mygrid2.setHgap(20);
        mygrid2.setVgap(30);

        text_area = new TextArea();
        mygrid2.setConstraints(text_area, 1, 1);

        Label message = new Label("Your message:   ");
        mygrid2.setConstraints(message, 1, 4);
        message.setStyle("-fx-text-fill: #F7F9F9");

        input_message = new TextField();
        mygrid2.setConstraints(input_message, 1, 5);
        input_message.setPromptText("What's on your mind...");

        input_message.setOnAction(e -> {
            String in = input_message.getText();
            text_area.appendText(s1 +"-" + in+'\n');
            tmessage = input_message.getText();
            CMessage cm;
            cm = new CMessage(s1, s2, chosenUser , tmessage);
            client.nc.write(cm);

            input_message.clear();
        });

        Button back_button = new Button("Back");
        mygrid2.setConstraints(back_button, 1, 7);
        Button send_button = new Button("Send");
        mygrid2.setConstraints(send_button, 1, 6);
        Button chooseUser_button = new Button("chooseUser");
        mygrid2.setConstraints(chooseUser_button, 2, 6);


        mygrid2.getChildren().addAll(message, input_message, text_area,  send_button, back_button, chooseUser_button);
        Scene scene2 = new Scene(mygrid2, 700, 480);
        scene2.getStylesheets().add("viper.css");

        login.setOnAction(e-> {
            s1 = input_name.getText();
            s2 = input_pass.getText();
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            client = new Client(serverAddress, serverPort, this);
            mystage.setScene(scene2);
        });

        send_button.setOnAction(e-> {
            String in = input_message.getText();
            text_area.appendText(s1 +"-" + in+'\n');
            tmessage = input_message.getText();
            CMessage cm;
            cm = new CMessage(s1, s2, chosenUser , tmessage);
            client.nc.write(cm);

            input_message.clear();
        });

        GridPane mygrid3 = new GridPane();
        mygrid3.setPadding(new Insets(10, 10, 10, 10));
        mygrid3.setHgap(20);
        mygrid3.setVgap(30);

        Label chooseuser = new Label("Whom you want to chat with: ");
        GridPane.setConstraints(chooseuser, 3, 4);
        chooseuser.setStyle("-fx-text-fill: #F7F9F9");

        input_chooseUsername = new TextField();
        GridPane.setConstraints(input_chooseUsername, 4, 4);

        Button ok_button = new Button("Ok");

        mygrid3.getChildren().addAll(chooseuser, input_chooseUsername, ok_button);
        Scene chooseUser = new Scene(mygrid3, 700, 480);
        chooseUser.getStylesheets().add("viper.css");


        chooseUser_button.setOnAction(e-> {

            mystage.setScene(chooseUser);
        });

        ok_button.setOnAction(e-> {
            chosenUser = input_chooseUsername.getText();
            //new WriteThreadClient(client.nc, chosenUser, this);

            mystage.setScene(scene2);
        });

        back_button.setOnAction(e-> {
            mystage.setScene(my);
        });


        mystage.show();
    }


    public static void main(String args[]) {

        launch(args);

    }

}

