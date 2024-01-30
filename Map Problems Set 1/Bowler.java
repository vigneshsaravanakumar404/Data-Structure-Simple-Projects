public class Bowler implements Comparable<Bowler> {
    
    private String name;
    private int score;

    public Bowler(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Bowler other) {
        String[] thisName = this.name.split(" ");
        String[] otherName = other.name.split(" ");
        int lastCompare = thisName[1].compareTo(otherName[1]);
        if (lastCompare == 0) {
            return thisName[0].compareTo(otherName[0]);
        }
        return lastCompare;
    }


}
