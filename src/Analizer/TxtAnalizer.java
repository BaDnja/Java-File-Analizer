package Analizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class TxtAnalizer implements AnalizerInterface {
    private Map<Character, Integer> charMap;

    /**
     * @param file - Name of the file as String.
     * @return List of Map/s.
     */
    @Override
    public List<Map<Character, Integer>> analyze(String file) {
        this.charMap = new HashMap<>();
        mapFile(file);
        Map<Character, Integer> upperMap = new HashMap<>();
        Map<Character, Integer> lowerMap = new HashMap<>();
        Map<Character, Integer> digitMap = new HashMap<>();
        Map<Character, Integer> specialMap = new HashMap<>();

        // Iterate through entry set of Characters map as <Character, Integer> form
        for (Map.Entry<Character, Integer> entry : this.charMap.entrySet()) {
            if (Character.isUpperCase(entry.getKey())) {
                // Add key and value to current map.
                upperMap.put(entry.getKey(), entry.getValue());
            } else if (Character.isLowerCase(entry.getKey())) {
                lowerMap.put(entry.getKey(), entry.getValue());
            } else if (Character.isDigit(entry.getKey())) {
                digitMap.put(entry.getKey(), entry.getValue());
            } else {
                specialMap.put(entry.getKey(), entry.getValue());
            }
        }
        List<Map<Character, Integer>> mapList = new ArrayList<>();

        // Check if maps are empty and add non empty to an ArrayList
        if (!upperMap.isEmpty()) {
            mapList.add(upperMap);
        }
        if (!lowerMap.isEmpty()) {
            mapList.add(lowerMap);
        }
        if (!digitMap.isEmpty()) {
            mapList.add(digitMap);
        }
        if (!specialMap.isEmpty()) {
            mapList.add(specialMap);
        }
        return mapList;
    }

    /**
     * @param file - name of the file as String
     */
    private void mapFile(String file) {
        // Read file if it exist and is not empty
        if (file != null && !file.isEmpty()) {
            Reader read = new Reader();
            String content = read.readFile(file);

            // For every character in a String, add it to Character map
            for (int i = 0; i < content.length(); i++){
                char c = content.charAt(i);
                handleKey(this.charMap, c);
            }
        } else {
            System.exit(0);
        }
    }

    /**
     * @param map - current map to be handled
     * @param key - current key of the map
     */
    private void handleKey(Map<Character, Integer> map, Character key) {
        /*
            Check if current map contains key
            If not, add that key to map and set it's value to one
            Else, increment value of a current key for 1.
        */
        if (!map.containsKey(key)) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key) + 1);
        }
    }
}
