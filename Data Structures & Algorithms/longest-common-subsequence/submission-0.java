class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.length() == 0 || text2.length() == 0) return 0;

        if (text1.equals(text2)) return text1.length();

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                dp[i][j] = -1;
            }
        }

        return dfs(text1, text2, dp, 0, 0);
    }

    private int dfs(String text1, String text2, int[][] dp, int row, int col){

        if (row == text1.length() || col == text2.length()) return 0;

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        if (text1.charAt(row) == text2.charAt(col)) {
            dp[row][col] = 1 + dfs(text1, text2, dp, row + 1, col + 1);
        } else {
            dp[row][col] = Math.max(
                dfs(text1, text2, dp, row + 1, col),
                dfs(text1, text2, dp, row, col + 1)
            );
        }

        return dp[row][col];
    }
}