class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length()+num2.length()];

        for(int i = num1.length()-1 ; i>=0 ; i--){
            for(int j = num2.length()-1 ; j>=0 ;j--){

                int digit1 = num1.charAt(i)-'0';
                int digit2 = num2.charAt(j)-'0';

                int multipy = digit1*digit2;

                int positionofnum= i+j+1;
                int prepositionofcarry = i+j;

                int sum = multipy + res[positionofnum];
             

                res[positionofnum] = sum%10;
                res[prepositionofcarry] += sum/10;
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i : res){
            if(!(result.length() == 0 &&  i==0)){
            result.append(i);
            }
        }


        return result.toString();


    }
}
