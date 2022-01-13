public class MyMain {
    // Returns the String that shows up latest alphabetically
    // in a normal 1D String array
    // You can assume that the array will not be empty
    // and that all Strings are lowercase
    // Hint: recall how the compareTo() method works:
    //      int x = "apple".compareTo("banana"); // x is negative
    //      int y = "banana".compareTo("apple"); // y is positive
    public static String findLastWord(String[] arr) {
        String last = arr[0];
        for (int i = 0; i<arr.length-1; i++){
            if (last.compareTo(arr[i+1])<0){
                last = arr[i+1];
            }
        }
        return last;
    }

    // Given a 2D array, return an 1D array of the last word
    // in each row in the array
    // You can assume that the matrix will not be empty
    // Hint: use the previous method to help yourself!
    public static String[] findLastWord2D(String[][] mat) {
        String[] arr = new String[mat.length];
        for(int row=0; row<mat.length; row++) {
            String[] arr2 = mat[row];
            arr[row] = findLastWord(arr2);
        }
        return arr;
    }

    // Given a 2D array and some column index col
    // finds the number of Strings in the specified column
    // of the 2D array that contain the word "apple"
    // For example, if col = 0, you should only look through
    // the values in column 0 of the array; likewise, if
    // col = 2, you should only look through the values in column 2

    // Hint: remember how the indexOf() method works?
    // alternatively, consider the contains() method
    public static int appleCounter(String[][] mat, int col) {
        int count = 0;
        for (int row = 0; row<mat.length; row++){
            if (mat[row][col].contains("apple") == true) {
                count++;
            }
        }
        return count;
    }

    // Given a 2D array, return the column number corresponding
    // to the column that contains the most Strings containing
    // the word "apple"

    // Hint: use your previous method!
    // Hint 2: you might need to loop through the columns!
    public static int findMostAppleColumn(String[][] mat) {
        int most = 0;
        int count = 0;
        for (int col = 0; col<mat[0].length; col++){
            int num = appleCounter(mat,col);
            if (num > most){
                most = num;
                count = col;
            }
        }
        return count;
    }


    // Creates Pascal's Triangle, with a height of n
    // The first row of numbers has a single number, 1
    // Each subsequent row has one more number than the previous row
    // The first and last numbers of every row are 1
    // All other numbers values are calculated by adding together the two numbers above that number

    // Here are some examples:
    // pascalTriangle(2) =>
    // 1  0
    // 1  1

    // pascalTriangle(6) =>
    // 1  0  0  0  0  0
    // 1  1  0  0  0  0
    // 1  2  1  0  0  0
    // 1  3  3  1  0  0
    // 1  4  6  4  1  0
    // 1  5  10 10 5  1

    // Hint: fill in the first column and first diagonal with 1's
    //       and then go through and calculate the rest of the values
    //       from top to bottom

    public static int[][] pascal(int height) {
        int col = 0;
        int [][]arr = new int [height][height];
        for (int row = 0; row<arr.length; row++){
            arr[row][col] = 1;
        }
        for (int i = 0; i<arr.length; i++ ){ // all the 1 diagonally
            arr[i][i] = 1;
        }
        //go through each row and column
        for (int row1 = 2; row1<arr.length; row1++){
            for (int col2 = 1; col2<arr[0].length; col2++){
                arr[row1][col2] = arr[row1-1][col2]+ arr[row1-1][col2-1];
            }
        }
        return arr;
    }










    // Methods for the homework:

    // Checks if a 2D array is a magic square or not
    // You can assume that the 2D array mat will be square
    // A 2D array is a magic square if:
    // There is some set value x such that:
    // * all rows sum to x
    // * all columns sum to x
    // * both diagonals sum to x

    // Hint 1: you might first want to add up the values in the
    // first row/col and save that value to compare with later.
    // Then, you should check each rows, check each column, and
    // check each diagonal

    // Hint 2: you problably want to break this down into many parts.
    // You should have two loops to check the row sums. Then two more
    // loops to chekc the column sums. Finally, it might help to have
    // one for loop for each diagonal

    // Hint 3: when thinking the diagonals, consider the following
    // * do you see any pattern for the row and col indexes for a diagonal?
    // * can you use a for loop that goes through that pattern?
    public static boolean isMagic(int[][] mat) {
        int value = 0;
        int row = 0;
        for (int col2 = 0; col2<mat[0].length; col2++){
            value+=mat[row][col2];
        }
        //add up all value of row
        int temp1 = 0;
        for (int i = 0; i<mat.length; i++){
            for (int col3 = 0; col3<mat[0].length; col3++){
                temp1+=mat[i][col3];
            }
            if (temp1!=value){
                return false;
            }
            temp1 = 0;
        }
        //add up all of col
        int temp2 = 0;
        for (int j = 0; j<mat.length; j++){
            for (int row1 = 0; row1<mat[0].length; row1++){
                temp2+=mat[row1][j];
            }
            if (temp2!=value){
                return false;
            }
            temp2 = 0;
        }
        //diagonal from left

        int temp3 = 0;
        for (int i = 0; i<mat.length; i++ ){ //  diagonally
            temp3+=mat[i][i];
        }
        if (temp3!=value){
            return false;
        }

        //have 2 for loop check and see if all other rows add up to value
        //if any of those dont equal value = not magic
        //check to see if col add up to value another 2 for loop
        //each diagonal = take one for loop
        int row3=0;
        int temp = 0;
        for (int i = mat.length-1; i>=0; i-- ){ //  diagonally
            temp+=mat[row3][i];
            row3++;
        }
        if (temp!=value){
            return false;
        }


        return true;
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
