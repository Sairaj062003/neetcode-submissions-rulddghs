class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> map = new HashMap<>();

        // build frequency map for t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int n = s.length(), minlength = Integer.MAX_VALUE;
        int s_index = -1, m = t.length(), l = 0, r = 0, count = 0;

        while (r < n) {
            char right = s.charAt(r);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) >= 0) count++;
            }

            while (count == m) {
                if (r - l + 1 < minlength) {
                    minlength = r - l + 1;
                    s_index = l;
                }

                char left = s.charAt(l);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0) count--;
                }
                l++;
            }
            r++;
        }

        return s_index == -1 ? "" : s.substring(s_index, s_index + minlength);
    }
}
