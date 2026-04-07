class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);    
        if(nums.length==0)  return 0 ;
        int count = 0;
       
       
        for(int  i =0 ; i < nums.length ; i++){
              
              if(   nums[i] == nums[i+1]){
                 return nums[i];

                 
              }

        }

        return count ;
    
    }
}
