import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class Monster extends MazeElement {

    // Instance variables
    private char initialDirection;
    private long lastMoveTime;
    private int pixelsPerSecond;

    // Constructor
    public Monster(Location loc, int size, String imgString, char initialDirection) {
        super(loc, size, imgString);
        this.initialDirection = initialDirection;
        this.lastMoveTime = System.currentTimeMillis();
    }

    // Getters
    public Location getLoc() {
        return super.getLoc();
    }

    public int getX() {
        return super.getLoc().getX();
    }

    public int getY() {
        return super.getLoc().getY();
    }

    // Moves the monster in the direction it is facing
    public void move(char[][] maze) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastMoveTime;

        double distanceToMove = (elapsedTime / 1000.0) * pixelsPerSecond;

        double newX = loc.getPreciseX();
        double newY = loc.getPreciseY();

        switch (initialDirection) {
            case 'U':
                newX -= 1;
                break;
            case 'D':
                newX += 1;
                break;
            case 'L':
                newY -= 1;
                break;
            case 'R':
                newY += 1;
                break;
        }

        // Check bounds and walls
        int gridX = (int) Math.floor(newX);
        int gridY = (int) Math.floor(newY);

        // Check bounds and walls
        if (gridX >= 0 && gridX < maze.length && gridY >= 0 && gridY < maze[0].length && maze[gridX][gridY] != '#') {
            loc.setPreciseX(newX);
            loc.setPreciseY(newY);
        } else {
            // Reverse direction if we hit a wall or go out of bounds
            switch (initialDirection) {
                case 'U':
                    initialDirection = 'D';
                    break;
                case 'D':
                    initialDirection = 'U';
                    break;
                case 'L':
                    initialDirection = 'R';
                    break;
                case 'R':
                    initialDirection = 'L';
                    break;
            }
        }

        lastMoveTime = currentTime;
    }

    public BufferedImage getRotatedImage() {
        double rotationRequired = 0.0;
        switch (initialDirection) {
            case 'U':
                rotationRequired = Math.toRadians(0);
                break;
            case 'D':
                rotationRequired = Math.toRadians(180);
                break;
            case 'L':
                rotationRequired = Math.toRadians(270);
                break;
            case 'R':
                rotationRequired = Math.toRadians(90);
                break;
        }
        double locationX = getImg().getWidth() / 2;
        double locationY = getImg().getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(getImg(), null);
    }

}
