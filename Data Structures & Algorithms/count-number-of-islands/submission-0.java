class Pair{
    int first ;
    int second ;

    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int  n = grid.length;
        int  m = grid[0].length;
        int count = 0;

        int[][] vis = new int[n][m];

        for(int i =0 ; i< n ; i++){
            for(int j = 0 ; j < m ;j++){
                if(vis[i][j] == 0  && grid[i][j] =='1'){
                    count++;
                    bfs(i , j , vis ,grid);
                }
            }
        }
       return count ;
    }

    private void bfs(int ro , int col ,int[][] vis, char[][] grid){
        vis[ro][col] = 1;
         int  n = grid.length;
        int  m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,col));

        while(!q.isEmpty()){
            int row = q.peek().first;
            int  column = q.peek().second;
            q.remove();

           addIfValid(row-1 , column , grid , vis ,q,n ,m);
           addIfValid(row , column+1 , grid , vis ,q,n ,m);
          addIfValid(row+1 , column , grid , vis ,q,n ,m);
           addIfValid(row , column-1 , grid , vis ,q,n ,m);

        }
    }

            private void addIfValid(int x , int y,char[][] grid,int[][] vis , Queue<Pair> q,int n , int m ){
            if(x >=0 && x<n && y>=0 && y<m && vis[x][y]==0 && grid[x][y]=='1' ){
                vis[x][y]=1;
                q.add(new Pair(x,y));
            }
        }

}