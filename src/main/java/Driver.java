/**
 * @author Adithya
 * @date   10/4/2017
 * @description Functinoal Testing input generators
 * Boundary Value Analysis
 * Worst Case Robustness testing
 * Weak Normal Equivalence Class
 * Weak Robust Equivalence Class
 */
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Driver class
 * This class takes care of reading the input and passing it to the appropriate classes and methods
 */
public class Driver {
    /**
     * Console class to read the input from the command line
     */
    static Console console = System.console();

    /**
     *
     * @param args
     * Main method takes care of calling the proper method based on the input.
     */
    public static void main(String[] args) {

        /**
         * Reading the first line of the input
         */
        String option = console.readLine();
        /**
         * Reading the second line of the input, which is the selection of the test case
         */
        String variable_count = console.readLine();
        /**
         * parsing the string to integer
         */
        int n = Integer.parseInt(variable_count);
        /**
         * Creating object of the InputGenerators class
         */
        InputGenerators generators = new InputGenerators();
        Variable[] variables;
        /**
         * Passing the obtained choice in integer format to switch case
         */
        int choice = Integer.parseInt(option);
        switch(choice) {
            /**
             * This calls the Boundary value analysis function
             */
            case 1: variables = inputSingleRange(n);
                generators.bva(variables);
                break;
            /**
             * This calls the Worst case Robustness class Testing Method
             */
            case 2: variables = inputSingleRange(n);
                generators.wcr(variables);
                break;
            /**
             * This calls the Weak Noraml Equivalence Class Method, Which is the part of Driver Class
             */
            case 3: inputMultipleRange(n, choice);
                break;
            /**
             * This calls the Weak Robust Equivalence Class Method
             */
            case 4: inputMultipleRange(n, choice);
                break;
        }
    }

    /**
     *
     * @param n
     * @return
     * This takes the Number of variables as a parameter 'n' and cleans the input
     */
    public static Variable[] inputSingleRange(int n) {

        Variable[] variable = new Variable[n];
        /**
         * for loop to iterate over the number of variables
         */
        for(int i = 0; i < n; i++) {
            variable[i] = new Variable();
            /**
             * taking the input into the input from the console
             */
            String input = console.readLine();
            /**
             * storing the splitted version of the input in parts array, splitting by a ','
             */
            String[] parts = input.split(",");

            int max = 0, min = 0;
            /**
             * Checking to see if the splitted value starts with '['
             */
            if(parts[0].startsWith("[")) {
                min = Integer.parseInt(parts[0].replace("[", ""));
                variable[i].setMin(min);
                variable[i].setMin_plus_one(min+1);
                variable[i].setMin_minus_one(min-1);
                /**
                 * Checking to see, if the value starts with '(' , if yes, incrementing the value by 1
                 */
            } else {
                min = Integer.parseInt(parts[0].replace("(", ""));
                variable[i].setMin(min+1);
                /**
                 * setting the min, min_plus_one, Min_minus_one values
                 */
                variable[i].setMin_plus_one(min+2);
                variable[i].setMin_minus_one(min);
            }
            /**
             * Checking to see if the second part of the splitted variable ends with '['
             */
            if(parts[1].endsWith("]")) {
                /**
                 * if it starts with '[', replacing it with empty character
                 */
                max = Integer.parseInt(parts[1].replace("]", ""));
                /**
                 * setting the max, max_minus_one, Max_plus_one values
                 */
                variable[i].setMax(max);
                variable[i].setMax_minus_one(max-1);
                variable[i].setMax_plus_one(max+1);
                /**
                 * checking if it ends with '(', if yes , decreasing the value by 1
                 */
            } else {
                /**
                 * Replacing the value ')' by empty character.
                 */
                max = Integer.parseInt(parts[1].replace(")", ""));
                /**
                 * setting the Max, Max_minus_one, Max_plus_one values
                 */
                variable[i].setMax(max-1);
                variable[i].setMax_minus_one(max-2);
                variable[i].setMax_plus_one(max);
            }
            /**
             * Getting the Nom Values for each variable here and storing it in avg
             */
            int avg = (max + min)/2;
            /**
             * storing the avg in variable[i]
             */
            variable[i].setAvg(avg);
        }
        return variable;
    }

