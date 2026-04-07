class Solution {
    public String simplifyPath(String path) {

        String[] tokens = path.split("/");

        Stack<String> st = new Stack<>();  

        StringBuilder str = new StringBuilder();
        int i = 0 ;
          while( i< tokens.length ){
            

            if( tokens[i].equals("..")   ){
                if( !st.isEmpty()) st.pop();
                i++;
            }
            
            else if(tokens[i].equals(".") || tokens[i].equals("")){
               i++;
            }
            else{
                st.push(tokens[i]);
                i++;
            }


          }

          if(st.isEmpty()) return "/";
      
        for(String s : st){
            str.append("/").append(s);
        }

        return str.toString();
    }
}