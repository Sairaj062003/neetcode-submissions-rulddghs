class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
         Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        int start =0 ;
        int end =0 ;

        outer.add(new ArrayList<>());


        for(int i =0 ; i<arr.length ; i++){
             start =0 ;
            //if my current element and previous element is same than
            if( i>0 && arr[i]==arr[i-1]){
                start = end+1;
            }
            end=outer.size()-1;

            int n = outer.size();
            for(int j =start ; j<n ; j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }

        }

        return outer;
        
    }
}
