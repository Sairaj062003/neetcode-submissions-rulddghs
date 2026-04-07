public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double res = 1;
        long k=Math.abs((long)n);
        while(k>0) {
            
            if(k%2==1){
                res *=x;
                k=k-1;
            }
            else{
                k=k/2;
                x*=x;
            }
            
        }
        return n >= 0 ? res : 1 / res;
    }
}