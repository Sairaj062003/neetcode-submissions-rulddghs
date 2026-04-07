class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n , close = n ;
        List<String> list = new ArrayList<>();
        String ans = "";
        return Gparenthesis(open , close , list , ans);  
    }

    private List<String> Gparenthesis( int open  , int close ,  List<String> list,String ans ) {
         
         if(open==0 && close==0){
            list.add(ans);
            
         }
         if(open != 0){
             StringBuilder sb = new StringBuilder(ans);
              sb.append("(");
              Gparenthesis(open-1 , close , list , sb.toString()); 
         }

         if(close > open){
             StringBuilder sb1 = new StringBuilder(ans);
              sb1.append(")");
              Gparenthesis(open , close-1 , list , sb1.toString()); 
         }
      return list;
    }
}