    /**
     * This Method generates the outputs for Weak Noraml Equivalence calss, Weak Robust Equivalence Class
     * @param n
     * @param choice
     */
    public static void inputMultipleRange(int n, int choice) {
        /**
         * This Data Structure is used to store the Nom values of each range of each variable.
         */
        ArrayList<ArrayList<Integer>> finalized_values=new ArrayList<ArrayList<Integer>>();
        /**
         * Created a string list to store the input lines in the form of a string
         */
        List<String> list = new ArrayList<String>();
        /**
         * Declared a variable to store the maximum number of partitions present in the input for a variable
         */
        int maximum_length = 0;
        /**
         * Corresponding_id stores the varible which has the maximum_number of partitions, for now it is initiliazed to 0
         */
        int corresponding_id = 0;
        /**
         * declared integer i,j to use in the for loops for iterating over the input
         */
        int i, j;
        /**
         * for loop to iterate over the number of variables and store the input in the variable input
         */
        for(i = 0; i < n; i++) {
            String input = console.readLine();
            /**
             * adding the input string into the string list
             */
            list.add(input);
            /**
             * splitting the input when a ';' appears
             */
            String[] parts = input.split(";");
            /**
             * Finding the maximum number of partitions in the input and storing it in the variable maximum_length
             */
            if(parts.length > maximum_length) {
                maximum_length = parts.length;
                /**
                 * immediately after finding the maximum number of partitions in a input, getting the id of it and storing in corresponding_id
                 */
                corresponding_id = i;
            }
        }
        /**
         * This for loop is used to replace all the brackets present in the input with empty characters.
         */
        for(i = 0; i < list.size(); i++) {
            /**
             * declaring the variables starting and ending to store the partitioned values in them
             */
            int starting = 0, ending = 0;
            /**
             * splitting with ';' by getting the values from the list
             */
            String[] parts = list.get(i).split(";");
            /**
             * creating a integer ArrayList
             */
            ArrayList<Integer> al = new ArrayList<Integer>();
            for(j = 0; j < parts.length; j++) {
                /**
                 * splitting the partitions to get the values of start range and the end range of each partition
                 */
                String[] tokens = parts[j].trim().split(",");
                /**
                 * replacing the brackets again with empty space
                 */
                if(tokens[0].startsWith("[")) {
                    starting = Integer.parseInt(tokens[0].trim().replace("["," ").trim());
                }
                /**
                 * if the value starts with '(' then increment the value by 1.
                 */
                else {
                    starting = Integer.parseInt(tokens[0].trim().replace("("," ").trim()) + 1;
                }
                /**
                 * checking again if it ends with '['
                 */
                if(tokens[1].endsWith("]")) {
                    ending = Integer.parseInt(tokens[1].trim().replace("]"," ").trim());
                }
                /**
                 * checking again if it ends with '(' and reducing the value by 1
                 */
                else {
                    ending = Integer.parseInt(tokens[1].trim().replace(")"," ").trim()) - 1;
                }
                /**
                 * getting the mean values of each of these partitions of each of the variables.
                 */
                int mean_value = (starting + ending)/2;
                /**
                 * this part executes only if the selection of the test case is set to Weak Robust Equivalence Class
                 */
                if(i == corresponding_id && choice == 4) {
                    /**
                     * This is setting the  invalid inputs for Weak Robust Equivalence Class
                     */
                    int new_values = -(starting - 1);
                    /**
                     * adding the invalid inputs to the ArrayList 'al'
                     */
                    al.add(new_values);
                }
                /**
                 * I am adding the Nom values of each partition of each variable into this ArrayList
                 */
                al.add(mean_value);
            }
            /**
             * Adding the ArrayList 'al' into the ArrayList of ArrayList 'finalized_values'
             */
            finalized_values.add(al);
        }
        /**
         * this executes only for weak Robust Equivalence class
         */
        if(choice == 4)
            maximum_length = 2 * maximum_length;
        /**
         * Here is the logic for printing the test cases
         * I am iterating the outer_loop till the maximum number of partitions in a variable
         */
        for (int outer_loop = 0; outer_loop<maximum_length; outer_loop++) {
            /**
             * iterating the inner_loop till the number of variables
             */
            for(int inner_loop = 0; inner_loop < n; inner_loop++) {
                /**
                 * checking if the inner loop is equal to corresponding_id,
                 * because the value of corresponding id starts from 2, since in the input the first two lines contain
                 * test case selection and number of the variables
                 */
                if(inner_loop!= corresponding_id) {
                    /**
                     * if it is not equal to corresponding_id, I am printing a value from the partition corresponding to that variable
                     */
                    Random rand = new Random();
                    ArrayList<Integer> temp_array = finalized_values.get(inner_loop);
                    System.out.print((temp_array.get(rand.nextInt(temp_array.size()))));
                    System.out.print("\t");
                }
                /**
                 * if the value of inner_loop is equal to corresponding_id, then I am iterating through the Nom values of the variable which
                 * has maximum partitions and printing them in order
                 */
                else {
                    ArrayList<Integer> temp_array = finalized_values.get(inner_loop);
                    System.out.print(temp_array.get(outer_loop));
                    System.out.print("\t");
                }
            }
            /**
             * Prints a new line, after each row
             */
            System.out.println("\n");
        }
    }
}