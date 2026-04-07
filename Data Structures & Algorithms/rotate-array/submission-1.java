class Solution {
    public void rotate(int[] nums, int k) {

        int[] rotate = new int[nums.length];
        k %= nums.length;

            for(int i = 0 ; i<nums.length  ;i++){
                 rotate[(i+k) % nums.length]=nums[i];
            }
            

           for(int i = 0 ; i<nums.length  ;i++){
              nums[i] =  rotate[i];
            }

        
    }
}