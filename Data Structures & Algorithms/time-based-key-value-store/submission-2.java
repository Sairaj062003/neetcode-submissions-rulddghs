class Pair {
    String value;
    int time;
    
    public Pair(String value, int time) {
        this.value = value;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<Pair> pairs = map.get(key);
        
        
        int left = 0;
        int right = pairs.size() - 1;
        String result = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (pairs.get(mid).time <= timestamp) {
                result = pairs.get(mid).value;  
                left = mid + 1;  
            } else {
                right = mid - 1;  
            }
        }
        
        return result;
    }
}

