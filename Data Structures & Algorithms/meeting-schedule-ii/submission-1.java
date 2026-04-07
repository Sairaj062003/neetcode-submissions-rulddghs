/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

         TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (Interval i : intervals) {
            mp.put(i.start, mp.getOrDefault(i.start, 0) + 1);
            mp.put(i.end, mp.getOrDefault(i.end, 0) - 1);
        }

        int overlap=0;
        int maxoverlap=0;

        for(int i : mp.keySet()){
           overlap += mp.get(i);
            maxoverlap = Math.max(maxoverlap,overlap);

           
        }
        return maxoverlap ;

        

    }
}
