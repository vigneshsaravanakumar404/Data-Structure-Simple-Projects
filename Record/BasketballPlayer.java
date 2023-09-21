import java.util.Comparator;

public record BasketballPlayer(String firstName, String lastName, int jerseyNumber, double pointsPerGame) {

	public String toString() {
		return firstName + "\t" + lastName + "\t" + jerseyNumber + "\t" + pointsPerGame;
	}

}