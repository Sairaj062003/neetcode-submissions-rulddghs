class Solution {
    public String decodeString(String s) {
        Stack<String> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

       
        
        for(int i = 0 ; i<s.length() ; i++){
           
           if(Character.isDigit(s.charAt(i))){
                int num = 0;
    while (i < s.length() && Character.isDigit(s.charAt(i))) {
        num = num * 10 + (s.charAt(i) - '0');
        i++;
    }
    i--; 
    st2.push(num);
           }
           
           else if(s.charAt(i) == ']'){

               StringBuilder cum  = new StringBuilder();

             while(!st1.peek().equals("[")){
                cum.insert(0, st1.pop());
             }
              st1.pop(); 

             int repeat = st2.pop();
                String repeated = cum.toString().repeat(repeat);
                st1.push(repeated);
           }
           else{
               st1.push(Character.toString(s.charAt(i)));
           }

        }


        StringBuilder result  = new StringBuilder();

        for(String st : st1){
            result.append(st);
        }

       return  result.toString(); 
    }
}