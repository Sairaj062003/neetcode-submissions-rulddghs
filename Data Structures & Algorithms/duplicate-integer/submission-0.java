class Solution {
    public boolean hasDuplicate(int[] nums) {
         
        boolean value = false;
        for(int i= 0 ; i<nums.length ; i++ ){
            int ans =nums[i];
            for(int j = i+1 ; j<nums.length ; j++){
                if(ans==nums[j]){
                    value =true;
                }
            }

        }
        return value;
    }
}