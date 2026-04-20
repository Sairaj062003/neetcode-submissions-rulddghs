class Solution {

    int count ;
    public int totalNQueens(int n) {
        count = 0;
        char[][] board  = new char[n][n];

        for(int i = 0 ; i<n ;i++){
            for(int j =0 ; j<n ; j++){
                board[i][j]='.';
            }
        }
        placeQbacktrack(board ,  0 ,n );
        return count;
    }

    private void placeQbacktrack(char[][] board ,int row ,int n ){
      
      if(row == n){
         count+=1;
        return ;
      }
        for(int j =0 ; j<n ;j++){
            if(isSafe(board,row,j,n)){
                board[row][j]='Q';
                placeQbacktrack(board ,  row+1,n );
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