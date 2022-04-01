package Login;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;

public class LoginController {
    HashMap<String, String> accountsMap = new HashMap<>();

    public boolean processSignUp() {
        System.out.println("<< SIGN UP >>");
        StringBuilder id = new StringBuilder();
        StringBuilder pw = new StringBuilder();
        if ( inputAuthInfo(id, pw) ) {
            accountsMap.put(id.toString(), pw.toString());
            return true;
        }
        else {
            System.out.println("Failed to signUp(" + id +", " + pw +")");
            return false;
        }
    }

    public boolean processSignIn(StringBuilder id, StringBuilder pw){
        System.out.println("<< SIGN IN >>");
        if ( inputAuthInfo(id, pw) ) {
            if (validateLogin(id.toString(), pw.toString())) {
                System.out.println("Success to signIn(" + id + ")");
                return true;
            }
            else {
                System.out.println("Wrong ID or PW(" + id + ")");
                return false;
            }
        }
        else {
            System.out.println("Failed to signIn(" + id + ")");
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

    public Set<String> getAllId() {
        return accountsMap.keySet();
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