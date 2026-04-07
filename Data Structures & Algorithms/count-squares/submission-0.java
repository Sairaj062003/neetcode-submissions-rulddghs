

class CountSquares {

    
    Map<Integer, Map<Integer, Integer>> ptscount;

    public CountSquares() {
        ptscount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];

        ptscount.putIfAbsent(x, new HashMap<>());
        ptscount.get(x).put(y, ptscount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1];
        int totalSquares = 0;

        
        if (!ptscount.containsKey(px)) return 0;

       
        for (Map.Entry<Integer, Integer> entry : ptscount.get(px).entrySet()) {
            int y2 = entry.getKey();
            int verticalCount = entry.getValue();

            if (y2 == py) continue; 
            int side = Math.abs(y2 - py);

            
            totalSquares += countSquare(px, py, y2, px + side, verticalCount);

            // Check square on the left
            totalSquares += countSquare(px, py, y2, px - side, verticalCount);
        }

        return totalSquares;
    }

    private int countSquare(int x1, int y1, int y2, int x3, int verticalCount) {
        
        if (!ptscount.containsKey(x3)) return 0;

        Map<Integer, Integer> col = ptscount.get(x3);

        int p1 = col.getOrDefault(y1, 0); // (x3, y1)
        int p2 = col.getOrDefault(y2, 0); // (x3, y2)

        // Multiply frequencies
        return p1 * p2 * verticalCount;
    }
}
