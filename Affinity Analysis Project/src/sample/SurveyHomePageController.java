package sample;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;


public class SurveyHomePageController {

    ///////////inserting Objects to be displayed on Survey Scene//////////////////////
    @FXML
    Button submitSportsSurveyBtn = new Button();
    @FXML
    Button submitFoodSurveyBtn = new Button();
    @FXML
    Button SportsToFoodBtn = new Button();
    @FXML
    Button printReportButton = new Button();

    // Insert all Radio Buttons for Sports Survey
    @FXML
    RadioButton mensBasketballDislike, mensBasketballNoPref, mensBasketballLike,
            mensBaseballDislike, mensBaseballNoPref, mensBaseballLike,
            womensBasketballDislike, womensBasketballNoPref, womensBasketballLike ,
            womensBaseballDislike, womensBaseballNoPref, womensBaseballLike = new RadioButton();

    // Insert all Radio Buttons for Food Survey
    @FXML
    RadioButton ChickfilaDislike, ChickfilaNoPref, ChickfilaLike,
            TropicalSmoothieDislike, TropicalSmoothieNoPref, TropicalSmoothieLike,
            StarbucksDislike, StarbucksNoPref, StarbucksLike ,
            EinsteinsBroDislike, EinsteinsBroNoPref, EinsteinsBroLike = new RadioButton();

    @FXML
    Label sportsSurveyCompletionLabel, foodSurveyCompletionLabel = new Label();

    @FXML
    Tab foodSurveyTab = new Tab();
    @FXML
    Tab sportsSurveyTab = new Tab();
    //////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////SPORTS SURVEY//////////////////////////////////////////////////////////////

    // initializing the rows of the Sports survey to toggle group
    public static ToggleGroup mensBasketball = new ToggleGroup();
    public static ToggleGroup mensBaseball = new ToggleGroup();
    public static ToggleGroup womensBasketball = new ToggleGroup();
    public static ToggleGroup womensBaseball = new ToggleGroup();


    /**[Sports Survey]
     * sets buttons to toggle group for row 1
     */
    public void assignRadioButtonsRow1Sports() {
        mensBasketballDislike.setToggleGroup(mensBasketball);
        mensBasketballNoPref.setToggleGroup(mensBasketball);
        mensBasketballLike.setToggleGroup(mensBasketball);
    }

    /**[Sports Survey]
     * sets buttons to toggle group for row 2
     */
    public void assignRadioButtonsRow2Sports() {
        mensBaseballDislike.setToggleGroup(mensBaseball);
        mensBaseballNoPref.setToggleGroup(mensBaseball);
        mensBaseballLike.setToggleGroup(mensBaseball);
    }

    /**[Sports Survey]
     * sets buttons to toggle group for row 3
     */
    public void assignRadioButtonsRow3Sports() {
        womensBasketballDislike.setToggleGroup(womensBasketball);
        womensBasketballNoPref.setToggleGroup(womensBasketball);
        womensBasketballLike.setToggleGroup(womensBasketball);
    }

    /**[Sports Survey]
     * sets buttons to toggle group for row 4
     */
    public void assignRadioButtonsRow4Sports() {
        womensBaseballDislike.setToggleGroup(womensBaseball);
        womensBaseballNoPref.setToggleGroup(womensBaseball);
        womensBaseballLike.setToggleGroup(womensBaseball);
    }


    /**[Sports Survey]
     * retrieves choices from toggle groups (submits survey)
     */
    public void submitSportsSurveyBtnPressed() throws SQLException {
        boolean toggleInRow1PickedSports = false;
        boolean toggleInRow2PickedSports = false;
        boolean toggleInRow3PickedSports = false;
        boolean toggleInRow4PickedSports = false;

        try {
            toggleInRow1PickedSports = mensBasketball.getSelectedToggle().isSelected();
            toggleInRow2PickedSports = mensBaseball.getSelectedToggle().isSelected();
            toggleInRow3PickedSports = womensBasketball.getSelectedToggle().isSelected();
            toggleInRow4PickedSports = womensBaseball.getSelectedToggle().isSelected();
        }catch(Exception e){
            sportsSurveyCompletionLabel.setTextFill(Paint.valueOf("#cc0000"));//Red
            sportsSurveyCompletionLabel.setText("Please Complete Survey.");
        }

        if(toggleInRow1PickedSports && toggleInRow2PickedSports                         //if all toggleGroups have a selected Toggle
                && toggleInRow3PickedSports && toggleInRow4PickedSports) {
            sportsSurveyCompletionLabel.setTextFill(Paint.valueOf("#009918"));//Green
            sportsSurveyCompletionLabel.setText("Sports Survey Submitted.");
            SportsSurvey.interpretResults();
            submitSportsSurveyBtn.setVisible(false);
            SportsToFoodBtn.setVisible(true);

       }else{
            sportsSurveyCompletionLabel.setTextFill(Paint.valueOf("#cc0000"));//Red
            sportsSurveyCompletionLabel.setText("Please Complete Survey.");
        }//end if-else
    }//end submitSportsSurveyBtnPressed
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////FOOD SURVEY//////////////////////////////////////////////////////////
    public static ToggleGroup Chickfila = new ToggleGroup();
    public static ToggleGroup TropicalSmoothie = new ToggleGroup();
    public static ToggleGroup Starbucks = new ToggleGroup();
    public static ToggleGroup EinsteinsBro = new ToggleGroup();

