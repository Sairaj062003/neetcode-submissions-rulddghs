class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    List<String> res = new ArrayList<>();
    int n;

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();

        for (List<String> tic : tickets) {
            adj.putIfAbsent(tic.get(0), new ArrayList<>());
            adj.get(tic.get(0)).add(tic.get(1));
        }

        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        }

        List<String> path = new ArrayList<>();
        dfs("JFK", path);

        return res;
    }

    private boolean dfs(String from, List<String> path) {
        path.add(from);

        if (path.size() == n + 1) {
            res = new ArrayList<>(path);
            return true;
        }

        if (!adj.containsKey(from)) {
            path.remove(path.size() - 1);
            return false;
        }

        List<String> list = adj.get(from);

        for (int i = 0; i < list.size(); i++) {
            String to = list.remove(i);

            if (dfs(to, path)) return true;

            list.add(i, to); // backtrack
        }

        path.remove(path.size() - 1);
        return false;
    }
}