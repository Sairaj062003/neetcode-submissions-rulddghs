class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumgas = Arrays.stream(gas).sum();
        int sumcost= Arrays.stream(cost).sum();

        if(sumgas<sumcost){return -1;}

        int currentgas =0 , startindex= 0;

        for(int i =0 ; i<cost.length;i++){
            currentgas += gas[i]-cost[i];

            if(currentgas <0){
                startindex=i+1;
                currentgas=0;
            }
        }
        return startindex;
    }
}
