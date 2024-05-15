public class Edge {

    private Vertex v1;
    private Vertex v2;
    private int distance;

    public Edge(Vertex v1, Vertex v2, int distance) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distance;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge e = (Edge) obj;
            return (this.v1.equals(e.v1) && this.v2.equals(e.v2))
                    || (this.v1.equals(e.v2) && this.v2.equals(e.v1));
        }
        return false;
    }

    @Override
    public String toString() {
        return v1 + " - " + v2 + " (" + distance + ")";
    }

}
