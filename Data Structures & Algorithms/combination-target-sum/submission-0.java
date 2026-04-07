class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        findcombination(0,nums,target,outer, new ArrayList<>());
        return outer;
    }
    private void findcombination(int index, int[] nums, int target,List<List<Integer>> outer, List<Integer> ds){

        if(index == nums.length){
            if(target == 0){
                outer.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[index] <= target){
            ds.add(nums[index]);
            findcombination(index,nums,target-nums[index],outer, ds);
            ds.remove(ds.size()-1);
        }
        findcombination(index+1,nums,target,outer, ds);
    }
}
