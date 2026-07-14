import java.util.*;
public class LC994 {

        public static int orangesRotting(int[][] grid) {

            int row = grid.length;
            int col = grid[0].length;

            Queue<int[]> q = new LinkedList<>();
            int[][] dir ={
                {1,0},{-1,0},{0,1},{0,-1}

            };

            int freshcount =0;
            int minutes =0;

            for(int i = 0; i < row ; i++){
                for(int j = 0; j< col; j++){
                    if(grid[i][j] == 2){
                        q.add(new int[] {i,j});
                    }else if(grid[i][j] == 1){
                        freshcount++;
                    }
                }
            }

            while(!q.isEmpty() && freshcount > 0){
                int size = q.size();
                for(int i =0; i < size; i++){

                    int[] cell = q.poll();
                    int r = cell[0];
                    int c = cell[1];

                    for(int[] d : dir){
                        int newr = r + d[0];
                        int newc = c + d[1];

                        if(newr >= 0 && newc >=0 && newr < row && newc < col && grid[newr][newc] == 1){
                            grid[newr][newc] =2;
                            freshcount--;
                            q.offer(new int[] {newr , newc});
                        }
                    }
                }
            minutes++;

            }
        return ( freshcount ==0)?minutes:-1;
        }

    public static void printGrid(int[][] grid) {

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println("Original Grid:");
        printGrid(grid);

        int answer = orangesRotting(grid);

        System.out.println("\nGrid After Rotting:");
        printGrid(grid);

        System.out.println("\nMinimum Minutes = " + answer);
    }
    
}
