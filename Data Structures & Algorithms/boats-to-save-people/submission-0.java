class Solution {
    public int numRescueBoats(int[] people, int limit) {
       int count =0;
       Arrays.sort(people);
         int left =0 , right =  people.length -1;

         while(left<=right){
            if(people[left]+people[right] <= limit){
                left++;
            }
            right--;
            count++;
         }
       return count; 
    }
}