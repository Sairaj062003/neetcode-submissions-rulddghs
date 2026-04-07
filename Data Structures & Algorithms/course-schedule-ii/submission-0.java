class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] visited = new int[numCourses];
        int[] pathvisite = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
         Stack<Integer> stack = new Stack<>();

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
                if (checkCycle(i, adj, visited, pathvisite ,stack)) {
                    return new int[]{};  // cycle exists → cannot finish all courses
                }
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result; // no cycle found → all courses can be finished
    }

    private boolean checkCycle(int node, List<List<Integer>> adj, int[] visited, int[] pathvisite,Stack<Integer> stack) {
        visited[node] = 1;
        pathvisite[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (checkCycle(neighbor, adj, visited, pathvisite,stack)) {
                    return true; // cycle found
                }
            } else if (pathvisite[neighbor] == 1) {
                return true; // back edge found → cycle
            }
        }

        pathvisite[node] = 0; // backtrack
        stack.push(node);
        return false;
    }
}

