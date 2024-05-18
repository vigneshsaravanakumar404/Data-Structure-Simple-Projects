import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Country implements Comparable<Country> {

    private String name;
    private String code;
    public int Centrality;
    public boolean tie;
    private Map<Integer, Set<Country>> borders;
    private static final int[] centralityLevelPoints = { 16, 8, 4, 2, 1 };

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
        this.Centrality = 0;
        this.borders = new HashMap<>();
        this.tie = false;
    }

    public void addBorder(Country border, int depth) {
        if (borders.containsKey(depth)) {
            borders.get(depth).add(border);
        } else {
            Set<Country> newSet = new HashSet<>();
            newSet.add(border);
            borders.put(depth, newSet);
        }
    }

    public String getName() {
        return name;
    }

    public Set<Country> getBorders(int depth) {
        return borders.getOrDefault(depth, Collections.emptySet());
    }

    public void compute() {
        populateHigherOrderBorders();
        calculateCentrality();
    }

    private void calculateCentrality() {
        int totalCentrality = 0;
        for (int depth : borders.keySet()) {
            if (depth - 1 < centralityLevelPoints.length) {
                totalCentrality += borders.get(depth).size() * centralityLevelPoints[depth - 1];
            }
        }
        Centrality = totalCentrality;
    }

    private void populateHigherOrderBorders() {
        for (int depth = 2; depth <= 5; depth++) {
            Set<Country> previousDepthBorders = borders.get(depth - 1);
            if (previousDepthBorders == null || previousDepthBorders.isEmpty()) {
                continue;
            }

            Set<Country> currentDepthBorders = borders.computeIfAbsent(depth, k -> new HashSet<>());

            for (Country country : previousDepthBorders) {
                for (Country neighbor : country.getBorders(1)) {
                    if (!neighbor.equals(this) && !isBorderInPreviousDepths(neighbor, depth)) {
                        currentDepthBorders.add(neighbor);
                    }
                }
            }
        }
    }

    private boolean isBorderInPreviousDepths(Country country, int depth) {
        for (int i = 1; i < depth; i++) {
            if (borders.getOrDefault(i, Collections.emptySet()).contains(country)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (tie) {
            return Centrality + " (tie)" + "\t\t\t" + name;
        }
        return Centrality + "\t\t\t\t" + name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Country country = (Country) obj;
        return name.equals(country.name);
    }

    @Override
    public int compareTo(Country o) {
        if (Centrality == o.Centrality) {
            tie = true;
            o.tie = true;
        }
        return Integer.compare(o.Centrality, Centrality);
    }
}
