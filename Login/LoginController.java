package Login;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LoginController {
    HashMap<String, String> accountsMap = new HashMap<>();

    public boolean processSignUp() {
        System.out.println("<< SIGN UP >>");
        StringBuilder id2 = new StringBuilder();
        StringBuilder pw2 = new StringBuilder();
        if ( inputAuthInfo(id2, pw2) ) {
            accountsMap.put(id2.toString(), pw2.toString());
            return true;
        }
        else {
            System.out.println("Failed to signUp(" + id2 +", " + pw2 +")");
            return false;
        }
    }

    public boolean processSignIn(){
        System.out.println("<< SIGN IN >>");
        StringBuilder id2 = new StringBuilder();
        StringBuilder pw2 = new StringBuilder();
        if ( inputAuthInfo(id2, pw2) ) {
            if (validateLogin(id2.toString(), pw2.toString())) {
                System.out.println("Success to signIn(" + id2 + ")");
                return true;
            }
            else {
                System.out.println("Wrong ID or PW(" + id2 + ")");
                return false;
            }
        }
        else {
            System.out.println("Failed to signIn(" + id2 + ")");
            return false;
        }
    }

    public boolean showAccountList(){
        int idx = 1;
        for (Map.Entry<String, String> entry : accountsMap.entrySet() ) {
            System.out.println(idx + ": " + entry.getKey());
            idx++;
        }

        return true;
    }

    boolean inputAuthInfo(StringBuilder id, StringBuilder pw) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID: ");
        final String inputID = sc.next();

        System.out.print("PW: ");
        final String inputPW = sc.next();

        if ( inputID.isEmpty() || inputPW.isEmpty() )
            return false;

        id.append(inputID);
        pw.append(inputPW);
        return true;
    }

    boolean validateLogin(final String id, final String pw) {
        if (!accountsMap.containsKey(id) ) {
            return false;
        }

        if (!accountsMap.get(id).equals(pw)) {
            return false;
        }

        return true;
    }

}