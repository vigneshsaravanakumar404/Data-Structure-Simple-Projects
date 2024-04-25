import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Graph {

    private HashMap<String, HashSet<String>> g;

    public Graph() {
        g = new HashMap<String, HashSet<String>>();
    }

    public void add(String node1, String node2) {
        if (!g.containsKey(node1)) {
            g.put(node1, new HashSet<String>());
        }

        if (!g.containsKey(node2)) {
            g.put(node2, new HashSet<String>());
        }

        g.get(node1).add(node2);
        g.get(node2).add(node1);

    }

    public boolean dfs(String start, String end) {

        return dfs(start, end, new HashSet<String>());
    }

    public boolean dfs(String curr, String end, Set<String> visited) {
        visited.add(curr);
        if (curr.equals(end))
            return true;

        for (String n : g.get(curr)) {
            if (!visited.contains(n) && dfs(n, end, visited)) {
                return true;
            }
        }

        return false;

    }

    public String toString() {
        String out = "";
        for (Map.Entry<String, HashSet<String>> entry : g.entrySet()) {
            out += entry.getKey() + " -> " + entry.getValue() + "\n";
        }
        return out.substring(0, out.length() - 2);
    }

    public String dfsPathR(String start, String end) {
        return dfsPathR(start, end, new HashSet<String>());
    }

    public String createPath(ArrayList<String> visited, String start, String end) {
        String path = "";
        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i).equals(end)) {
                path += visited.get(i);
                break;
            }
            path += visited.get(i) + " -> ";
        }
        return path;
    }

    private String dfsPathR(String curr, String end, Set<String> visited) {
        visited.add(curr);
        if (curr.equals(end))
            return curr;

        for (String n : g.get(curr)) {
            if (!visited.contains(n)) {
                String path = dfsPathR(n, end, visited);
                if (path != null) {
                    return curr + " -> " + path;
                }
            }
        }

        return null;
    }

    public String dfspathI(String start, String end) {
        Stack<String> stack = new Stack<String>();
        ArrayList<String> visited = new ArrayList<String>();

        stack.push(start);
        while (!stack.empty()) {
            String curr = stack.pop();
            visited.add(curr);
            if (curr.equals(end)) {
                break;
            }
            for (String n : g.get(curr)) {
                if (!visited.contains(n)) {
                    stack.push(n);
                }
            }
        }

        return createPath(visited, start, end);
    }

    public String ShortestPath(String start, String end) {
        Queue<String> queue = new LinkedList<String>();
        ArrayList<String> visited = new ArrayList<String>();
        HashMap<String, String> path = new HashMap<String, String>();

        queue.add(start);
        visited.add(start);
        path.put(start, null);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(end)) {
                break;
            }
            for (String n : g.get(curr)) {
                if (!visited.contains(n)) {
                    queue.add(n);
                    visited.add(n);
                    path.put(n, curr);
                }
            }
        }

        String curr = end;
        String out = "";
        while (curr != null) {
            out = curr + " -> " + out;
            curr = path.get(curr);
        }

        return out.substring(0, out.length() - 4);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        String line = "";

        try {

            File file = new File("AllStateEdges.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                graph.add(line.split(" ")[0], line.split(" ")[1]);

            }

            br.close();

        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }

        System.out.println(graph);
        String start = "WA";
        String end = "TX";
        System.out.println("Path from " + start + " to " + end + ": " + graph.dfs(start, end));
        System.out.println("Path from " + start + " to " + end + ": " + graph.dfsPathR(start, end));
        System.out.println("Path from " + start + " to " + end + ": " + graph.dfspathI(start, end));
        System.out.println("Shortest Path from " + start + " to " + end + ": " + graph.ShortestPath(start, end));
    }

}
