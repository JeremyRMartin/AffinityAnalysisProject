package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpBox {

    public static Stage SignUpWindow = new Stage();

    // sets up Sign Up Window
    public static void display(String title) throws Exception {
        Parent root = FXMLLoader.load(SignInBox.class.getResource("SignUpBox.fxml"));
        SignUpWindow.setTitle("Sign Up");
        SignUpWindow.setScene(new Scene(root, 400, 450));
        SignUpWindow.setResizable(false);
        SignUpWindow.show();


    }

}
