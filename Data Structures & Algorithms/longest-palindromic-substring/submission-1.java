class Solution {
    public String longestPalindrome(String s) {
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            int low = i, high = i;

            // Odd-length palindrome
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            String palindrom = s.substring(low + 1, high);
            if (palindrom.length() > str.length()) {
                str = palindrom;
            }

            // Even-length palindrome
            low = i;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            palindrom = s.substring(low + 1, high);
            if (palindrom.length() > str.length()) {
                str = palindrom;
            }
        }

        return str;
    }
}
