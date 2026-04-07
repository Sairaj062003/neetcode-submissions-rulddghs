class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
    int[] arr = new int[51];
     Arrays.fill(arr, -1);
        Set<String> set = new HashSet<>();
        for(String str : dictionary){
            set.add(str);
        }

        return search(0 , s ,set ,arr,n );
    }

    private int search(int i , String s ,Set<String> set , int[] arr,int n){

        if(i == n){return 0;}

        if(arr[i]  != -1){
            return arr[i];
        }

        int result = 1 + search(i+1 , s , set , arr,n);

        for(int t = i ; t<s.length() ; t++){
            if(set.contains(s.substring(i , t+1))){
                result=Math.min(result, search(t+1 , s , set ,arr,n));
            }
        }
        return arr[i]=result;
    }
}