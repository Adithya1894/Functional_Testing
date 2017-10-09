/**
 * @author Adithya
 * @date    10/4/2017
 * @description This class is used to print the Test cases for Boundary Value Analysis
 * Worst Case Equivalence Class
 */

/**
 * Class  InputGenerators has the Methods for BVA(Boundary Value Analysis) and WCR(Worst case Robustness Testing)
 */
public class InputGenerators {
    /**
     * Method to print the inputs for Boundary Value Analysis
     * @param variables
     */
    public void bva(Variable[] variables) {
        /**
         * count stores the count of the variables
         */
        int count = variables.length;
        /**
         * storing count again in variable 'm'
         */
        int m = count;
        /**
         * 'x' stores the number of test cases for BVA, which is '4*n + 1'
         */
        int x  = (4 * count) + 1;
        /**
         * y stores the count or the number of variables
         */
        int y = count;
        /**
         * Declaring the variables i, q, p, j for using them in iterating through the for loops
         */
        int i, q, p, j;
        /**
         * Declaring a two dimensional array to store the Nom Values
         */
        int[][] b = new int[x][y];
        /**
         * iterating  the for loop till the number of variables which is 'm'
         */
        for(i = 0, q = 0; i < m; i++, q++) {
            /**
             * inner loop iterates till the maximum number of test cases which is stored in 'x'
             */
            for(p = 0; p < x; p++) {
                /**
                 * storing the corresponding values of Nom into the new two dimensional array
                 */
                b[p][q] = variables[i].getAvg();
            }
        }
        /**
         * Reinitializing the values of 'p', 'q' to 0
         */
        p = 0;
        q = 0;
        /**
         * Storing the remaining values - Min, Min_plus_one, Max_Minus_one, Max into the array 'b[][]', which stores the values in a transposed form
         */
        for(i = 0; i < m; i++) {
            b[p][q] = variables[i].getMin();
            /**
             * incrementing the value of 'p' after every insertion
             */
            b[++p][q] = variables[i].getMin_plus_one();
            b[++p][q] = variables[i].getMax_minus_one();
            b[++p][q] = variables[i].getMax();
            /**
             * Incrementing the value of p, q after each iteration
             */
            p++;
            q++;
        }
        /**
         * Printing the 2 dimensional array 'b[][]' which has the required test cases.
         */
        for(i = 0; i < x; i++) {
            for(j = 0; j < y; j++) {
                System.out.print(b[i][j] + "\t");
            }
            /**
             * Prints a new line
             */
            System.out.println();
        }
    }

    /**
     * This Method helps in printing the test cases for Worst Case Robustness testing
     * @param variables
     */
    public void wcr(Variable[] variables) {
        /**
         * Creating an object of the Variable class
         */
        Variable variable = new Variable();
        /**
         * Setting a final variable 'x' to 7
         */
        final int x = 7;
        /**
         * Variable 'y' gets the length of the variables
         */
        int y = variables.length;
        /**
         * created an int Array
         */
        int[] outputRow = new int[y];
        /**
         * Creeated a 2 Dimensional Array
         */
        int first[][] = new int[x][y];
        /**
         * storing the transposed variable into first
         */
        first = variable.transpose2D(variable.convertTo2D(variables));
        /**
         * Calling the Method Print
         *  @param j
         * @param row
         * @param col
         * @param first
         *
         */
        print(0, x, y, first, outputRow);
    }

    /**
     *
     * @param j
     * @param row
     * @param col
     * @param first
     * @param outputRow
     */
    private static void print(int j, int row, int col, int[][] first, int[] outputRow) {
        for (int i = 0; i < row; i++) {
            /**
             * Copying the values of first[][] into outputRow[]
             */
            outputRow[j] = first[i][j];
            if (j < col - 1) {
                /**
                 * Recursive call till 'j < col -1'
                 */
                print(j + 1, row, col, first, outputRow);
            }
            if (j == col - 1) {
                /**
                 * if j == col -1, Print the values of outputRow[k] till k  < col
                 */
                for (int k = 0; k < col; k++) {
                    System.out.print(" " + outputRow[k]);
                }
                /**
                 *Printing a New Line
                 */
                System.out.println();
            }
        }
    }
}