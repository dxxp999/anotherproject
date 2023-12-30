public class mazeObstacle {
    public static void main(String[] args) {
       boolean[][] board = {
             {true, true, true},
             {true, false, true},
             {true, true, true}
       };


        maze("", board, 0, 0);
    }
    static void maze(String p, boolean arr[][], int r, int c){
        if(r == arr.length-1 && c == arr[0].length-1){
            System.out.println(p);
            return;
        }
        if(!arr[r][c])
        return;

        if(r<arr.length-1){
            maze(p+'D', arr, r+1, c);
        }
        if(c<arr[0].length-1){
             maze(p+'R', arr, r, c+1);
        }
    }
    
}
