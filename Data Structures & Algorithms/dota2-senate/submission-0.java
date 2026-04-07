class Solution {
    public String predictPartyVictory(String senate) {
        int r_count =0 , d_count=0;
        for(char a : senate.toCharArray()){
            if(a=='R')  r_count+=1;
            else  d_count +=1;
        }
        boolean[] arr = new boolean[senate.length()];

       int i =0 ;
        while( r_count >0 &&   d_count>0 ){

            if(arr[i] == false ){

                if(senate.charAt(i) =='R'){
                    removechar(senate , 'D', arr , i);
                     d_count--;
                }

                 if(senate.charAt(i) =='D'){
                    removechar(senate , 'R', arr , i);
                     r_count--;
                }


            }

            i = (i+1)%senate.length();
                
        }

         return r_count==0 ? "Dire":"Radiant";
    }

    private void removechar(String senate,char r ,boolean[] arr,int idx ){

        while(true){

            if(senate.charAt(idx)==r  && arr[idx]==false){
                arr[idx]=true;
                break;
            }

            idx = (idx +1)%senate.length();

        }

    }
}