import java.util.*;

public class EulerPathCircuit {

    static void checkEuler(int V, ArrayList<ArrayList<Integer>> graph) {

        int odd = 0;

        for (int i = 0; i < V; i++) {

            int degree = graph.get(i).size();

            System.out.println("Degree of " + i + " = " + degree);

            if (degree % 2 != 0) {
                odd++;
            }
        }

        System.out.println();

        if (odd == 0) {
            System.out.println("Euler Circuit Exists");
        }
        else if (odd == 2) {
            System.out.println("Euler Path Exists");
        }
        else {
            System.out.println("Neither Euler Path nor Euler Circuit Exists");
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0,1);
        addEdge(graph,1,2);
        addEdge(graph,2,3);
        addEdge(graph,3,0);

        checkEuler(V,graph);
    }
}