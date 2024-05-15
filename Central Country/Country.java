import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Country implements Comparable<Country> {

    private String name;
    private String code;
    public int Centrality;
    private Map<Integer, Set<Country>> borders;
    private static final int[] centralityLevelPoints = { 16, 8, 4, 2, 1 };

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
        this.Centrality = 0;
        this.borders = new HashMap<>();
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

    public void calculateCentrality() {
        for (Integer depth : borders.keySet()) {
            Set<Country> countriesAtDepth = borders.get(depth);
            for (Country country : countriesAtDepth) {
                country.Centrality += centralityLevelPoints[depth - 1];
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Set<Country> getBorders(int depth) {
        return borders.getOrDefault(depth, Collections.emptySet());
    }

    @Override
    public String toString() {
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
        return Integer.compare(o.Centrality, Centrality);
    }
}
