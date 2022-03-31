import Login.LoginController;
import Email.EmailController;

import java.util.Scanner;

public class MainController {
    LoginController loginController;
    EmailController emailController;

    MainController(){
        loginController = new LoginController();
        emailController = new EmailController();
    }

    enum CATEGORY{
        IDX,
        SIGNUP,
        SIGNIN,
        LIST,
        EXIT,
    }

    boolean start(){
        while ( true )
        {
            System.out.println("<< MAIN >>");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 회원리스트 조회");
            System.out.println("4. 종료");

            Scanner scanner = new Scanner(System.in);
            final int select = scanner.nextInt();
            switch (CATEGORY.values()[select]) {
                case SIGNUP -> loginController.processSignUp();
                case SIGNIN -> loginController.processSignIn();
                case LIST -> loginController.showAccountList();
                case EXIT -> System.exit(0);
                default -> throw new IllegalStateException("Unexpected value: " + CATEGORY.values()[select]);
            }
        }
    }
}