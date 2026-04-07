class Solution {
    public int openLock(String[] deadends, String target) {
        String str = "0000";

       
     HashSet<String> set = new HashSet<>();

        

       for(String s : deadends){
             set.add(s);
        }

         if(set.contains(str)){
            return -1 ;
         }

        Queue<String> q = new LinkedList<>();
        q.offer(str);
         set.add(str);
        int level = 0;

        while(!q.isEmpty()){

            int n = q.size();

            while(n-- >0){
                String  s = q.poll();

                if(s.equals(target)){
                     return level;

                }

                bfsfillslot(s , set , q);
            }
            level++;
        }

        return -1;
    }

    private void bfsfillslot( String  s , HashSet<String> set , Queue<String> q){
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0 ; i<4 ; i++){
            char ch = s.charAt(i);

            char dec = ch == '0' ? '9' : (char)(ch - 1);
            char inc = ch == '9' ? '0' : (char)(ch + 1);
            
             sb.setCharAt(i, dec);
             if(!set.contains(sb.toString())){
                q.offer(sb.toString());
                set.add(sb.toString());
             }
              sb.setCharAt(i, inc);
             if(!set.contains(sb.toString())){
                q.offer(sb.toString());
                set.add(sb.toString());
             }
          sb =  new StringBuilder(s);
        
        }

    }
}