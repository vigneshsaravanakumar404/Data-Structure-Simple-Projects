import java.util.*;

public class BBallComparators {

	// Example use of Comparator from driver file where players isan
	// ArrayList<BasketballPlayer>
	// Collections.sort(players, new BBallComparators.FirstNameComparator());

	public static class FirstNameComparator implements Comparator<BasketballPlayer> {

		public int compare(BasketballPlayer firstPlayer, BasketballPlayer secondPlayer) {
			return firstPlayer.firstName().compareTo(secondPlayer.firstName());
		}

	}

	public static class LastNameComparator implements Comparator<BasketballPlayer> {

		public int compare(BasketballPlayer firstPlayer, BasketballPlayer secondPlayer) {
			return firstPlayer.lastName().compareTo(secondPlayer.lastName());
		}
	}

}