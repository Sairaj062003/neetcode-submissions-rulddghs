class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // prefix array with extra row and column
        prefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               int top =  i>0 ? prefix[i-1][j]:0;
               int left = j>0 ? prefix[i][j-1]:0;
               int topleft = (i>0 && j>0) ? prefix[i-1][j-1]:0;

               prefix[i][j]=matrix[i][j]+top+left-topleft;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];

        int top = row1>0 ? prefix[row1-1][col2] :0 ;

        int left = col1>0 ? prefix[row2][col1-1] :0 ;

        int topleft = (row1>0 && col1>0) ?  prefix[row1-1][col1-1] :0 ;

    int sum = total-left-top+topleft;

    return sum ;

    }
}
