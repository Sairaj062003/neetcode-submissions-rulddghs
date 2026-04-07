class Pairs {
    int row , col ;

    private Pairs(int row , int col){
        this.row = row;
        this.col = col ;
    }
}


class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
      Queue<Pairs> q = new LinkedList<>();
      char[][] visited =  new char[n][m];

      for(int i =0 ; i<n ;i++){
         if(board[i][0] =='O'){
              board[i][0] ='S';
              q.add(new Pairs(i,0));
         }
         if(board[i][m-1]=='O'){
            q.add(new Pairs(i,m-1));
              board[i][m-1] ='S';
         }
      }

     for(int j =0 ; j<m ;j++){
         if(board[0][j] =='O'){
            q.add(new Pairs(0,j));
              board[0][j] ='S';
         }
         if(board[n-1][j]=='O'){
            q.add(new Pairs(n-1,j));

              board[n-1][j] ='S';
         }
      }

     
        int[][] dist = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            for(int[] arr : dist){
                int ro = r+arr[0];
                int co = c+arr[1];

                if(ro >=0 && ro<n && co>=0 && co<m && board[ro][co]=='O'){
                      board[ro][co]='S';
                     q.add(new Pairs(ro,co));
                      
                }
            }

        }

           for(int i =0 ; i<n ;i++){
            for(int j =0 ; j<m ;j++){
                if(board[i][j] == 'O' ){
                    board[i][j]='X';
                }if(board[i][j] == 'S'){
                        board[i][j] = 'O';
                }
            }
        }


    }

   
}
