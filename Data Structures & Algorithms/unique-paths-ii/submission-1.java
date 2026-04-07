class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

          int m=  obstacleGrid.length;

          int n = obstacleGrid[0].length;


          int[][] path = new int[m][n];

          path[0][0]= obstacleGrid[0][0]==1 ? 0:1;
        

        for(int i = 1 ; i <n ; i++){
            if(obstacleGrid[0][i]==1){
                 path[0][i]=0;
            }
              else {path[0][i]=path[0][i-1];}
        }

         for(int p = 1 ; p <m ; p++){
            if(obstacleGrid[p][0]==1){
                 path[p][0]=0;
            }
           else { path[p][0]=path[p-1][0];}
        }

       for(int i = 1 ; i <m ; i++){
           for(int j = 1 ; j <n ; j++){
               

               if(obstacleGrid[i][j]==1){
                 path[i][j]=0;
            }
               

              else {  path[i][j]=path[i-1][j]+path[i][j-1]; }
           }
       }

       return path[m-1][n-1];
    }
}