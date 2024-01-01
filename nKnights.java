public class nKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        for (boolean[] row : board) {
            for (boolean element : row) {
                element = false;
            }
            
        }
        knights(board, 0, 0, n);
    }
    static void knights(boolean[][] board, int row, int col, int knights){
    if(knights == 0){
        display(board);
        System.err.println();
        return;
    }

    if(col == board.length && row == board.length - 1)
    return;
    //! this one marks as we have finished one row for all columns and we have to move next
    if(col == board.length){
       knights(board, row+1, 0, knights);
        return;
    }

    //!this is the main recurrance check 
    //* Study this to remember
    if(isSafe(board, row, col)){
        board[row][col]= true; // marking it as safe to place 
        knights(board, row, col+1, knights-1); // going on to the next one to check via recurance
        board[row][col]=false; // marking it as unsafe to place again after we print it once, cause we will find another way to do it 
    }
        knights(board, row, col+1, knights); // even if we can't place the knight we need to see for the next element to proceed
        
    
    }
   //! this one checks if we can safely place the knight here by obbserving the previous r - 2 && col -1 parameter are true or not
    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1])
            return false;
        }

           if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1])
            return false;
        }

           if(isValid(board, row -1, col-2)){
            if(board[row-1][col-2])
            return false;
        }

           if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2])
            return false;
        }
        return true;
    }
    //! maintaining comment to display all the boards
    static void display(boolean[][] board){
        for (boolean[] row : board) {
            for (boolean element : row) {
                if(element)
                System.out.print("K ");
                else
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //! this one checks if the r -2 and col - 2 parameter that we have sent is not going out of bound 
    static boolean isValid(boolean[][] board, int row, int col){
        if(row > 0 && row < board.length && col > 0 && col < board[0].length)
        return true;

        return false;
    }
}
