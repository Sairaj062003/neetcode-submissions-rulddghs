class Pairs{
    int first;
    char c ;

    Pairs(int first , char c){
        this.first=first;
        this.c=c;
    }
}


class Solution {
    public String longestDiverseString(int a, int b, int c) {
       
      PriorityQueue<Pairs> pq = new PriorityQueue<>((p,t) -> Integer.compare (t.first,p.first));

      if(a>0){
        pq.offer(new Pairs(a,'a'));
      }
      if(b>0){
        pq.offer(new Pairs(b,'b'));
      }
      if(c>0){
        pq.offer(new Pairs(c,'c'));
      }

      StringBuilder str = new StringBuilder();

      while(!pq.isEmpty()){

        int currentfreq = pq.peek().first;
        char currentch = pq.peek().c;
        pq.poll();

        if( str.length() >=2 && str.charAt(str.length()-1) == currentch && str.charAt(str.length()-2) == currentch ){
            
            if(pq.isEmpty()) break;

            int freq = pq.peek().first;
            char ch = pq.peek().c;
            pq.poll();

            str.append(ch);
            freq--;

            if(freq>0){
                pq.offer(new Pairs(freq,ch));
            }

        }
        else{
            str.append(currentch);
            currentfreq--;

        }
        if(currentfreq>0){
                pq.offer(new Pairs(currentfreq,currentch));
            }
      }
        return str.toString();
        
    }
}