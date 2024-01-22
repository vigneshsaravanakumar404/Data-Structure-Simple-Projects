import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
    }

    public Map<String, String> mapBully(Map<String, String> map) {
        String temp = map.get("a");
        if (temp == null){
          return map;
        }
        map.put("a", "");
        map.put("b", temp);
        return map;
      }
      
}