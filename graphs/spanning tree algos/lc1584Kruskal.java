import java.util.*;

public class lc1584Kruskal {
    static int[] parent;

    static class Edge{
        int node;
        int dest;
        int wt ;
        Edge(int node , int dest, int wt){
            this.node = node;
            this.dest = dest;
            this.wt = wt;
        }

    }

    static int manhattan(int[] pt1 , int[] pt2){
        return Math.abs(pt1[0] -pt2[0]) + Math.abs(pt1[1] - pt2[1]);

    }

   
    static void dsu(int n){
        parent = new int[n];
        for(int i =0; i <n ; i++){
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

    public static int minCostConnectPoints(int[][] points){
        int n = points.length;

        ArrayList<Edge> graph = new ArrayList<>();

        
        for(int i =0; i < n; i++){
            for(int j = i +1; j <n ; j++){
                int cost = manhattan(points[i], points[j]);
                graph.add(new Edge(i , j, cost));
            }
        }


        dsu(n);
        Collections.sort(graph , (a,b) -> a.wt - b.wt);

        int edgeused =0;
        int mincost =0;

        for(Edge edges : graph){
            int u = edges.node;
            int v = edges.dest;
            int w = edges.wt;

            if(find(u) != find(v)){
                union(u,v);
                mincost+= w;
                edgeused++;

                if(edgeused == n-1){
                break;
            }

            }
            


        }
    return mincost;


    }
        public static void main(String[] args) {

        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int answer = minCostConnectPoints(points);

        System.out.println("\nMinimum Cost = " + answer);
    }

    
}
