package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignInBox {

    public static Stage SignInWindow = new Stage();

    // sets up Sign In Window
    public static void display(String title) throws Exception {
        SignInWindow.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(SignInBox.class.getResource("SignInBox.fxml"));
        SignInWindow.setTitle("Sign In");
        SignInWindow.setScene(new Scene(root, 275, 400));
        SignInWindow.setResizable(false);
        SignInWindow.showAndWait();

    }

    public static void close() {
        SignInWindow.close();
    }
}
