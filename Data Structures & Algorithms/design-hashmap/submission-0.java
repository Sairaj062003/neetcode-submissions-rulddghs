class MyHashMap {

    private Entity[] entitie ;

    public MyHashMap() {
        entitie  = new Entity[1000];
    }

    private class Entity{
        int key ;
        int value;

        public Entity(int key,int value){
            this.key= key;
            this.value = value;
        }
    }
    
    public void put(int key, int value) {

        int i = Math.abs(key % entitie.length);
        entitie[i]= new Entity(key,value);
        
    }
    
    public int get(int key) {
        int i = Math.abs(key % entitie.length);
        if(entitie[i]!=null && entitie[i].key == key){
        return entitie[i].value;
        }
     return -1;
    }
    
    public void remove(int key) {
        int i = Math.abs(key % entitie.length);
       if(entitie[i]!=null && entitie[i].key == key){
            entitie[i]=null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */