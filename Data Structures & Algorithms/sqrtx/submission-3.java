class Solution {
    static int func(int mid , int x){
        long ans = (long) mid*mid;
        if(ans==x) return 1;
        if(ans>x) return 2 ;
        return 0 ;
    }
    public int mySqrt(int x) {
        int start =1 ;
        int end = x;

        while(start<=end){
            int mid = start + (end - start) / 2;
            int midN = func(mid,x);
            if(midN==1) return mid;
            else if(midN==0) start= mid+1;
            else end=mid-1;
        }

        return end ;
        
    }
}