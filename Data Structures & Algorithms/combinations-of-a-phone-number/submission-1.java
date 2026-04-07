class Solution {
    static final String[] map ={
          "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return new ArrayList<>();
    return helper(digits, "");
    }
    static List<String> helper(String Original ,String ans){
        if(Original.isEmpty()){
          List<String> list = new ArrayList<>();  
           list.add(ans);
         return list;
     }
      int digit= Original.charAt(0) - '0';
        List<String> alllist = new ArrayList<>();
       String letter  = map[digit];

        
      for(int i = 0 ; i< letter.length(); i++){
        char ch = letter.charAt(i);

        alllist.addAll(helper(Original.substring(1),ans+ch));
              
      }

      return alllist ;

       
    }
}