    /**[Food Survey]
     * sets buttons to toggle group for row 1
     */
    public void assignRadioButtonsRow1Food() {
        ChickfilaDislike.setToggleGroup(Chickfila);
        ChickfilaNoPref.setToggleGroup(Chickfila);
        ChickfilaLike.setToggleGroup(Chickfila);
    }

    /**[Food Survey]
     * sets buttons to toggle group for row 2
     */
    public void assignRadioButtonsRow2Food() {
        TropicalSmoothieDislike.setToggleGroup(TropicalSmoothie);
        TropicalSmoothieNoPref.setToggleGroup(TropicalSmoothie);
        TropicalSmoothieLike.setToggleGroup(TropicalSmoothie);
    }

    /**[Food Survey]
     * sets buttons to toggle group for row 3
     */
    public void assignRadioButtonsRow3Food() {
        StarbucksDislike.setToggleGroup(Starbucks);
        StarbucksNoPref.setToggleGroup(Starbucks);
        StarbucksLike.setToggleGroup(Starbucks);
    }

    /**[Food Survey]
     * sets buttons to toggle group for row 4
     */
    public void assignRadioButtonsRow4Food() {
        EinsteinsBroDislike.setToggleGroup(EinsteinsBro);
        EinsteinsBroNoPref.setToggleGroup(EinsteinsBro);
        EinsteinsBroLike.setToggleGroup(EinsteinsBro);
    }

    /**[Food Survey]
     * retrieves choices from toggle groups (submits survey)
     */
    public void submitFoodSurveyBtnPressed() throws SQLException {
        boolean toggleInRow1PickedFood = false;
        boolean toggleInRow2PickedFood = false;
        boolean toggleInRow3PickedFood = false;
        boolean toggleInRow4PickedFood = false;

        try {
            toggleInRow1PickedFood = Chickfila.getSelectedToggle().isSelected();
            toggleInRow2PickedFood = TropicalSmoothie.getSelectedToggle().isSelected();
            toggleInRow3PickedFood = Starbucks.getSelectedToggle().isSelected();
            toggleInRow4PickedFood = EinsteinsBro.getSelectedToggle().isSelected();
        } catch (Exception e) {
            foodSurveyCompletionLabel.setTextFill(Paint.valueOf("#cc0000"));//Red
            foodSurveyCompletionLabel.setText("Please Complete Survey.");
        }

        if (toggleInRow1PickedFood && toggleInRow2PickedFood                         //if all toggleGroups have a selected Toggle
                && toggleInRow3PickedFood && toggleInRow4PickedFood) {
            foodSurveyCompletionLabel.setTextFill(Paint.valueOf("#009918"));//Green
            foodSurveyCompletionLabel.setText("Food Survey Submitted.");
            FoodSurvey.interpretResults();
        } else {
            foodSurveyCompletionLabel.setTextFill(Paint.valueOf("#cc0000"));//Red
            foodSurveyCompletionLabel.setText("Please Complete Survey.");
        }//end if-else
        submitFoodSurveyBtn.setVisible(false);
        printReportButton.setVisible(true);


    }//end submitFoodSurveyBtnPressed

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void handleSportsToFoodBtn(ActionEvent event) {
        foodSurveyTab.setDisable(false);
        sportsSurveyTab.setDisable(true);
    }

    public void printReportButtonPressed(ActionEvent event) throws Exception {
        System.out.println("Generating Report");
        Report report = new Report();
        report.generateReport();
    }
}//end controller

