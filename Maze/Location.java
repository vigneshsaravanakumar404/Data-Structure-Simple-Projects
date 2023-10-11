public class Location {

    // Instance variables
    int x;
    int y;
    double preciseX;
    double preciseY;

    // Constructors
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.preciseX = x;
        this.preciseY = y;
    }

    public Location(double x, double y) {
        this.preciseX = x;
        this.preciseY = y;
        this.x = (int) Math.floor(x);
        this.y = (int) Math.floor(y);
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Increment methods
    public void incX(int dx) {
        this.x += dx;
        this.preciseX += dx;
    }

    public void incY(int dy) {
        this.y += dy;
        this.preciseY += dy;
    }

    public void incX(double dx) {
        this.preciseX += dx;
        this.x = (int) Math.floor(this.preciseX);
    }

    public void incY(double dy) {
        this.preciseY += dy;
        this.y = (int) Math.floor(this.preciseY);
    }

    // Equals method
    public boolean equals(Location other) {
        return this.x == other.x && this.y == other.y;
    }

    public void setPreciseX(double preciseX) {
        this.preciseX = preciseX;
        this.x = (int) Math.floor(this.preciseX);
    }

    public void setPreciseY(double preciseY) {
        this.preciseY = preciseY;
        this.y = (int) Math.floor(this.preciseY);
    }

    public double getPreciseX() {
        return this.preciseX;
    }

    public double getPreciseY() {
        return this.preciseY;
    }
}
