class Solution {
    public int maxProduct(int[] nums) {
        int leftproduct= 1 , rigthproduct=1;
        int ans = nums[0];

        for(int i =0 ; i<nums.length ; i++){

            leftproduct =leftproduct==0 ? 1 :leftproduct;
           rigthproduct =rigthproduct==0 ? 1 :rigthproduct;


           leftproduct *=nums[i];
           rigthproduct *=nums[nums.length-1-i];



            
            ans=Math.max(ans,Math.max(leftproduct,rigthproduct));


        }
        return ans;
    }
}
