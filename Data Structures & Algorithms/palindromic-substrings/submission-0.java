class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindromes
            count += expand(s, i, i);
            // Even-length palindromes
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private int expand(String s, int low, int high) {
        int cnt = 0;
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            cnt++;           // ✅ count this palindrome
            low--;
            high++;
        }
        return cnt;
    }
}
