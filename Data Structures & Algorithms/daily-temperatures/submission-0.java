class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> q = new Stack<>() ;
        
        int[] ans = new int[temperatures.length];
      for(int i =0 ; i<temperatures.length ;i++){ 
             
            while(!q.isEmpty() &&  temperatures[i]>temperatures[q.peek()]  ){
              int previndex =  q.pop();
              ans[previndex ]=i-previndex ; 
            }

             q.push(i);   

            }

        
        return ans;
    }
    }
