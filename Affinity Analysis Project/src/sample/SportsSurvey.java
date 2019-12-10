package sample;

import static sample.SurveyHomePageController.*;

import java.sql.SQLException;


public class SportsSurvey {

    public static void interpretResults() throws SQLException {
        int[] sportsPref = new int[4];

        //Check First Row Preferences (Mens Basketball)
        switch (mensBasketball.getSelectedToggle().toString()) {
            case "RadioButton[id=mensBasketballDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                sportsPref[0] = 0;
                System.out.println(sportsPref[0] + ": User Dislikes Mens Basketball");
                break;
            case "RadioButton[id=mensBasketballNoPref, styleClass=radio-button]''": //checks Selected Toggle for NoPref
                sportsPref[0] = 1;
                System.out.println(sportsPref[0] + ": User Has No Preference on Mens Basketball");
                break;
            case "RadioButton[id=mensBasketballLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                sportsPref[0] = 2;
                System.out.println(sportsPref[0] + ": User Likes Mens Basketball");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(mensBasketball.getSelectedToggle().toString());
                break;
        }

        //Check First Row Preferences (Mens Baseball)
        switch (mensBaseball.getSelectedToggle().toString()) {
            case "RadioButton[id=mensBaseballDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                sportsPref[1] = 0;
                System.out.println(sportsPref[1] + ": User Dislikes Mens Baseball");
                break;
            case "RadioButton[id=mensBaseballNoPref, styleClass=radio-button]''": //checks Selected Toggle For NoPref
                sportsPref[1] = 1;
                System.out.println(sportsPref[1] + ": User Has No Preference on Mens Baseball");
                break;
            case "RadioButton[id=mensBaseballLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                sportsPref[1] = 2;
                System.out.println(sportsPref[1] + ": User Likes Mens Baseball");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(mensBaseball.getSelectedToggle().toString());
                break;
        }

        //Check First Row Preferences (Womens Basketball)
        switch (womensBasketball.getSelectedToggle().toString()) {
            case "RadioButton[id=womensBasketballDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                sportsPref[2] = 0;
                System.out.println(sportsPref[2] + ": User Dislikes Womens Basketball");
                break;
            case "RadioButton[id=womensBasketballNoPref, styleClass=radio-button]''": //checks Selected Toggle for NoPref
                sportsPref[2] = 1;
                System.out.println(sportsPref[2] + ": User Has No Preference on Womens Basketball");
                break;
            case "RadioButton[id=womensBasketballLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                sportsPref[2] = 2;
                System.out.println(sportsPref[2] + ": User Likes Womens Basketball");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(womensBasketball.getSelectedToggle().toString());
                break;
        }
        
        //Check First Row Preferences (womens Baseball)
        switch (womensBaseball.getSelectedToggle().toString()) {
            case "RadioButton[id=womensBaseballDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                sportsPref[3] = 0;
                System.out.println(sportsPref[3] + ": User Dislikes womens Baseball");
                break;
            case "RadioButton[id=womensBaseballNoPref, styleClass=radio-button]''": //checks Selected Toggle for NoPref
                sportsPref[3] = 1;
                System.out.println(sportsPref[3] + ": User Has No Preference on womens Baseball");
                break;
            case "RadioButton[id=womensBaseballLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                sportsPref[3] = 2;
                System.out.println(sportsPref[3] + ": User Likes womens Baseball");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(womensBaseball.getSelectedToggle().toString());
                break;
        }
        DBManager sSurveyManager = new DBManager();
        sSurveyManager.updateSportsSurveyWithValues(User.getSports_ID(),sportsPref);
        sSurveyManager.closeCon();
    }//end interpretResults
    
    
}//end Survey
