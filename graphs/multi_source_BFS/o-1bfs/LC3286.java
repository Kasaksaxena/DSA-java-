import java.util.*;
public class LC3286 {

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int row = grid.size();
        int col = grid.get(0).size();

        int[][] dist = new int[row][col];

        for(int i =0; i < row ;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[] {0,0});
        dist[0][0] = grid.get(0).get(0);


        int[][] dir ={
             {1,0},{-1,0},{0,1},{0,-1}

        };


        while(!dq.isEmpty()){
            int[] cell = dq.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir){
                int newr = r + d[0];
                int newc = c + d[1];

                if(newr < 0 || newc < 0 || newr >= row || newc >= col){
                    continue;
                }
                int weight = grid.get(newr).get(newc);
                int newdist = dist[r][c] + weight;

                if(newdist < dist[newr][newc]){
                    dist[newr][newc] = newdist;

                    if(weight == 0){
                        dq.offerFirst(new int[] {newr, newc});
                    }else{
                        dq.offerLast(new int[] { newr, newc});
                    }
                }


            }
        }
    return dist[row-1][col-1] < health;
    }

        public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(0, 1, 0, 0));
        grid.add(Arrays.asList(0, 1, 0, 1));
        grid.add(Arrays.asList(0, 0, 0, 0));
        grid.add(Arrays.asList(1, 1, 1, 0));

        int health = 2;

        boolean ans = findSafeWalk(grid, health);

        System.out.println("Can reach safely = " + ans);
    }

    
}
