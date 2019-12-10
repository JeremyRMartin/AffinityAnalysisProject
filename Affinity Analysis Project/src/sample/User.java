package sample;

public class User {
    private static String username = "";       // Test Username
    private static String password = "";       // Test Password
    private static boolean passwordStatus;
    private static int Sports_ID;
    private static int Food_ID;


    ///////////Setters//////////////
    public static void setUsername(String input){ username = input; }
    public static void setPassword(String input){ password = input; }
    public static void setSports_ID(int input){ Sports_ID = input; }
    public static void setFood_ID(int input){ Food_ID = input; }


    ///////////Getters//////////////
    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }
    public static int getSports_ID() {
        return Sports_ID;
    }
    public static int getFood_ID() {
        return Food_ID;
    }



    ///////Helper Methods/////////////

    // tests user entered PW and UN to previously saved UN and PW and returns t/f
    public static Boolean isGoodPassword(String un, String pw){
        DBManager db2 = new DBManager();
        if (db2.selectFromUsersWhereUsernameAndPasswordIs(un, pw)){
            passwordStatus = true;
        }else{
            passwordStatus = false;
        }
        db2.closeCon();
        return passwordStatus;
    } // end isGoodPassword


    // checks if user has signed in based on passwordStatus
    public static Boolean hasSignedIn(){
        return passwordStatus;
    }


}
