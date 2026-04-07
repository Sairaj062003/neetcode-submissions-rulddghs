class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //check for each row 

        boolean isValid = true;
        
        for(int i = 0 ; i< board.length ; i++){
            isValid= isrowvalid(i,board) && iscolumnvalid(i,board);
            if(!isValid) return false; 
        }
        
            for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return isValid;
        
    }

    private boolean isrowvalid(int row ,char[][] board){
        Set<Character> seen = new HashSet<>();
          for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
            return true;

    }

    private boolean iscolumnvalid(int col ,char[][] board){
         Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
            return true;
        }
            

    }
    

