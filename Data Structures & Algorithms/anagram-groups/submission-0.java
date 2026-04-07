class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outer = new ArrayList<>();
        boolean[] mark = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (mark[i]) continue; // already used

            List<String> internal = new ArrayList<>();
            char[] saaray = strs[i].toCharArray();
            Arrays.sort(saaray);

            internal.add(strs[i]);
            mark[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (mark[j]) continue;

                char[] paaray = strs[j].toCharArray();
                Arrays.sort(paaray);

                if (Arrays.equals(saaray, paaray)) {
                    internal.add(strs[j]);
                    mark[j] = true;
                }
            }

            outer.add(internal);
        }

        return outer;
    }
}
