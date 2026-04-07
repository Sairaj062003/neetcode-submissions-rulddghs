class Solution {
    public boolean validPalindrome(String s) {
    int start = 0 , end = s.length()-1;

    while(start < end){
        if(s.charAt(start)==s.charAt(end)){
            start++;
            end--;
        }
        else{
            return palindrom(start , end-1 , s) || palindrom(start+1 , end ,s);
        }
    }    
      return true;  
   }

   private boolean palindrom(int start , int end , String s){
    while(start < end){
        if(s.charAt(start)==s.charAt(end)){
            start++;
            end--;
        }
        else{
            return false;
        }
    }    
      return true;  
    
   }
}