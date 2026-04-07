class FreqStack {

    HashMap<Integer, Stack<Integer>> st ;
     HashMap<Integer, Integer> freq ;
     int maxfirst ;
    public FreqStack() {
        st = new HashMap<>();
        freq = new HashMap<>();
        maxfirst = 0;
    }
    
    public void push(int val) {
       
       freq.put(val , freq.getOrDefault(val, 0)+1);

       if(!st.containsKey(freq.getOrDefault(val, 0))){
        st.put(freq.getOrDefault(val, 0), new Stack<Integer>());
       }
        st.get(freq.getOrDefault(val, 0)).push(val) ;
      maxfirst=Math.max(maxfirst ,freq.getOrDefault(val, 0) );
        
    }
    
    public int pop() {
        int ans = st.get(maxfirst ).pop();
         
           freq.put(ans , freq.getOrDefault(ans, 0)-1);
       
          if(st.get(maxfirst ).size() == 0){
            maxfirst--;
          }


        return ans ;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */