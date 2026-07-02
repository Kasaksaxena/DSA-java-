import java.util.*;

public class LC1584 {

    static class Pair{
        int node ;
        int cost;
        Pair(int node , int cost){
            this.node = node;
            this.cost = cost;
        }

    }
     
    static int Manhattan(int[] pt1 , int[] pt2){
        return Math.abs(pt1[0] - pt2[0] ) + Math.abs(pt1[1] - pt2[1]);
    }

    static void addEdge(ArrayList<ArrayList<Pair>> graph , int u , int v , int cost){
        graph.get(u).add(new Pair( v , cost));
        graph.get(v).add(new Pair( u , cost));

    }



    static int minCostConnectPoints(int[][] points) {

        int n = points.length;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i =0 ; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0 ; i <n;i++){
            for(int j = i+ 1 ; j <n; j++){
                int cost = Manhattan(points[i] , points[j]);
                addEdge(graph, i, j, cost);

            }
        }

        // prims algo 

        boolean[] visited = new boolean[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.cost - b.cost
        );

        pq.offer(new Pair(0,0));
        int totalsum =0;

        while(!pq.isEmpty()){
          
            Pair current = pq.poll();

            int node = current.node;
            int cost1 = current.cost;

            if(visited[node]){
                continue;
            }
            visited[node] = true;
            totalsum += cost1;

            for(Pair neigh  : graph.get(node)){

                if(!visited[neigh.node]){
                    pq.offer(new Pair(neigh.node , neigh.cost));
                }

            }
        }

    return totalsum;

        }

    public static void main(String[] args) {

        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int ans = minCostConnectPoints(points);
        System.out.println(ans);

    }
    
}
