class Solution {
 public void sortColors(int[] nums) {
        for (int i =0 ; i <nums.length ; i++){

        int last = nums.length - i -1;
        int max = getmaxelement(nums , 0 , last);
        swap(nums,max,last);
        }
        
    }
      static int getmaxelement(int[] arr, int start ,int last){
        int max= start;
        for(int i = start ; i<=last ; i++){
            if(arr[max]<=arr[i]){
                max=i;
            }
        }
        return max;
      }
     
     static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second]=temp;
     }
}