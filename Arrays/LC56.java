import java.util.*;

public class LC56 {

        public static  int[][] merge(int[][] intervals) {

            List<int[]> ans = new ArrayList<>();

            int[] current = intervals[0];

            for(int i =1 ; i < intervals.length; i++){
                if(intervals[i][0] < current[1]){ // overlap
                    current[1] = Math.max(current[1] , intervals[i][1]);

                }else{
                    ans.add(current);
                    current = intervals[i];
                }
            }
            ans.add(current);
        return ans.toArray(new  int[ans.size()][]);
    }
    
    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args){
                int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = merge(intervals);

        System.out.println("Merged Intervals:");
        printIntervals(result);
    }


    }
    

