class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();

       

        for(int i = 0 ; i< asteroids.length ; i++ ){
            boolean destroy = false;
          
          while (!stack.isEmpty() && asteroids[i]<0 && stack.peek()>0){
        
             if(Math.abs(asteroids[i]) == Math.abs(stack.peek())){
                     destroy = true;
                     stack.pop();
                     break;
                }
           else if(Math.abs(asteroids[i]) > Math.abs(stack.peek())){
                     stack.pop();
                     continue;

                }
                else{

                   destroy = true;
                   break; 
                }

          
          }
          if(!destroy){
            stack.push(asteroids[i]);
          }
   
        }

     int[] arr = new int[stack.size()];

     for(int i =arr.length -1; i>=0 ; i--){
        arr[i]=stack.pop();
     }

    return arr;
    }

}