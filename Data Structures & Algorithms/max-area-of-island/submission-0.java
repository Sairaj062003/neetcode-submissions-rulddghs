public class Pair{
    int first;
    int second ;

    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxarea =0;

        int[][] vis = new int[n][m];

        for(int i =0 ; i<n ;i++){
            for(int j =0 ; j<m ;j++){
              
              if(vis[i][j]==0 && grid[i][j]==1){
                maxarea=Math.max(maxarea,dfs(i,j,vis,grid));
              }

            }
        }
      return maxarea;  
    }

    private int dfs(int row , int column , int[][] vis , int[][] grid){
        int[] mover={+1,0,-1,0};
        int[] movec={0,+1,0,-1};
        int n = grid.length;
        int m = grid[0].length;

        vis[row][column] =1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,column));
        int count=1;

        while(!q.isEmpty()){
            int r= q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int i = 0 ;i<4 ;i++){
                int ro = r+mover[i];
                int co = c+movec[i];

                if(ro>=0 && ro<n && co>=0 && co<m && vis[ro][co]==0 && grid[ro][co]==1 ){
                    count++;
                    q.add(new Pair(ro,co));
                    vis[ro][co]=1;
                }
            }
            
        }
        return count;

    }
}
