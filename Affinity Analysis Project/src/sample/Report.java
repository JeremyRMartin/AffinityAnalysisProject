package sample;

import java.lang.invoke.SwitchPoint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Report {

  private static Stage ReportWindow = new Stage();

  // sets up Report Window
  private static void display() throws Exception {
    Parent root = FXMLLoader.load(SignInBox.class.getResource("Report.fxml"));
    ReportWindow.setTitle("Report");
    ReportWindow.setScene(new Scene(root, 750, 700));
    ReportWindow.setResizable(false);
    ReportWindow.show();
  }

  void generateReport() throws Exception {
    DBManager reportManager = new DBManager();
    ArrayList<ArrayList> foodGroups = groupCommonChoices(reportManager.selectAllFromFoodSurvey());
    ArrayList<ArrayList> sportsGroups = groupCommonChoices(reportManager.selectAllFromSportsSurvey());
    //System.out.println(interpretGroups(foodGroups));
    //System.out.println(interpretGroups(sportsGroups));
    System.out.println(foodGroups);
    System.out.println(sportsGroups);
    display();
  }

  ArrayList<HashMap<Integer, ArrayList<Integer>>> interpretIndividualSurvey(int[] array) {
    ArrayList<HashMap<Integer, ArrayList<Integer>>> results = new ArrayList<>();
    // Objects For Dislikes Group
    HashMap<Integer, ArrayList<Integer>> zeroCountLocations = new HashMap<>();
    ArrayList<Integer> zeroFoundAt = new ArrayList<>();
    int zeroCount = 0;
    // Objects For Neutral Group
    HashMap<Integer, ArrayList<Integer>> oneCountLocations = new HashMap<>();
    ArrayList<Integer> oneFoundAt = new ArrayList<>();
    int oneCount = 0;
    // Objects For Likes Group
    HashMap<Integer, ArrayList<Integer>> twoCountLocations = new HashMap<>();
    ArrayList<Integer> twoFoundAt = new ArrayList<>();
    int twoCount = 0;

    for (int i = 0; i < array.length; i++) {
      int number = array[i];
      switch (number) {
        case 0:
          zeroCount++;
          zeroFoundAt.add(i);
          break;
        case 1:
          oneCount++;
          oneFoundAt.add(i);
          break;
        case 2:
          twoCount++;
          twoFoundAt.add(i);
          break;
      }
    }
    //Put Objects Together
    zeroCountLocations.put(zeroCount, zeroFoundAt);
    oneCountLocations.put(oneCount, oneFoundAt);
    twoCountLocations.put(twoCount, twoFoundAt);
    //Add Objects to ArrayList to Return
    results.add(zeroCountLocations);
    results.add(oneCountLocations);
    results.add(twoCountLocations);
    return results;
  }

  void printResults(ArrayList<HashMap<Integer, ArrayList>> results) {
    System.out.println(results.toString());
  }

  ArrayList<ArrayList<Integer>> getResults(ArrayList<HashMap<Integer, ArrayList<Integer>>> results) {
    String buckets = null;
    ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
    for (HashMap<Integer, ArrayList<Integer>> resultset : results) {
      for (int i = 0; i <= 4; i++) {
        if (resultset.get(i) != null && resultset.get(i).size() > 1) {
          groups.add(resultset.get(i));
          switch(results.lastIndexOf(resultset)){
            case 0:
              buckets = "Dislike";
              break;
            case 1:
              buckets = "Neutral";
              break;
            case 2:
              buckets = "Like   ";
              break;
          }
          System.out.println(buckets + " = " + resultset.get(i));
        }
      }
    }
    return groups;
  }

  ArrayList<ArrayList> groupCommonChoices(ArrayList<int[]> Psurvey) {
    ArrayList<ArrayList> groups = new ArrayList<>();
    for (int[] survey : Psurvey) {
      //System.out.print((Psurvey.indexOf(survey) + 1) + " = ");
      //printResults(interpretIndividualSurvey(survey));
      groups.add(getResults(interpretIndividualSurvey(survey)));
    }
    return groups;
  }


}
