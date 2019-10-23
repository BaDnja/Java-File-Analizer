package Analizer;
import java.util.Map;
import java.util.List;

public interface AnalizerInterface {

    public List<Map<Character, Integer>> analyze(String file);
}