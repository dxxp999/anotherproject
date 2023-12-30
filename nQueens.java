public class nQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] maze = new boolean[n][n];
        for (int r = 0; r < maze.length; r++) {
            for(int c=0; c<maze[0].length; c++){
                maze[r][c]=false;
            }
            
        }
        System.out.println(queens(maze,0));
    }
 static int queens(boolean[][] maze, int r){
        if(r == maze.length){
            display(maze);
            System.out.println();
            return 1;
        }
        int count = 0;
        // for counting the maximum number of ways queens can be placed

        //*placing the Queen and checking if it can be placed or not
        for (int col = 0; col < maze.length; col++) {
            if(isSafe(maze, r, col)){
               maze[r][col]=true; //marking it as safe 
               count = count + queens(maze, r+1);
               maze[r][col] = false; //markig it as unsafe while coming back from the recursion
            }
            
        }
       return count;
    }
private static boolean isSafe(boolean[][] maze, int r, int c) {
    // check for vertical 
    for(int i=0; i<r; i++){
        if(maze[i][c])
        return false;
    }

    //check for left-diagonal
    int maxLeft = Math.min(r,c);
    for (int i = 1; i <= maxLeft; i++) {
        if(maze[r-i][c-i])
        return false;
        // added a comment
    }

    // check for right-diagonal
    int rightAllowed = Math.min(r, maze.length - c - 1);
    for(int i = 1; i<=rightAllowed; i++){
        if(maze[r-i][c+i])
        return false;
    }
    return true;
  
}
static void display(boolean[][] maze){
    for (boolean[] row : maze) {
        for (boolean element : row) {
            if(element)
            System.out.print(" Q");
            else
            System.out.print(" X");
        }
        System.out.println();
    }
}
    
}
