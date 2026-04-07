

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1: Create adjacency list
        List<List<Pair>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            list.get(u).add(new Pair(v, w));
        }

        // Step 2: Distance array
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        // Step 3: Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt(p -> p.distance)
        );

        pq.offer(new Pair(k, 0));
        result[k] = 0;

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int dist = current.distance;

            // Optimization (skip outdated entries)
            if (dist > result[node]) continue;

            for (Pair neighbor : list.get(node)) {
                int v = neighbor.node;
                int wt = neighbor.distance;

                if (dist + wt < result[v]) {
                    result[v] = dist + wt;
                    pq.offer(new Pair(v, result[v]));
                }
            }
        }

        // Step 5: Find max delay
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, result[i]);
        }

        return ans;
    }
}