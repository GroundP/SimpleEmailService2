package Login;

import java.util.Scanner;

public class LoginController {
    public boolean processSignUp(){
        System.out.println("<< SIGN UP >>");
        String id = new String();
        String pw = new String();
        inputAuthInfo(id, pw);
        return true;
    }

    public boolean processSignIn(){
        return true;
    }

    public boolean showAccountList(){
        return true;
    }

    boolean inputAuthInfo(String id, String pw){
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        final String inputID = sc.next();

        System.out.print("PW: ");
        final String inputPW = sc.next();

        if ( inputID.isEmpty() || inputPW.isEmpty() )
            return false;

        id = inputID;
        pw = inputPW;
        return true;
    }

}