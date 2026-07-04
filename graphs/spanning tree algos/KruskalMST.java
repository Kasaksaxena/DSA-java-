import java.util.*;

public class KruskalMST{
    static int[] parent;

    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src , int dest , int wt){
            this.src =src ;
            this.dest= dest ; 
            this.wt= wt;
        }
    }

    static void  dsu(int n){
        parent = new int[n];

        for(int i =0; i <n;i++){
            parent[i] =i;
        }

    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
    return parent[x] = find(parent[x]);
    }

    static void union(int a , int b){
     int parenta = find(a);
      int parentb = find(b);
      if(parenta != parentb){
        parent[parentb] = parenta;
      }
    }

        static int kruskal(int n, ArrayList<Edge> edges) {

            Collections.sort(edges , (a,b) -> a.wt - b.wt);

            dsu(n);

            int mstcost =0;
            int edgeused =0;

            for(Edge edge : edges){
                int u = edge.src;
                int v = edge.dest;
                int cost = edge.wt;

                // if no cycle
                if(find(u) != find(v)){
                    union(u,v);

                    mstcost += cost;
                    edgeused++;
                    System.out.println(
                        u + " - " + v + " : " + cost);

                    if(edgeused == n-1){
                        break;
                    }

                }
            }
        return mstcost;
        }

            public static void main(String[] args) {

        int n = 4;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int answer = kruskal(n, edges);

        System.out.println("Minimum Cost = " + answer);
    }



}