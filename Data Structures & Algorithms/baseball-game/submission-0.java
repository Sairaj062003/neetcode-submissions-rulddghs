class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

         for(String op : operations){
          if(op.equals("+")){
              int top = st.pop();
              int newtop = top + st.peek();
              st.push(top);
               st.push(newtop);
          } 
          else if(op.equals("C")){
            st.pop();
           }
           else if(op.equals("D")){
            int top = 2* st.peek();
            st.push(top);
           }
           else{
             st.push(Integer.parseInt(op));
           }

         }
       int sum =0;
         for(int i : st){
            sum+=i;
         }

         return sum;
    }
}