package Analizer;
import java.util.Map;
import java.util.List;

public interface AnalizerInterface {

    public List<Map<Character, Integer>> analyze(String file);

    private void mapFile(String file) {}

    private void handleKey(Map<Character, Integer> map, Character key) {}
}

