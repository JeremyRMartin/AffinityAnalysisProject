package sample;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DBManager {

  private Connection con = null;

  public DBManager() {
    try {
      con = DriverManager.getConnection("jdbc:h2:~/libs");
    } catch (SQLException e) {
      System.out.println("Connection Failed!");
    }
  }

  public void insertIntoUsers(String val1, String val2) throws SQLException {
    if (!selectFromUsersWhereUsernameIs(val1)) {
      String[] insertValues = {val1, val2};
      try {
        String insertQuery = "INSERT INTO USERS"
            + "(username, password)" + " VALUES (?, ?);";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setString(1, insertValues[0]);
        pstmt.setString(2, insertValues[1]);
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoUsers Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Already Exists!");
    }
  }//end insert into users

  public void insertIntoSportsSurvey(String sportsID, String val2, String val3, String val4,
      String val5) throws SQLException {
    if(!selectFromUsersWhereSportsIDis(Integer.parseInt(sportsID))){
      String[] insertValues = {sportsID, val2, val3, val4, val5};
      try {
        String insertQuery = "INSERT INTO SPORTS_SURVEY "
            + "(SPORTS_ID, opt1, opt2, opt3, opt4)" + " VALUES (?, ?, ?, ?, ?);";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setInt(1, Integer.parseInt(insertValues[0]));
        pstmt.setInt(2, Integer.parseInt(insertValues[1]));
        pstmt.setInt(3, Integer.parseInt(insertValues[2]));
        pstmt.setInt(4, Integer.parseInt(insertValues[3]));
        pstmt.setInt(5, Integer.parseInt(insertValues[4]));
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoSportsSurvey Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Doesn't Exist!");
    }
  }

  public void CreateNewIntoSportsSurvey(int sportsID) throws SQLException {
    if(!selectFromUsersWhereSportsIDis(sportsID)){
      try {
        String insertQuery = "INSERT INTO SPORTS_SURVEY "
            + "(SPORTS_ID)" + " VALUES (?);";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setInt(1, sportsID);
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoSportsSurvey Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Doesn't Exist!");
    }
  }

  public void insertIntoFoodSurvey(String val1, String val2, String val3, String val4, String val5)
      throws SQLException {
    if(!selectFromUsersWhereFoodIDis(Integer.parseInt(val1))) {
      String[] insertValues = {val1, val2, val3, val4, val5};
      try {
        String insertQuery = "INSERT INTO FOOD_SURVEY"
            + "(FOOD_ID, opt1, opt2, opt3, opt4)" + " VALUES (?, ?, ?, ?, ?);";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setInt(1, Integer.parseInt(insertValues[0]));
        pstmt.setInt(2, Integer.parseInt(insertValues[1]));
        pstmt.setInt(3, Integer.parseInt(insertValues[2]));
        pstmt.setInt(4, Integer.parseInt(insertValues[3]));
        pstmt.setInt(5, Integer.parseInt(insertValues[4]));
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoFoodSurvey Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Doesn't Exist!");
    }
  }

  public void CreateNewIntoFoodSurvey(int foodID) throws SQLException {
    if(!selectFromUsersWhereFoodIDis(foodID)){
      try {
        String insertQuery = "INSERT INTO FOOD_SURVEY "
            + "(FOOD_ID)" + " VALUES (?);";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setInt(1, foodID);
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoSportsSurvey Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Doesn't Exist!");
    }
  }

  /**
   * Selects all from Users Table, and Prints with formatting.
   *
   * */
  public void selectAllFromUsers() {
    ResultSet rs = null;
    try {
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT * FROM USERS;");

      while (rs.next()) {
        System.out.printf("Username = %s%n", rs.getString("username"));
        System.out.printf("Password = %s%n", rs.getString("password"));
        System.out.printf("Sports Survey ID = %d%n", rs.getInt("sports_ID"));
        System.out.printf("Food Survey ID   = %d%n", rs.getInt("food_ID"));
      }

    } catch (SQLException e) {
      System.out.println("ERROR: selectAllFromUsers FAILED!");
      System.out.println(e);
    }
  }

  /**
   * Selects all from the Sports Survey, and Prints with formatting.
   *
   *
   * @return*/
  public ArrayList<int[]> selectAllFromSportsSurvey() {
    ResultSet rs = null;
    ArrayList<int[]> sportsSurveyResults = new ArrayList<>();
    try {
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT * FROM SPORTS_SURVEY;");
      while (rs.next()) {
        int[] survey = new int[4];
/*        System.out.printf("Sports Survey ID = %d%n", rs.getInt("Sports_ID"));
        System.out.printf("Mens Basketball Pref.   = %d%n", rs.getInt("opt1"));
        System.out.printf("Mens Baseball Pref.     = %d%n", rs.getInt("opt2"));
        System.out.printf("Womens Basketball Pref. = %d%n", rs.getInt("opt3"));
        System.out.printf("Womens Baseball Pref.   = %d%n", rs.getInt("opt4"));*/
        survey[0] = rs.getInt("opt1");
        survey[1] = rs.getInt("opt2");
        survey[2] = rs.getInt("opt3");
        survey[3] = rs.getInt("opt4");
        sportsSurveyResults.add(survey);
      }

    } catch (SQLException e) {
      System.out.println("ERROR: selectAllFromSportsSurvey FAILED!");
    }
    return sportsSurveyResults;
  }


  /**
   * Selects all from the Food Survey, and Prints with formatting.
   *
   *
   * @return*/
  public ArrayList<int[]> selectAllFromFoodSurvey() {
    ResultSet rs = null;
    ArrayList<int[]> foodSurveyResults = new ArrayList<>();
    try {
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT * FROM FOOD_SURVEY;");
      while (rs.next()) {
        int[] survey = new int[4];
/*      System.out.printf("Food Survey ID = %d%n", rs.getInt("food_ID"));
        System.out.printf("Chick-fil-a Pref.       = %d%n", rs.getInt("opt1"));
        System.out.printf("Tropical Smoothie Pref. = %d%n", rs.getInt("opt2"));
        System.out.printf("Starbucks Pref.         = %d%n", rs.getInt("opt3"));
        System.out.printf("Einstein's Bro. Pref.   = %d%n", rs.getInt("opt4"));*/
        survey[0] = rs.getInt("opt1");
        survey[1] = rs.getInt("opt2");
        survey[2] = rs.getInt("opt3");
        survey[3] = rs.getInt("opt4");
        foodSurveyResults.add(survey);

      }
    } catch (SQLException e) {
      System.out.println("ERROR: selectAllFromFoodSurvey FAILED!");
    }
    return foodSurveyResults;
  }


  public void closeCon() {
    try {
      con.close();
    } catch (SQLException e) {
      System.out.println("ERROR: CONNECTION DIDN'T CLOSE!");
    }
  }


  /**
   * Used to find if a user exist's with the chosen Username
   *
   * @param value - value of Username that you are searching for
   * @return userExists - true or false depending
   * */
  public boolean selectFromUsersWhereUsernameIs(String value) {
    boolean userExists = true;
    ResultSet rs = null;
    String thingy = "SELECT * FROM USERS WHERE USERNAME IS";
    thingy = thingy + value + ";";
    try {
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery(thingy);
/*      while (rs.next()) {
        System.out.printf("Username = %s%n", rs.getString("username"));
        System.out.printf("Password = %s%n", rs.getString("password"));
        System.out.printf("Sports Survey ID = %d%n", rs.getInt("sports_ID"));
        System.out.printf("Food Survey ID   = %d%n", rs.getInt("food_ID"));
      }*/
    } catch (SQLException e) {
      userExists = false;
    }
    return userExists;
  }

  /**
   * Used to find if a user exist's with the chosen Username
   *
   * @param value - value of Username that you are searching for
   * @return userExists - true or false depending
   * */
  public boolean selectFromUsersWhereUsernameAndPasswordIs(String value, String value2) {
    boolean userExists = true;
    ResultSet rs = null;
    String thingy = "SELECT * FROM USERS WHERE USERNAME=";
    String thingy2 = " AND PASSWORD=";
    value = "'" + value + "'";
    value2 = "'" + value2 + "'";
    String thingy3 = thingy + value + thingy2 + value2 + ";";
    try {
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery(thingy3);
      while (rs.next()) {
        User.setUsername(rs.getString("username"));
        User.setPassword(rs.getString("password"));
        User.setSports_ID(rs.getInt("sports_ID"));
        User.setFood_ID(rs.getInt("food_ID"));
      }
    } catch (SQLException e) {
      userExists = false;
    }

    //this here is used to check and see if the values returned from the query contain anything
    String emptyString = "";
    if (!User.getUsername().equals(emptyString)){
      userExists = true;
    }else {
      userExists = false;
    }

    return userExists;
  }


  /**
   * Used to find if a user exist's with the chosen Sports_ID
   *
   * @param value - value of Sports_ID that you are searching for
   * @return userExists - true or false depending
   * */
  public boolean selectFromUsersWhereSportsIDis(int value) {
      boolean userExists = true;
      ResultSet rs = null;
      String thingy = "SELECT * FROM USERS WHERE SPORTS_ID IS";
      thingy = thingy + value + ";";
      try {
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(thingy);
/*        while (rs.next()) {
          System.out.printf("Username = %s%n", rs.getString("username"));
          System.out.printf("Password = %s%n", rs.getString("password"));
          System.out.printf("Sports Survey ID = %d%n", rs.getInt("sports_ID"));
          System.out.printf("Food Survey ID   = %d%n", rs.getInt("food_ID"));
        }*/
      } catch (SQLException e) {
        userExists = false;
      }
      return userExists;
  }

  /**
   * Used to find if a user exist's with the chosen Food_ID
   *
   * @param value - value of Food_ID that you are searching for
   * @return userExists - true or false depending
   * */
  public boolean selectFromUsersWhereFoodIDis(int value) {
    boolean userExists = true;
    ResultSet rs = null;
    String thingy = "SELECT * FROM USERS WHERE FOOD_ID IS";
    thingy = thingy + value + ";";
    try {
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery(thingy);
/*      while (rs.next()) {
        System.out.printf("Username = %s%n", rs.getString("username"));
        System.out.printf("Password = %s%n", rs.getString("password"));
        System.out.printf("Sports Survey ID = %d%n", rs.getInt("sports_ID"));
        System.out.printf("Food Survey ID   = %d%n", rs.getInt("food_ID"));
      }*/
    } catch (SQLException e) {
      userExists = false;
    }
    return userExists;
  }

  public void updateFoodSurveyWithValues(int foodID, int[] prefs)
      throws SQLException {
    if(!selectFromUsersWhereSportsIDis(foodID)) {
      try {
        String insertQuery = "UPDATE FOOD_SURVEY"
            + " SET OPT1 = ?, OPT2 = ?, OPT3 = ?, OPT4 = ? "
            + "WHERE FOOD_ID = ?";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setInt(1, prefs[0]);
        pstmt.setInt(2, prefs[1]);
        pstmt.setInt(3, prefs[2]);
        pstmt.setInt(4, prefs[3]);
        pstmt.setInt(5, foodID);
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoFoodSurvey Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Doesn't Exist!");
    }
  }

  public void updateSportsSurveyWithValues(int sportsID, int[] prefs)
      throws SQLException {
    if(!selectFromUsersWhereSportsIDis(sportsID)) {
      try {
        String insertQuery = "UPDATE SPORTS_SURVEY"
            + " SET OPT1 = ?, OPT2 = ?, OPT3 = ?, OPT4 = ?"
            + "WHERE SPORTS_ID = ?";
        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setInt(1, prefs[0]);
        pstmt.setInt(2, prefs[1]);
        pstmt.setInt(3, prefs[2]);
        pstmt.setInt(4, prefs[3]);
        pstmt.setInt(5, sportsID);
        pstmt.executeUpdate();
      } catch (SQLException e) {
        System.out.println("ERROR: insertIntoFoodSurvey Failed!");
        System.out.println(e);
      }
    }else {
      System.out.println("User Doesn't Exist!");
    }
  }

  public int selectSportsIDFromUsers(String username) {
    ResultSet rs = null;
    int Sportsid = 0;
    try {
      Statement stmt = con.createStatement();
      String thingy = "SELECT SPORTS_ID FROM USERS WHERE USERNAME = ";
      thingy = thingy + "'" + username + "'" + ";";
      rs = stmt.executeQuery(thingy);

      while (rs.next()) {
        Sportsid =  rs.getInt("sports_ID");
      }

    } catch (SQLException e) {
      System.out.println("ERROR: selectAllFromUsers FAILED!");
      System.out.println(e);
    }
    return Sportsid;
  }

  public int selectFoodIDFromUsers(String username) {
    ResultSet rs = null;
    int Foodid = 0;
    try {
      Statement stmt = con.createStatement();
      String thingy = "SELECT FOOD_ID FROM USERS WHERE USERNAME = ";
      thingy = thingy + "'" + username + "'" + ";";
      rs = stmt.executeQuery(thingy);

      while (rs.next()) {
        Foodid =  rs.getInt("food_id");
      }

    } catch (SQLException e) {
      System.out.println("ERROR: selectAllFromUsers FAILED!");
      System.out.println(e);
    }
    return Foodid;
  }

}

