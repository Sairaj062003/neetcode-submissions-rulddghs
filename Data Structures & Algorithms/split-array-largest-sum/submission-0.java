class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Arrays.stream(nums).max().getAsInt();
        int end = Arrays.stream(nums).sum();

        while(start<=end){
            int mid = start+(end-start)/2;

            if(isvalidmid(nums,k,mid)) end=mid-1 ;
            else{
                start=mid+1;
            }
        }
        return start;
    }
    private boolean isvalidmid(int[] nums,int k , int mid){
        int count = 1;
        int sum = 0;
        for(int num : nums){
            if((sum+num)>mid){
                count++;
                sum = num;
            }
            else{
                sum += num;
            }
        }
        return count <= k;
    }
}