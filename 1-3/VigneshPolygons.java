import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VigneshPolygons {
    public static void main(String[] args) {

        // Get input from file
        try {
            File file = new File("1-3\\polygons.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] sides;
            String[] angles;
            while ((line = br.readLine()) != null) {

                // Determine if it is a polygon
                sides = line.split("\\|")[0].split(",");
                angles = line.split("\\|")[1].split(",");

                // Print the result
                if (isPolygon(sides, angles)) {
                    System.out.println(line + " is possibly a polygon");
                } else {
                    System.out.println(line + " is NOT a polygon");
                }

            }
            br.close();
        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }
    }

    // Method to determine if a polygon is valid
    static boolean isPolygon(String[] sidesStr, String[] anglesStr) {

        // Convert to int arrays
        int[] sides = new int[sidesStr.length];
        for (int i = 0; i < sidesStr.length; i++) {
            sides[i] = Integer.parseInt(sidesStr[i]);
        }
        int[] angles = new int[anglesStr.length];
        for (int i = 0; i < anglesStr.length; i++) {
            angles[i] = Integer.parseInt(anglesStr[i]);
        }

        // Check if angles = sides
        if (sides.length < 3 || angles.length < 3) {
            return false;
        } else if (sides.length != angles.length) {
            return false;
        }

        // Check if sum of angles = (sides - 2) * 180
        int sumOfAngles = 0;
        for (int angle : angles) {
            sumOfAngles += angle;
        }
        if (sumOfAngles != (sides.length - 2) * 180) {
            return false;
        }

        // Check if each side is less than the sum of the other sides
        for (int side : sides) {
            int sumOfOtherSides = 0;
            for (int otherSide : sides) {
                sumOfOtherSides += otherSide;
            }
            sumOfOtherSides -= side;
            if (side > sumOfOtherSides) {
                return false;
            }
        }

        return true;
    }
}