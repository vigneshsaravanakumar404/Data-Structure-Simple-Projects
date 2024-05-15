import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WeightedGraph {

    private Map<Vertex, HashSet<Edge>> list;

    public WeightedGraph() {
        list = new HashMap<>();
    }

    public void addEdge(Vertex v1, Vertex v2, int d) {

        Edge e = new Edge(v1, v2, d);
        if (!list.containsKey(v1)) {
            list.put(v1, new HashSet<>());
        }
        if (!list.containsKey(v2)) {
            list.put(v2, new HashSet<>());
        }
        list.get(v1).add(e);
        list.get(v2).add(e);
    }

    public Set<Vertex> getVertices() {
        return list.keySet();
    }

    public Vertex getVertex(String name) {
        for (Vertex v : list.keySet()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        Vertex vertex = new Vertex(name);
        return vertex;
    }

    // getEdges
    public Set<Edge> getEdges() {
        Set<Edge> edges = new HashSet<>();
        for (HashSet<Edge> edgeSet : list.values()) {
            for (Edge e : edgeSet) {
                edges.add(e);
            }
        }

        return edges;
    }

    public Set<Vertex> getNeighbors(Vertex v) {
        Set<Vertex> neighbors = new HashSet<>();
        for (Edge e : list.get(v)) {
            if (e.getV1().equals(v)) {
                neighbors.add(e.getV2());
            } else {
                neighbors.add(e.getV1());
            }
        }
        return neighbors;
    }

    public int getDistance(Vertex v1, Vertex v2) {
        HashSet<Edge> edges = list.get(v1);

        for (Edge e : edges) {
            if (e.getV1().equals(v2) || e.getV2().equals(v2)) {
                return e.getDistance();
            }
        }

        return Integer.MAX_VALUE;
    }

    // TODO: To be implemented
    public String findPath(Vertex v1, Vertex v2) {
        return null;
    }
}