class Solution {
    public boolean isHappy(int n) {
        
        int sum ;
     List<Integer> list = new ArrayList<>();
        while(n!=1){
            sum=0;
            while(n!=0){
                int lastdigit = n%10;
                int num = lastdigit * lastdigit;
                sum+=num;
                n/=10;
            }
            if(!list.contains(sum)){
                list.add(sum);
            }else{
                return false;
            }
            n=sum;
        }

        return true;
    }
}
