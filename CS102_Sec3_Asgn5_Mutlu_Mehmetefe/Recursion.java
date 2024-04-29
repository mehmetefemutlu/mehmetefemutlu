/**
 * Recursion
 */
public class Recursion {
    
    //Instance variables
    private char [][] arr;
    private char ch1 = '#';
    private char ch2 = '*';

    //Trackers for rows and columns
    int i=0;
    int j=0;

    //Constructor
    public Recursion(){
        createArray(10, 10);
    }

    //Creates empty char array
    public void createArray(int rows, int columns){
        arr = new char [rows][columns];
    }

    //Filles the array from specified start index(inclusive) to specified end index(exclusive)
    public void fillChar(char c, int rowStart, int rowEnd, int columnStart, int columnEnd){
        //Base case
        if(rowStart+1>rowEnd){
            return;
        }
        //Calls helper fillRows(...) method 
        fillRows(c, rowStart, columnStart, columnEnd);
        //Recursive call
        fillChar(c, rowStart+1, rowEnd, columnStart, columnEnd);  
    }

    //Creates char array using # and *, with the rectangular boundry patterns
    public void pattern1(){
        //Tracking the indices using i
        int rowStart = i;
        int columnStart = i;
        int rowEnd = arr.length-i;
        int columnEnd = arr[0].length-i;

        //Base case
        if(rowStart>=rowEnd || columnStart>=columnEnd){
            return;
        }
        //Fills the array with first *s and diminish the rectangular size then fills with #s
        fillChar(ch2, rowStart, rowEnd, columnStart, columnEnd);
        fillChar(ch1, rowStart+1, rowEnd-1, columnStart+1, columnEnd-1);

        i=i+2;
        //Recursive call
        pattern1();
    }

    //Creates char array with certain width and shift. Width represents the number of *s in each row and shift represents the shift amount of the * block in each row+1
    //Rows are assumed to be circular
    public void pattern2(int fillWidth, int shiftAmount){
        //Fills the array with #s
       fillChar(ch1, 0, arr.length, 0, arr[0].length);
       int rowS = 0;
       int colS = 0;
       //Fills the first row
       fillRows(ch2, rowS, colS, fillWidth);
       //Calls helper fillPattern2(...) method
       fillPattern2(colS, rowS+1, fillWidth, shiftAmount);
    }
   
    //Creates char array and fills it with numbers. Rule for the array is explicitly explained in the helper method
    public void pattern3(){
        //Starting indices
        int rowS = 0;
        int colS = 0;

        //Calls helper fillPattern3(...) method
        fillPattern3(rowS, colS);
    }
    //Finds the row with the max sum of the pattern3(...)
    public int findMaxRowSum(){
        //Calls the helper maxOfSums(...) method
        return maxOfSums(0, 0);
    }

    //Prints the array recursively
    public void print(){
        //Tracking the row index using j
        int rows = j;
        //Base case
        if(rows+1>arr.length){
            return;
        }
        j++;
        //Calls helper printRows(...) method
        printRows(rows, 0);
        System.out.println();
        //Recursive call
        print();
    }

    //Helper methods

    //Fills a row between specific column indexes with specified char=c
    private void fillRows(char c, int rowStart, int columnStart, int columnEnd){
        //Base case
        if(columnStart+1>columnEnd){
            return;
        }
        //Fills it
        arr[rowStart][columnStart]=c;
        //Recursive call
        fillRows(c, rowStart, columnStart+1, columnEnd);
    }

    //Prints a row
    private void printRows(int row, int column){
        //Base case
        if(column+1>arr[0].length){
            return;
        }
        //Prints it
        System.out.print(arr[row][column] + " ");
        //Recursive call
        printRows(row, column+1);
    }

    //Helper method for pattern2(...)
    private void fillPattern2(int colS, int rowS, int colE, int shift){
        //Base case
        if(rowS+1>arr.length){
            return;
        }
        //If end column+shifting amount is less than length of the columns it directly fills it using fillRows(...) method
        //Second check case in the if statement is for the fractional filling of *s
        if(colE+shift<arr[0].length && (colE+shift)%arr[0].length>(colS+shift)%arr[0].length){
            fillRows(ch2, rowS, (colS+shift)%arr[0].length, colE+shift);           
        }
        //Fills *s fractionally
        else{
            //Fills last part of the row which is less than width
            fillRows(ch2, rowS, colS+shift, arr[0].length);
            fillRows(ch2, rowS, 0, (colE+shift)%arr[0].length);
        }
        //Recursive call
        fillPattern2((colS+shift)%arr[0].length, rowS+1, (colE+shift)%arr[0].length, shift);    
    }

    //Helper method for pattern3(...)
    //Algorithm for the method is arr[x][y]= (arr[x-1][y]+ arr[x][y-1])%10 if x,y!=0. In the case x or y is equal to 0, the index is assigned to 1
    private void fillPattern3(int rowS, int colS){
        //Base case
        if(rowS>=arr.length && colS>=arr[0].length){
           return;
        }

        //Putting 1's to correct indices
        if(rowS==0 || colS==0){
            arr[rowS][colS]='1';
        }
        else{
            //Algorithm call with casting int to char
            int temp = ((arr[rowS-1][colS]-'0') + (arr[rowS][colS-1]-'0'))%10; 
            arr[rowS][colS] = (char)(temp+'0');
        }

        //First fills the rows in one column then moves to the other column with rowS=0
        //Recursive call
        if(rowS+1>=arr.length){
            if(colS+1<arr[0].length)
            fillPattern3(0, colS+1);
        }
        else{
            fillPattern3(rowS+1, colS);
        }
    }

    //Calculates the sum of one row from the starting column index 
    private int sumOfRow(int rowS, int colS, int sum){
        //Base case
        if(colS>=arr[0].length){
            return sum;
        }
        //Typecasts it to integer and assigns it to a value
        int value = Integer.parseInt(String.valueOf(arr[rowS][colS]));
        //Recursive call
        return sumOfRow(rowS, colS+1, sum+value);
    }

    //Uses sumOfRow(...) method to find the biggest sum
    private int maxOfSums(int rowS, int maxSum){
        //Base case
        if(rowS>=arr.length){
            return maxSum;
        }
        //Gets the first sum, rowS=0
        int sum = sumOfRow(rowS, 0, 0);
        //Changes maxSum, which is initially 0, if sum is greater than itself
        if(sum>maxSum){
            maxSum = sum;
        }
        //Recursive call
        return maxOfSums(rowS+1, maxSum);
    }

}