public class newSudoku {
    public static void main(String[] args) {
        
    }
    public boolean solve(char[][] board){
        int n = board.length;
        for(int row = 0; row<n; row++){
            for(int col = 0; col<n; col++){
                if(board[row][col]=='.'){
                    for(int tryNum = 1; tryNum<=9; tryNum++){
                        if(isSafe(board, row, col, tryNum)){
                            board[row][col]=(char)(tryNum +'0');
                            if(solve(board)){
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                    
                }
                
            }
        }
        return true;
    }

    static boolean isSafe(char[][] board, int row, int col, int num) {
        // check the row
        for (int c = 0; c < board.length; c++) {
            if (board[row][c] == (char)(num + '0')) // checking for all the nums in that row
                return false;
        }

        // check the col
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == (char)(num + '0')) // checking for all the nums in that row
                return false;
        }
         

        // now the square matric of 3x3 around that element
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == (char)(num + '0'))
                    return false;
            }

        }
        // now if it passes all the tests it means it can be placed here
        return true;
    }
    
}
