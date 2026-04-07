class Solution {
    public String addBinary(String a, String b) {

        StringBuilder str = new StringBuilder();
        int carry=0;
        int i = a.length()-1 , j = b.length()-1;

        while(i>= 0 || j>=0 || carry>0){
            int digit1 = i>=0 ? a.charAt(i) -'0':0;
             int digit2 = j>=0 ? b.charAt(j) -'0':0;

             int total = digit1 + digit2+carry ;

             str.append(total %2);
             carry = total /2 ;

             i--;
             j--;
        }
        return str.reverse().toString();
        
    }
}