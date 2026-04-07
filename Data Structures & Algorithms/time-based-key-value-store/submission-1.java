

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
        
        
        String result = "";
        for (Pair pair : pairs) {
            if (pair.time <= timestamp) {
                result = pair.value;  
            } else {
                break;  
        }
        
       
    }
     return result;
}
}