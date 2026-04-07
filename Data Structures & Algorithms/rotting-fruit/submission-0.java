class Pair{
    int ro;
    int col;
    int time ;

    Pair( int ro, int col,int time ){
        this.ro = ro; 
        this.col = col;    
        this.time = time;    
        
           }
}

class Solution {
 
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cuntfress =0 ;
        int[][] visit = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i= 0 ; i< n ; i++ ){
            for(int j =0 ; j<m ;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visit[i][j]=2;
                }
                else if(grid[i][j]==0){
                    visit[i][j]=0;
                }
                else{
                    cuntfress++;
                }
            }
        }
         
         int tim = 0;
         int count = 0;
         int[] drow={-1 , 0,+1 ,0};
         int[] dcol={0,+1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().ro;
            int column = q.peek().col;
            int tm = q.peek().time;
             tim = Math.max(tim , tm);
            q.remove();

            for( int i = 0 ; i < 4 ;i++ ){
                int r = row+drow[i];
                int c = column+dcol[i];

                if( r>=0 && r<n && c>=0 && c<m && visit[r][c] != 2 && grid[r][c] == 1){
                    q.add(new Pair(r,c,tm+1));
                    visit[r][c] = 2;
                     count ++;
                }
            }

        }
          if(cuntfress != count )  return -1;

        return tim;
    }
}
