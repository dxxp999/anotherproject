import java.util.Arrays;

public class mazeBackTrack {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
      };

       int[][] path = new int[board.length][board[0].length];
       backTrackCount("", board, 0, 0,path,1);
    }
    static void backTrack(String p,boolean[][] arr, int r, int c){
        if(r == arr.length-1 && c == arr[0].length-1){
            
            System.out.println(p);
            return;
        }
        if(!arr[r][c])
        return;

        //! in this block we are about to execute the next recursion calls and hence the print process is done we will mark it as FALSE
        arr[r][c]=false;

        if(r<arr.length-1){
            backTrack(p+'D', arr, r+1, c);
        }
        if(c<arr[0].length-1){
             backTrack(p+'R', arr, r, c+1);
        }
        if(r > 0){
            backTrack(p+'U', arr, r-1, c);
        }
        if(c > 0){
            backTrack(p+'L', arr, r, c-1);
        }
        //! Here the reccursive function call ends and here we should mark the cell true again for the future calls
        arr[r][c]=true;

    }
        static void backTrackCount(String p,boolean[][] arr, int r, int c, int[][] path,int step){
        if(r == arr.length-1 && c == arr[0].length-1){
            path[r][c]=step;
            for (int[] ok : path) {
                System.out.println(Arrays.toString(ok));
                
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!arr[r][c])
        return;
        path[r][c]=step;

        //! in this block we are about to execute the next recursion calls and hence the print process is done we will mark it as FALSE
        arr[r][c]=false;

        if(r<arr.length-1){
            backTrackCount(p+'D', arr, r+1, c,path,step+1);
        }
        if(c<arr[0].length-1){
             backTrackCount(p+'R', arr, r, c+1,path,step+1);
        }
        if(r > 0){
            backTrackCount(p+'U', arr, r-1, c,path,step+1);
        }
        if(c > 0){
            backTrackCount(p+'L', arr, r, c-1,path,step+1);
        }
        //! Here the reccursive function call ends and here we should mark the cell true again for the future calls
        arr[r][c]=true;
        path[r][c]=0;

    }
}
