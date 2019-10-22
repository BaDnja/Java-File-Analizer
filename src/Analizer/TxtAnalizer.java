package Analizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class TxtAnalizer implements AnalizerInterface {
    public String file = new String();
    private Map<Character, Integer> charMap;

    @Override
    public List<Map<Character, Integer>> analize(String file) {
        this.charMap = new HashMap<>();
        mapFile(file);
        Map<Character, Integer> upperMap = new HashMap<>();
        Map<Character, Integer> lowerMap = new HashMap<>();
        Map<Character, Integer> digitMap = new HashMap<>();
        Map<Character, Integer> specialMap = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : this.charMap.entrySet()) {
            if (Character.isUpperCase(entry.getKey())) {
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

    private void mapFile(String file) {
        if (file != null && !file.isEmpty()) {
            Reader read = new Reader();
            String content = read.readFile(file);

            for (int i = 0; i < content.length(); i++){
                char c = content.charAt(i);
                handleKey(this.charMap, c);
            }
        } else {
            System.exit(0);
        }
    }

    private void handleKey(Map<Character, Integer> map, Character key) {
        if (!map.containsKey(key)) {
            map.put(key, 1);
        } else {
            map.put(key, map.get(key) + 1);
        }
    }
}
