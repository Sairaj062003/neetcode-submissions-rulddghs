class Solution {
    public int subsetXORSum(int[] nums) {
      return totalArray(nums,0,0);
        
        
    }
    static int totalArray(int[] arr , int index , int total){

        if(index==arr.length){
            return total;
        }

        return totalArray(arr,index+1 , total ^ arr[index])+totalArray(arr,index+1 , total);
    }
}