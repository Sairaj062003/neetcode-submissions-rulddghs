class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // DFS from Pacific borders
        for (int i = 0; i < n; i++) dfs(heights, pacific, i, 0, -1);
        for (int j = 0; j < m; j++) dfs(heights, pacific, 0, j, -1);

        // DFS from Atlantic borders
        for (int i = 0; i < n; i++) dfs(heights, atlantic, i, m - 1, -1);
        for (int j = 0; j < m; j++) dfs(heights, atlantic, n - 1, j, -1);

        // intersection
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] vis, int r, int c, int prev) {
        int n = heights.length, m = heights[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m) return;
        if (vis[r][c]) return;
        if (prev != -1 && heights[r][c] < prev) return;

        vis[r][c] = true;

        dfs(heights, vis, r + 1, c, heights[r][c]);
        dfs(heights, vis, r - 1, c, heights[r][c]);
        dfs(heights, vis, r, c + 1, heights[r][c]);
        dfs(heights, vis, r, c - 1, heights[r][c]);
    }
}
