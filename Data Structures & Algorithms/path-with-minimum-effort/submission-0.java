class Node {
    int dir ;
    int r ;
    int c;

    Node(int dir , int r, int c ){
        this.dir=dir;
        this.r=r;
        this.c=c;     
    }
}


class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;


         int[][] res = new int[n][m];

        for(int i = 0 ; i<n ;i++){
            Arrays.fill(res[i] , Integer.MAX_VALUE);
        }
            
         PriorityQueue<Node> pq = new PriorityQueue<>( (a,b) -> Integer.compare(a.dir,b.dir));
         pq.add(new Node(0,0,0));
         res[0][0]=0;

         return djalgo(heights,res,pq);
         
    }

    private int djalgo(int[][] heights,int[][] res,PriorityQueue<Node> pq){


      while(!pq.isEmpty()){ 
       int d = pq.peek().dir;
       int r = pq.peek().r;
       int c = pq.peek().c;

       pq.poll();

       int[] row={-1,0,1,0};
       int[] col = {0,1,0,-1};

         for(int i = 0 ;i < 4 ;i++){
            int ro = r+row[i];
            int co = c+col[i];

            shortpath(r,c,ro,co,heights,res,pq,d);

         }

       
    }
    return res[heights.length-1][heights[0].length-1];
    }

    private void shortpath(int r,int c,int ro,int co,int[][] heights,int[][] res,PriorityQueue<Node> pq,int d){
         
          if(ro >= 0  && co>=0 && ro< heights.length && co< heights[0].length) 
          { int dist =Math.max(d, Math.abs(heights[r][c]-heights[ro][co]));
                if(  dist<res[ro][co] ){
           
                     pq.add(new Node(dist,ro,co));
                     res[ro][co]=dist;
                        
               
            }

        }
   }
        

    
    
}