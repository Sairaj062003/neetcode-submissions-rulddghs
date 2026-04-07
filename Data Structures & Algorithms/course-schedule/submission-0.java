class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] pathvisite = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
        }

        // DFS to check for cycles
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (checkCycle(i, adj, visited, pathvisite)) {
                    return false;  // cycle exists → cannot finish all courses
                }
            }
        }

        return true; // no cycle found → all courses can be finished
    }

    private boolean checkCycle(int node, List<List<Integer>> adj, int[] visited, int[] pathvisite) {
        visited[node] = 1;
        pathvisite[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (checkCycle(neighbor, adj, visited, pathvisite)) {
                    return true; // cycle found
                }
            } else if (pathvisite[neighbor] == 1) {
                return true; // back edge found → cycle
            }
        }

        pathvisite[node] = 0; // backtrack
        return false;
    }
}
