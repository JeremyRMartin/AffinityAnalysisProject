package sample;

import static sample.SurveyHomePageController.*;

import java.sql.SQLException;
import java.util.Arrays;


public class FoodSurvey {

    public static void interpretResults() throws SQLException {
        int[] foodPref = new int[4];

        //Check First Row Preferences (Chick-fil-a)
        switch (Chickfila.getSelectedToggle().toString()) {
            case "RadioButton[id=ChickfilaDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                foodPref[0] = 0;
                System.out.println(foodPref[0] + ": User Dislikes Chick-fil-a");
                break;
            case "RadioButton[id=ChickfilaNoPref, styleClass=radio-button]''": //checks Selected Toggle for NoPref
                foodPref[0] = 1;
                System.out.println(foodPref[0] + ": User Has No Preference on Chick-fil-a");
                break;
            case "RadioButton[id=ChickfilaLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                foodPref[0] = 2;
                System.out.println(foodPref[0] + ": User Likes Chick-fil-a");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(Chickfila.getSelectedToggle().toString());
                break;
        }

        //Check First Row Preferences (Tropical Smoothie)
        switch (TropicalSmoothie.getSelectedToggle().toString()) {
            case "RadioButton[id=TropicalSmoothieDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                foodPref[1] = 0;
                System.out.println(foodPref[1] + ": User Dislikes Tropical Smoothie");
                break;
            case "RadioButton[id=TropicalSmoothieNoPref, styleClass=radio-button]''": //checks Selected Toggle For NoPref
                foodPref[1] = 1;
                System.out.println(foodPref[1] + ": User Has No Preference on Tropical Smoothie");
                break;
            case "RadioButton[id=TropicalSmoothieLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                foodPref[1] = 2;
                System.out.println(foodPref[1] + ": User Likes Tropical Smoothie");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(TropicalSmoothie.getSelectedToggle().toString());
                break;
        }

        //Check First Row Preferences (Starbucks)
        switch (Starbucks.getSelectedToggle().toString()) {
            case "RadioButton[id=StarbucksDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                foodPref[2] = 0;
                System.out.println(foodPref[2] + ": User Dislikes Starbucks");
                break;
            case "RadioButton[id=StarbucksNoPref, styleClass=radio-button]''": //checks Selected Toggle for NoPref
                foodPref[2] = 1;
                System.out.println(foodPref[2] + ": User Has No Preference on Starbucks");
                break;
            case "RadioButton[id=StarbucksLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                foodPref[2] = 2;
                System.out.println(foodPref[2] + ": User Likes Starbucks");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(Starbucks.getSelectedToggle().toString());
                break;
        }
        
        //Check First Row Preferences (Einstein's Bro Bagels)
        switch (EinsteinsBro.getSelectedToggle().toString()) {
            case "RadioButton[id=EinsteinsBroDislike, styleClass=radio-button]''": //checks Selected Toggle for Dislike
                foodPref[3] = 0;
                System.out.println(foodPref[3] + ": User Dislikes Einstein's Bro Bagels");
                break;
            case "RadioButton[id=EinsteinsBroNoPref, styleClass=radio-button]''": //checks Selected Toggle for NoPref
                foodPref[3] = 1;
                System.out.println(foodPref[3] + ": User Has No Preference on Einstein's Bro Bagels");
                break;
            case "RadioButton[id=EinsteinsBroLike, styleClass=radio-button]''": //checks Selected Toggle for Like
                foodPref[3] = 2;
                System.out.println(foodPref[3] + ": User Likes Einstein's Bro Bagels");
                break;
            default:
                System.out.println("No Valid Entry");
                System.out.println(EinsteinsBro.getSelectedToggle().toString());
                break;
        }
        DBManager fSurveyManager = new DBManager();
        fSurveyManager.updateFoodSurveyWithValues(User.getFood_ID(),foodPref);
        fSurveyManager.closeCon();
    }//end interpretResults
    
    
}//end Survey
