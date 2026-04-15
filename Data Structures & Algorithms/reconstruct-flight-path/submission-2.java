class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // Build graph
        for (List<String> tic : tickets) {
            adj.putIfAbsent(tic.get(0), new PriorityQueue<>());
            adj.get(tic.get(0)).offer(tic.get(1));
        }

        dfs("JFK");
        return res;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = adj.get(src);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll()); // always smallest lexicographically
        }

        res.addFirst(src); // post-order
    }
}