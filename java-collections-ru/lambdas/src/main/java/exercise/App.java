package exercise;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] matrix) {
        return enlargeArrayImage(matrix, 2);
    }

    public static String[][] enlargeArrayImage(String[][] matrix, int coef) {
        int rowNumber = matrix.length;
        int colNumber = (rowNumber > 0) ? matrix[0].length : 0;

        String[][] enlargeArray = new String[rowNumber * coef][colNumber * coef];

        for (int i = 0; i < rowNumber; ++i) {
            for (int j = 0; j < colNumber; ++j) {
                for (int ci = 0; ci < coef; ++ci) {
                    for (int cj = 0; cj < coef; ++cj) {
                        enlargeArray[i * coef + ci][j * coef + cj] = matrix[i][j];
                    }
                }
            }
        }

        return enlargeArray;
    }
}
// END
