class Solution {
    public void reverseString(char[] s) {
        ArrayList<Character> ch = new  ArrayList<>();

        for(char c:s){
            ch.add(c);
        }

       Collections.reverse(ch);
       

        for(int i =0 ; i<s.length ; i++){
            s[i]=ch.get(i);
        }
    }
}