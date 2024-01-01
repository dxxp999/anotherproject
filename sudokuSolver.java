public class sudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    if (solver(board)) {
        display(board);
    } else {
        System.out.println("Cannot solve");
    }

    }


    static boolean solver(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean noEmptyLeft = true;

        // this is how we are going to replace row and columns from arguments by
        // checking for reach row and column in the board
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) {
                    row = r;
                    col = c;
                    noEmptyLeft = false;
                    break; //! this is actually a check to pass rows and col when  empty element is found by breaking that loop
                    // we are creating arguments for each row and col to send it to solver if it is a 0
                }
            }
            // now for this row every column is checked and now no empty space is left
            if (noEmptyLeft == false){
                break; // break for this row
            }
        }
        // now when every element is passed and checked and no empty element is found
        
        if (noEmptyLeft == true){
               return true; // means sudoku is solved
        }
         
        
        for (int num = 1; num <= 9; num++) {
              if(isSafe(board, row, col, num)){
                board[row][col] = num;
                  if(solver(board)) {
                          return true; //! ans found
                  }
                  else{
                        board[row][col] = 0; //back track
                  }
              }
        }

       return false;
    }

    static void display(int[][] board){
        for (int[] row : board) {
            for (int num : row) {
            System.out.print(num + " ");
            }
            System.err.println();
            
        }
    }
    
    static boolean isSafe(int[][] board, int row, int col, int num) {
        // check the row
        for (int c = 0; c < board.length; c++) {
            if (board[row][c] == num) // checking for all the nums in that row
                return false;
        }

        // check the col
        for (int[] nums : board) {
            if(nums[col] == num)
            return false;
        }
         

        // now the square matric of 3x3 around that element
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num)
                    return false;
            }

        }
        // now if it passes all the tests it means it can be placed here
        return true;
    }

}
