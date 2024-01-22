import java.util.ArrayList;

public class WhichAreIn { 
	
	public static String[] inArray(String[] array1, String[] array2) {
        ArrayList<String> result = new ArrayList<String>();

        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s2.contains(s1) && !result.contains(s1)) {
                    result.add(s1);
                }
            }
        }
        result.sort(String::compareTo);

        return result.toArray(new String[0]);
        
	}
}
