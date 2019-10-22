package Analizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Writer {

    String currentFileName;

    public Writer(String fileName) {
        currentFileName = fileName;
    }

    public void write() {
        TxtAnalizer txtAnalizer = new TxtAnalizer();
        List<Map<Character, Integer>> mapList = txtAnalizer.analize(currentFileName);
        if (!mapList.isEmpty()) {
            for (Map<Character, Integer> map : mapList) {
                Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
                if (Character.isUpperCase(entry.getKey())) {
                    System.out.println("\nUpperCase: " + map);
                } else if (Character.isLowerCase(entry.getKey())) {
                    System.out.println("\nLowerCase: " + map);
                } else if (Character.isDigit(entry.getKey())) {
                    System.out.println("\nDigits: " + map);
                } else {
                    System.out.println("\nSpecials: " + map);
                }
            }
        }
    }
}