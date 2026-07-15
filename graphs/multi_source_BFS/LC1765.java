import java.util.*;

public class LC1765 {

    public static int[][] highestPeak(int[][] isWater) {

        int row =isWater.length;
        int col =isWater[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] height = new int[row][col];

        for(int i = 0; i < row;i++){
                Arrays.fill(height[i],-1);
            }
        

        for(int i = 0; i < row;i++){
            for(int j=0; j< col ;j++){
                if(isWater[i][j] == 0){
                    height[i][j] = 0;
                    q.offer(new int[] {i ,j});
                }
            }
        }
        int[][] dir ={
                {1,0},{-1,0},{0,1},{0,-1}

            };


        while(!q.isEmpty()){
            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            for(int[] d : dir){
                int newr = r + d[0];
                int newc = c + d[1];

                if(newr >= 0 && newc >= 0 && newr < row && newc < col && height[newr][newc] == -1){
                    height[newr][newc]= height[r][c] + 1;
                    q.offer(new int[]{newr,newc});

                }
            }
            
            
        }
        return height;
    }
        public static void printMatrix(int[][] matrix) {

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] isWater = {
                {0, 1},
                {0, 0}
        };

        System.out.println("Input (1 = Water, 0 = Land):");
        printMatrix(isWater);

        int[][] answer = highestPeak(isWater);

        System.out.println("\nHighest Peak Matrix:");
        printMatrix(answer);
    }


}