package Email;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Mail{
    int id;
    String from;
    String to;
    String title;
    String contents;
    boolean attached;
}


public class EmailController {
    HashMap<String, Mail> mailList = new HashMap<>();;
    String curAccount = "";

    public boolean run(Set<String> accounts) {
        System.out.println("<< HOME (" + curAccount + ") >>");

        while (true) {
            System.out.println("1. Show Mail List");
            System.out.println("2. Send Mail");
            System.out.println("3. Logout");
            System.out.println("4. Exit");

            Scanner sc = new Scanner(System.in);
            final int input = sc.nextInt();

            switch (input) {
                case 1: showMailList(); break;
                case 2: sendMail(); break;
                case 3: return true;
                case 4: System.exit(0);
                default:
            }

        }
    }

    public void setAccount(String acc) {
        curAccount = acc;
    }

    void showMailList() {
        System.out.println("<< MAIL LIST >>");

        if ( mailList.isEmpty() ) {
            System.err.println("There's no mail("+curAccount+")");
            return;
        }

        for (Map.Entry<String, Mail> entry : mailList.entrySet() ) {
            Mail v = entry.getValue();
            System.out.println("----------------------");
            System.out.println("id:" + v.id);
            System.out.println("From:" + v.from);
            System.out.println("To:" + v.to);
            System.out.println("Title:" + v.title);
            System.out.println("Contents:" + v.contents);
            System.out.println("Attached:" + (v.attached ? "y" : "n"));
        }

    }

    void sendMail() {

    }

}