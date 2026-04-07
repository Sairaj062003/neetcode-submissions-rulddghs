class Solution {
    public int evalRPN(String[] tokens) {
        int i  = 0 ;
        
        Stack<Integer> stack = new Stack<>();

        while(i< tokens.length){

            if(tokens[i].equals("+") || tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("/") )
     {

                   int top1 = stack.peek(); 
                   stack.pop();
                   int newtop = stack.peek();
                   stack.pop();
                   int con =0;
                 switch(tokens[i]){
                       case "+":
                         con =  newtop + top1 ; 
                        stack.push(con);
                        break;
                       
                        case "-":
                         con = newtop-top1; 
                        stack.push(con);
                        break;

                        case "*":
                         con =  newtop *  top1 ; 
                        stack.push(con);
                        break;

                        case "/":
                         con =  newtop / top1 ; 
                        stack.push(con);
                        break;

                
            }
            }
            else{
                       stack.push(Integer.parseInt(tokens[i]));
                 }
              i++;

            }

            return stack.peek();
            
        }

        
    
}
