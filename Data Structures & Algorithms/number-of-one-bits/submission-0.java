class Solution {
    public int hammingWeight(int n) {
        int one_count =0;
        while( n!=0){
             n = n&(n-1);
             one_count++;
        }
        return one_count;
    }
}
