/**
 * @author Adithya
 * @date    10/4/2017
 * @description
 */
public class Variable {
    /**
     * Declaring Private Variables min, min_plus_one, avg, max_minus_one, max, min_minus_one, max_plus_one
     */
    private int min;
    private int min_plus_one;
    private int avg;
    private int max_minus_one;
    private int max;
    private int min_minus_one;
    private int max_plus_one;

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }
    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }
    /**
     * @return the min_plus_one
     */
    public int getMin_plus_one() {
        return min_plus_one;
    }
    /**
     * @param min_plus_one the min_plus_one to set
     */
    public void setMin_plus_one(int min_plus_one) {
        this.min_plus_one = min_plus_one;
    }
    /**
     * @return the avg
     */
    public int getAvg() {
        return avg;
    }
    /**
     * @param avg the avg to set
     */
    public void setAvg(int avg) {
        this.avg = avg;
    }
    /**
     * @return the max_minus_one
     */
    public int getMax_minus_one() {
        return max_minus_one;
    }
    /**
     * @param max_minus_one the max_minus_one to set
     */
    public void setMax_minus_one(int max_minus_one) {
        this.max_minus_one = max_minus_one;
    }
    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }
    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }
    /**
     * @return the min_minus_one
     */
    public int getMin_minus_one() {
        return min_minus_one;
    }
    /**
     * @param min_minus_one the min_minus_one to set
     */
    public void setMin_minus_one(int min_minus_one) {
        this.min_minus_one = min_minus_one;
    }
    /**
     * @return the max_plus_one
     */
    public int getMax_plus_one() {
        return max_plus_one;
    }
    /**
     * @param max_plus_one the max_plus_one to set
     */
    public void setMax_plus_one(int max_plus_one)
    {
        this.max_plus_one = max_plus_one;
    }

    /**
     * This method is used to store the objects present in the variable class into a 2 dimensional array
     * @param variables
     * @return
     */
    public int[][] convertTo2D(Variable[] variables) {

        int[][] output = new int[variables.length][7];
        for(int i = 0; i < variables.length; i++) {
            output[i][0] = variables[i].getMin_minus_one();
            output[i][1] = variables[i].getMin();
            output[i][2] = variables[i].getMin_plus_one();
            output[i][3] = variables[i].getAvg();
            output[i][4] = variables[i].getMax_minus_one();
            output[i][5] = variables[i].getMax();
            output[i][6] = variables[i].getMax_plus_one();
        }
        return output;
    }

    /**
     * This method generates the Transpose of the Passed Matrix
     * @param matrix
     * @return
     */
    public int[][] transpose2D(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] trasposedMatrix = new int[n][m];
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                trasposedMatrix[x][y] = matrix[y][x];
            }
        }
        return trasposedMatrix;
    }
}