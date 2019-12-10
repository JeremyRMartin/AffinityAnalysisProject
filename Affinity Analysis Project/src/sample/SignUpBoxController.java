package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.paint.Paint;

import javax.swing.*;

import static sample.SignUpBox.SignUpWindow;

public class SignUpBoxController {
    ///////////inserting Objects to be displayed on Survey Scene//////////////////////
    @FXML
    Button signUpBtn = new Button();
    @FXML
    TextField username1 = new TextField();
    @FXML
    TextField username2 = new TextField();
    @FXML
    PasswordField password1 = new PasswordField();
    @FXML
    PasswordField password2 = new PasswordField();
    @FXML
    Label errorCodeTop = new Label();
    @FXML
    Label errorCodeBottom = new Label();
    @FXML
    Label newUserLabel = new Label();
    //////////////////////////////////////////////////////////////////////////////////

    //Checks if Username Fields 1 & 2 are of correct length and if they match
    public boolean checkUsernameLength(){
        boolean isGoodUsername = false;
        String UsernameField1Entry = username1.getText();
        String UsernameField2Entry = username2.getText();
        if((username1.getText().trim()).length() < 6 && (username2.getText().trim()).length() < 6){             //Both Fields < 6
            errorCodeTop.setTextFill(Paint.valueOf("#cc0000"));//Red
            errorCodeTop.setText("Both Username Fields Too Short.");
        }else if(((username1.getText().trim()).length() >= 6 && (username2.getText().trim()).length() < 6)) {   //Field 2 < 6
            errorCodeTop.setTextFill(Paint.valueOf("#cc0000"));//Red
            errorCodeTop.setText("Second Username Field Too Short.");
        }else if(((username1.getText().trim()).length() < 6 && (username2.getText().trim()).length() >= 6)) {   //Field 1 < 6
            errorCodeTop.setTextFill(Paint.valueOf("#cc0000"));//Red
            errorCodeTop.setText("First Username Field Too Short.");
        }else{                                                                                                  //Both Correct Length
            if ((UsernameField1Entry.trim()).equals((UsernameField2Entry.trim()))) {                            //Both Fields Match
                errorCodeTop.setTextFill(Paint.valueOf("#009918"));//Green
                errorCodeTop.setText("Username Valid.");
                isGoodUsername = true;
            }else{                                                                                             //Fields Dont Match
                errorCodeTop.setTextFill(Paint.valueOf("#cc0000"));//Red
                errorCodeTop.setText("Username Fields Don't Match.");
            }//end internal if-else
        }//end external if-else
        return isGoodUsername;
    }// end checkUsernameLength

    //Checks if Password Fields 1 & 2 are of correct length and if they match
    public boolean checkPasswordLength() {
        boolean isGoodPassword = false;
        String PasswordField1Entry = password1.getText();
        String PasswordField2Entry = password2.getText();
        if((password1.getText().trim()).length() < 6 && (password2.getText().trim()).length() < 6){             //Both Fields < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000"));//Red
            errorCodeBottom.setText("Both Password Fields Too Short.");
        }else if(((password1.getText().trim()).length() >= 6 && (password2.getText().trim()).length() < 6)) {   // Field 2 < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000"));//Red
            errorCodeBottom.setText("Second Password Field Too Short.");
        }else if(((password1.getText().trim()).length() < 6 && (password2.getText().trim()).length() >= 6)) {   // Field 1 < 6
            errorCodeBottom.setTextFill(Paint.valueOf("#cc0000"));//Red
            errorCodeBottom.setText("First Password Field Too Short.");
        }else{                                                                                                  //Both correct Length
            if ((PasswordField1Entry.trim()).equals((PasswordField2Entry.trim()))) {                            //Both Fields Match
                errorCodeBottom.setTextFill(Paint.valueOf("#009918"));//Green
                errorCodeBottom.setText("Password Valid.");
                isGoodPassword = true;
            }else{                                                                                              //Fields Dont Match
                errorCodeBottom.setTextFill(Paint.valueOf("#cc0000"));//Red
                errorCodeBottom.setText("Password Fields Don't Match.");
            }//end internal if-else
        }//end external if-else
        return isGoodPassword;
    }//end checkPasswordLength

    public void signUpButtonPressed() throws SQLException {
        boolean UsernameStatus = checkUsernameLength();
        boolean PasswordStatus = checkPasswordLength();
        if (UsernameStatus && PasswordStatus) {                                 //If Username is UNIQUE, then add user to DataBase
            DBManager db = new DBManager();
            db.insertIntoUsers(username1.getText().trim(),password1.getText().trim());
            db.CreateNewIntoFoodSurvey(db.selectFoodIDFromUsers(username1.getText().trim()));
            db.CreateNewIntoSportsSurvey(db.selectSportsIDFromUsers(username1.getText().trim()));
            db.closeCon();
            System.out.println("NEW USER CREATED!");
            SignUpWindow.close();
        }else{                                                                  //If Username is not UNIQUE, then reject user Creation
            newUserLabel.setTextFill(Paint.valueOf("#cc0000"));//Red
            newUserLabel.setText("Unable to Create New User.");
        }//end if-else
    }//end signUpButtonPressed
}
