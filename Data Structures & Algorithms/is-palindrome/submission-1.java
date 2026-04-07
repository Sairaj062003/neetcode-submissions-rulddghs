class Solution {
    public boolean isPalindrome(String str) {
        if(str.isEmpty()){
            return true ;
           }
        
          
          
           int start = 0;
           int last = str.length()-1;

        while(start<=last){
            char curFirst = str.charAt(start);
            char  curLast = str.charAt(last);
       
       if(!Character.isLetterOrDigit(curFirst)){
        start++;
       } else  if(!Character.isLetterOrDigit(curLast)){
        last--;
       } else {

            if(Character.toLowerCase(curFirst) != Character.toLowerCase(curLast)){
                return false ;
            }
           start++;
        		last--;

       }
        }

        return  true ;
        
    }
}
