import java.util.*;

public class KosarajuSCC {

    //  Step 1 : DFS to store order

    static void dfs(int node ,boolean[] visited ,ArrayList<ArrayList<Integer>> graph,Stack<Integer> stack  ){
        visited[node]= true;

        for(int neigh : graph.get(node)){
            if(!visited[neigh]){
                visited[node]= true;
                dfs(neigh,visited,graph,stack);
            }
        }
        stack.push(node);
    }

    // dfs  on  transpose /reverse
    static void dfstrans(int node ,boolean[] visited ,ArrayList<ArrayList<Integer>> tgraph){

        visited[node]= true;
        System.out.print(node + " ");


        for(int neigh : tgraph.get(node)){
            if(!visited[neigh]){
                visited[node] = true;
                dfstrans(neigh , visited , tgraph);

            }
        }

        
        
    }
    // ---------- Kosaraju Algorithm ----------
    static void kosaraju(int V, ArrayList<ArrayList<Integer>> graph) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited= new boolean[V];

        // store finish order

        for(int i = 0 ; i <V ;i++){
            if(!visited[i]){
                dfs(i , visited, graph , stack);
            }
        }

        // reverse graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i =0 ; i <V ; i++){
            transpose.add(new ArrayList<>());
        }

        for(int u =0; u < V ; u++){
            for(int v : graph.get(u)){
            transpose.get(v).add(u);
        }
        }

        Arrays.fill(visited,false);

        // dfs on reversed graph
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                dfstrans(node, visited, transpose);
                System.out.println();

            }
        }


    }
        static void addEdge(ArrayList<ArrayList<Integer>> graph,
                        int u, int v) {
        graph.get(u).add(v);
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        /*
                0 → 2
                ↑   ↓
                |   |
                1 ←─┘

                2 → 3
                     ↓
                     4
                     ↑
                     |
                     └──
        */

        addEdge(graph, 0, 2);
        addEdge(graph, 2, 1);
        addEdge(graph, 1, 0);

        addEdge(graph, 2, 3);

        addEdge(graph, 3, 4);
        addEdge(graph, 4, 3);

        kosaraju(V, graph);
    }






}
