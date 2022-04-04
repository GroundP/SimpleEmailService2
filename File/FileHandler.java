package File;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    public static boolean readAccounts(HashMap<String, String> accounts) {
        try {
            FileReader fr = new FileReader("accounts.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while((str = br.readLine()) != null) {
                String[] strArr = str.split(",");
                System.out.println(Arrays.toString(strArr));
                accounts.put(strArr[0], strArr[1]);
            }
            br.close();
            return true;
        }
        catch (IOException io) {
            io.printStackTrace();
            return false;
        }
    }

    public static void saveAccounts(final HashMap<String, String> accounts) {
        try {
            FileWriter fw = new FileWriter("accounts.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Map.Entry<String, String> a : accounts.entrySet() ) {
                bw.write(a.getKey()+"," + a.getValue() + "\n");
            }
            bw.close();
        }
        catch (IOException a) {
            a.printStackTrace();
        }

    }
}