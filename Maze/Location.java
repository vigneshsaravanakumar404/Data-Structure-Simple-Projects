public class Location {

    // Instance variables
    int x;
    int y;

    // Constructor
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incX(int x) {
        this.x += x;
    }

    public void incY(int y) {
        this.y += y;
    }

    // Equals method
    public boolean equals(Location other) {
        return this.x == other.x && this.y == other.y;
    }
}