public class mazeBackTrack {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
      };


       backTrack("", board, 0, 0);
    }
    static void backTrack(String p,boolean[][] arr, int r, int c){
        if(r == arr.length-1 && c == arr[0].length-1){
            System.out.println(p);
            return;
        }
        if(!arr[r][c])
        return;

        // in this block we are about to execute the next recursion calls and hence the print process is done we will mark it as FALSE
        

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
    }
}
