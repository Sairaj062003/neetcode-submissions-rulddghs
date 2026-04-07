class Solution {
    public String longestPalindrome(String Original) {
        
        String longest = "";
        
        for(int i =0 ; i <Original.length() ; i++ ){
        for(int j = i+1 ; j<=Original.length() ; j++){
            String step = Original.substring(i,j);
            String rev=  new StringBuilder(step).reverse().toString();

            if(rev.equals(step)){

                if(step.length() > longest.length()){
                    longest=step;
                }
            } 
        }
       }

           return longest ;  
         }
        
        
        


}