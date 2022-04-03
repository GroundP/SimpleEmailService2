package Email;

import java.util.*;

class Mail{
    int id;
    String from;
    String to;
    String title;
    String contents;
    boolean attached;

    Mail(int id, String from, String to, String title, String contents, boolean attached) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.title = title;
        this.contents = contents;
        this.attached = attached;
    }
}


public class EmailController {
    HashMap<String, ArrayList<Mail>> mailList = new HashMap<>();
    String curAccount = "";

    public void run(Set<String> accounts) {
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
                case 2: sendMail(accounts); break;
                case 3: return;
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

        if ( !mailList.containsKey(curAccount) ) {
            System.err.println("There's no mail("+curAccount+")");
            return;
        }

        ArrayList<Mail> v = mailList.get(curAccount);
        System.out.println("Total mail count: "+ v.size());
        for ( Mail m : v ) {
            System.out.println("----------------------");
            System.out.println("id:" + m.id);
            System.out.println("From:" + m.from);
            System.out.println("To:" + m.to);
            System.out.println("Title:" + m.title);
            System.out.println("Contents:" + m.contents);
            System.out.println("Attached:" + (m.attached ? "y" : "n"));
        }
    }

    void sendMail(Set<String> accounts) {
        System.out.println("<< SEND MAIL >>");
        Scanner sc = new Scanner(System.in);
        System.out.print("To: ");
        String To = sc.next();

        if ( !validateTarget(accounts, To)) {
            System.err.println("[ERROR] Invalid target("+To+")");
            return;
        }

        System.out.print("title: ");
        String Title = sc.next();
        System.out.print("contents: ");
        String Contents = sc.next();
        System.out.print("attached(y/n)");
        String attached = sc.next();

        if ( !mailList.containsKey(To) ) {
            mailList.put(To, new ArrayList<>());
        }

        mailList.get(To).add(new Mail(getMaxId(), curAccount, To, Title, Contents, Objects.equals(attached, "y")));

    }

    boolean validateTarget(Set<String> accounts, String to) {
        return accounts.contains(to);
    }

    int getMaxId() {
        if ( mailList.isEmpty() )
            return 1;

        int maxId = 1;
        for (Map.Entry<String, ArrayList<Mail>> entry : mailList.entrySet()) {
            for ( final Mail m : entry.getValue() )
                maxId = Math.max(maxId, m.id);
        }

        return maxId+1;
    }
}