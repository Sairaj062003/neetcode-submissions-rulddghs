/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int  l =0 , r=n;

        while(l<=r){
            int guss = l+(r-l)/2;
            int result = guess(guss);
            if(result==0){
                return guss;
            }
            else  if(result==1){
              l=guss+1;
            }
            else{
                r=guss-1;
            }
        }

        return -1;
    }
}