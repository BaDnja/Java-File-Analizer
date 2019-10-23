package Analizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Reader {
    private Scanner sc;

    private void openFile(String fileName) {
        try {
            sc = new Scanner(new File(String.format("%s", fileName)));
        }
        catch (FileNotFoundException e) {
            System.out.println(String.format("\n'%s' Not Found", fileName));
            System.exit(0);
        }
    }

    private void closeFile() {
        sc.close();
    }

    String readFile(String fileName) {
        String str = "";
        openFile(fileName);
        while (sc.hasNext()) {
            str += sc.next();
        }
        closeFile();
        if (str.length() == 0) {
            System.out.println("\nFile is empty.");
            System.exit(0);
        }
        return str;
    }
}
