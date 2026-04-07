class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){

        while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
           int height = heights[ stack.pop()];
            int nse = i , pse= stack.isEmpty() ? -1:stack.peek();
            maxArea=Math.max(height*(nse-pse-1),maxArea );
        }
          stack.push(i);

        }

        while(!stack.isEmpty()){
            int nse  = n ;
            int height = heights[ stack.pop()];
            int  pse= stack.isEmpty() ? -1:stack.peek(); 
            maxArea=Math.max(  height *(nse-pse-1),maxArea );
        }

        return maxArea;
    }


}
