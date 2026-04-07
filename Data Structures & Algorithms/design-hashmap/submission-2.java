
class MyHashMap {

    private List<Entity>[] entities;

    public MyHashMap() {
        entities = new ArrayList[1000]; // Bucket size
        for (int i = 0; i < 1000; i++) {
            entities[i] = new ArrayList<>();
        }
    }

    private class Entity {
        int key;
        int value;

        public Entity(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, int value) {
        int i = Math.abs(key % entities.length);
        List<Entity> bucket = entities[i];

        for (Entity e : bucket) {
            if (e.key == key) {
                e.value = value; // update
                return;
            }
        }

        bucket.add(new Entity(key, value)); // add new
    }

    public int get(int key) {
        int i = Math.abs(key % entities.length);
        List<Entity> bucket = entities[i];

        for (Entity e : bucket) {
            if (e.key == key) return e.value;
        }

        return -1; // not found
    }

public void remove(int key) {
    int i = Math.abs(key % entities.length);
    entities[i].removeIf(e -> e.key == key);
}

}
