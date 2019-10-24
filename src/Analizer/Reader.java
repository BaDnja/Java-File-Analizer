package Analizer;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Reader {
    private Scanner sc;

    /**
     * @param fileName String - name of the file. Also void method.
     */
    private void openFile(String fileName) {
        try {
            sc = new Scanner(new File(String.format("%s", fileName)));
        }
        catch (FileNotFoundException e) {
            System.out.println(String.format("\n'%s' Not Found", fileName));
            System.exit(0);
        }
    }

    /**
     * No parameters. Void method.
     */
    private void closeFile() {
        sc.close();
    }

    /**
     * @param fileName String - name of the file.
     * @return File content as String
     */
    String readFile(String fileName) {
        String str = "";
        openFile(fileName);
        while (sc.hasNext()) {
            str += sc.next();
        }
        closeFile();
        if (str.length() == 0) {
            JOptionPane.showMessageDialog(null, "File is empty or not txt type.");
            System.exit(0);
        }
        return str;
    }
}
