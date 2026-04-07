class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board  = new char[n][n];

        for(int i = 0 ; i<n ;i++){
            for(int j =0 ; j<n ; j++){
                board[i][j]='.';
            }
        }
        placeQbacktrack(board , ans , 0,n);
        return ans;
    }

    private void placeQbacktrack(char[][] board ,List<List<String>> ans ,int row ,int n){
      
      if(row == n){
        List<String> copy = new ArrayList<>();

        for(char[] r : board){
            copy.add(new String(r));
        }
        ans.add(copy);
        return ;
      }
        for(int j =0 ; j<n ;j++){
            if(isSafe(board,row,j,n)){
                board[row][j]='Q';
                placeQbacktrack(board , ans , row+1,n);
                board[row][j]='.';
            }
        }
    }

    private boolean isSafe(char[][] board , int row , int col,int n){

        for(int j= 0 ; j< n ;j++){
            if(board [row][j]=='Q'){
                return false;
            }
        }
        for(int i = 0 ; i< n ;i++){
            if(board [i][col]=='Q'){
                return false;
            }
        }

          for(int i = row , j=col; i>=0 && j>=0  ;i--,j--){
            if(board [i][j]=='Q'){
                return false;
            }
        }

         for(int i = row , j=col; i>=0 && j<n  ;i--,j++){
            if(board [i][j]=='Q'){
                return false;
            }
        }

        return true;
    }

}
