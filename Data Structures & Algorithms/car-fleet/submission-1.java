class Solution {
    
    public int carFleet(int target, int[] position, int[] speed) {
        int count =1;
        int[][] arr= new int[position.length][2];

        for(int i = 0 ; i <position.length ;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
            
        }

        Arrays.sort(arr,(a,b)->Integer.compare(b[0],a[0]));

        double time = (double)(target - arr[0][0])/arr[0][1];

        for(int i =1 ; i<position.length ; i++){
            double currtime=(double) (target - arr[i][0])/arr[i][1];

            if(currtime > time ){
                count++;
                time=currtime;
            }
        }

        return count;
    }
}
