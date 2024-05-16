import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//All details of the algorithms are explained in "Algortihms.txt"
public class Algorithms {
    
    public static void main(String[] args) {

        
        Scanner in = new Scanner(System.in);

        int [] arr = {2,7,1,11,23,46,79,45,92,4,65};
        System.out.println(Arrays.toString(arr));

        System.out.print("Enter number to be searched, -1 to quit: ");
        int n = in.nextInt();

        if(n==-1){
            System.exit(0);
        }
        else{
            System.out.println("Result for binary search is: " + Algorithms.linearSearch(n, arr));
            System.out.println("Average case complexity is: O(n) \n");

            //Binary search needs the array to be sorted
            Arrays.sort(arr);
            System.out.println("Result for recursive binary search is: " + Algorithms.binarySearch(arr, 0, arr.length, n));
            System.out.println("Result for iterative binary search is: " + Algorithms.binarySearch2(arr, 0, arr.length, n));
            System.out.println("Average case complexity: O(log(n)) \n");

        }

        //Inefficient sorting algorithms
        System.out.println("Which inefficient sorting algorithm do you want to use: ");
        System.out.print("Enter S, I or B: ");
        String s = in.next();

        if(s.equals("S") || s.equals("s")){
            System.out.print("After using Selection Sort: ");
            System.out.println(Arrays.toString(Algorithms.selectionSort(arr)) + "\n");
        }
        else if(s.equals("I") || s.equals("i")){
            System.out.print("After using Insertion Sort: ");
            System.out.println(Arrays.toString(Algorithms.insertionSort(arr)) + "\n");
        }
        else if(s.equals("B") || s.equals("b")){
            System.out.print("After using Bubble Sort: ");
            System.out.println(Arrays.toString(Algorithms.bubbleSort(arr)) + "\n");
        }
        else{
            in.close();
            throw new IllegalArgumentException("Invalid input");
        }

        //Efficient sorting algorithms
        System.out.println("Which efficient sorting algorithm do you want to use: ");
        System.out.print("Enter M or Q: ");
        s = in.next();

        if(s.equals("M") || s.equals("m")){
            mergeSort(arr);
            System.out.print("After using Merge Sort: ");
            System.out.println(Arrays.toString(arr));
        }
        else if(s.equals("Q") || s.equals("q")){
            quickSort2(arr, 0, arr.length-1);
            System.out.print("After using Quick Sort: ");
            System.out.println(Arrays.toString(arr));
        }
        else{
            in.close();
            throw new IllegalArgumentException("Invalid input");
        }
        in.close();
    }

    /**
     * Linear search
     * Average complexity: O(n)
     * @param num wanted element
     * @param arr array to be searched
     * @return position of the wanted element
     */
    public static int linearSearch(int num, int [] arr){
        //Traverses through array and checks if the ith element is equal to num
        //If so, returns i (the position of the num)
        for(int i=0; i<arr.length; i++){
            if(arr[i]==num){return i;}
        }
        //If not, returns -1 (means num is not found)
        return -1;
    }

    /**
     * Binary Search with recursion
     * Average complexity: O(log(n))
     * @param arr array to be searched
     * @param low first index of array (0)
     * @param high length of array (arr.length)
     * @param num wanted element
     * @return position of the wanted element
     */
    public static int binarySearch(int [] arr, int low, int high, int num){
        //Since it is a recursive method, base case is required
        //Base case is when num is not found and low and high indices cross
        //In this case, returns the place where num needs to be inserted (low==place to be inserted)
        if(low>high){
            return -low-1;
        }
        //If it is not reached the base case
        else{
            //Finds mid index 
            int mid = (low+high)/2;
            //Compares the element of mid index with num

            //If it is less than num, halves the array
            //Searches the one half of the array, which element lies, by calling itself and changing low index to mid+1
            if(arr[mid]<num){
                return binarySearch(arr, mid+1, high, num);
            }
            //If element in the mid index is equal to num, returns mid index
            else if(arr[mid]==num){
                return mid;
            }
            //If otherwise, performs the inverse by calling itself and changing high index to mid-1
            else{
                return binarySearch(arr, low, mid-1, num);
            }
        }
        //Binary search needs the array to be sorted first
        //After that, with recursive calls, it eventually either reaches the num or base case
    }

    /**
     * Binary Search with iteration
     * Average complexity: O(log(n))
     * @param arr array to be seached
     * @param low first index of array (0)
     * @param high length of array (arr.length)
     * @param num wanted element
     * @return position of the wanted element
     */
    public static int binarySearch2(int [] arr, int low, int high, int num){
        //Similar to first one, this approach is iterative
        //Keeps iterating until low and high indices cross
        while(low<=high){

            //Only difference here is instead of calling itself, it changes low and high indices according to the conditions
            int mid = (low+high)/2;
            if(arr[mid]==num){
                return mid;
            }
            else if(arr[mid]<num){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        //If num is not found, again returns where num should be inserted
        return -low-1;
    }   

    //Inefficient Sorting Algorithms

    /**
     * Selection Sort with helper methods
     * Average complexity: O(n^2)
     * @param arr array to be sorted
     * @return sorted version of array
     */
    public static int [] selectionSort(int [] arr){
        //Traverses through array
        for(int i=0; i<arr.length-1; i++){
            //Finds minimum element starting from i
            int minPos = findMinPos(arr, i); 
            //Swaps it with i 
            swap(arr, i, minPos);
        }
        //This algorithm finds the min element and puts it to the first place
        //Then finds the second min element and puts it to the second place and so on
        //Does this by incrementing i value in every iteration
        return arr;
    }

    /**
     * Finds the position of the minimum element in the array
     * @param arr array to be sorted
     * @param from starting index to be searched from 
     * @return position of the minumum element from starting index
     */
    private static int findMinPos(int [] arr, int from){
        //Defines min as the starting index
        int min = from;

        //Traverses through array
        for(int i=from+1; i<arr.length; i++){
            //If a lesser element is found, changes min with that element's position
            if(arr[i]<arr[min])
            min = i;
        }
        return min;
    }

    /**
     * Swaps the two given elements in the array
     * @param arr array to be sorted
     * @param a1 one of the elements to be swapped
     * @param a2 other element to be swapped
     */
    private static void swap(int [] arr, int a1, int a2){
        //Swapping algorithm
        int temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }

    /**
     * Insertion Sort
     * Average complexity: O(n^2)
     * @param arr array to be sorted
     * @return sorted version of array
     */ 
    public static int [] insertionSort(int [] arr){
        //Assumes first element is already sorted so i starts from 1
        for(int i=1; i<arr.length; i++){
            //Defines a current which holds the ith element
            int cur = arr[i];
            //Defines a pointer j wihich is 0 initially
            int j=i-1;

            //Basics of insertion sort is here
            //At this point shifts the jth element until either j is 0 or jth element is greater than current
            while(j>=0 && arr[j]>cur){
                //Shifts it here
                arr[j+1] = arr[j];
                //Decrements j (so the loop ends at some point)
                j--;
            }
            //After all elements that is bigger than current is shifted one to the right, place where current should be inserted is j+1
            //Inserts currrent to j+1
            arr[j+1] = cur;
        }
        //Idea of this algorithm is to take an element to a temp position(cur) and compare it with all values before that
        //If a value is greater than cur, just shifts it to the right
        //When the place where element should be inserted is reached, inserts the element to its right place
        return arr;
    }

    /**
     * Bubble sort with helper methods
     * @param arr array to be sorted
     * @return sorted version of array
     */
    public static int [] bubbleSort(int [] arr){
        //Defines a flag that checkes if any swapping has done
        boolean swapped;
        do{
            //Initially no swapping is done
            swapped = false;
            //Traverses through array
            for(int i=0; i<arr.length-1; i++){
                //Compares only two elements in each iteration
                //If their order are wrong, swaps them
                if(arr[i]>arr[i+1]){
                    //Swaps it here
                    swap(arr, i, i+1);
                    //Alerts flag that a swapping has happened
                    swapped = true;
                }
            }
        }
        //Continue to do this process until no swapping is done (means that array is sorted eventually)
        while(swapped);
        //This algorithm patiently compares two subsequent elements in array in each step and swaps if necessary
        //Keep doing this until it reaches the end of array
        //Then starts from the beginning until array is sorted eventually
        return arr;
    }

    //Efficient Sorting Algorithms

    /**
     * Merge sort with helper methods
     * Average complexity: O(nlog(n))
     * @param arr array to be sorted
     */
    public static void mergeSort(int [] arr){
        //Since it is a recursive call, it needs a base case
        //Base case is when length of the array is 0 or 1 (array of length 0 or 1 is already sorted)
        //Thus performs nothing
        if(arr.length<=1){
            return;
        }
        //Halves the original array and assigns it to two different subarrays
        int [] first = new int[arr.length/2];
        int [] second = new int[arr.length-first.length];

        //These two for loops fills subarrays accordingly
        for(int i=0; i<first.length; i++){
            first[i] = arr[i];
        }
        for(int i=0; i<second.length; i++){
            second[i] = arr[first.length + i];
        }

        //Then calls itself for these two subarrays
        mergeSort(first);
        mergeSort(second);
        //After halving original array, merges them (step that sorting happens)
        merge(arr, first, second);
        //This algorithm simply creates a recursive tree call until all elements are separated into a subarray of length 1
        //Then traverse back and merges them by comparing them
    }

    /**
     * Merges the two subarray by comparing their values
     * @param inArr original array
     * @param first first half of original array
     * @param second second half of original array
     */
    private static void merge(int [] inArr, int [] first, int [] second){
        //Defines trackers for these three arrays
        int firstTr = 0;
        int secondTr = 0;
        int avPos = 0;

        //Makes sure that trackers do not exceed the lengths of arrays
        while(firstTr<first.length && secondTr<second.length){
            //Compares the element which firstTr points in first array to the element which secondTr points in second array
            //According to the result, places the lower one to the original array
            //Then increments the pointer of subarray whose element is placed into original array
            if(first[firstTr]<second[secondTr]){
                inArr[avPos] = first[firstTr];
                firstTr++;
            }
            else{
                inArr[avPos] = second[secondTr];
                secondTr++;
            }
            //Then increments the pointer of original array
            avPos++;
        }

        //If one of the subarrays is consumed, that means all left elements in other array should be placed to original array, one by one
        //These two while loops does this
        while(firstTr<first.length){
            inArr[avPos] = first[firstTr];
            firstTr++;
            avPos++;
        }
        while(secondTr<second.length){
            inArr[avPos] = second[secondTr];
            secondTr++;
            avPos++;
        }
    }

    /**
     * Quick sort with helper methods
     * Average complexity: O(nlog(n))
     * @param arr array to be sorted
     * @param low first index of array (0)
     * @param high last index of array (arr.length-1)
     */
    public static void quickSort(int [] arr, int low, int high){
        //Since it is a recursive call, there is a base case
        //Base case is when low and high indices cross
        //If it happens, does nothing
        if(low<high){
            //Defines the index where array is divided by
            //Partitioning is the most important step of this algorithm
            int pi = partition(arr, low, high);

            //Divides the array into two (different to merge sort, not halves it)
            //Then calls itself recursively
            quickSort(arr, pi+1, high);
            quickSort(arr, low, pi-1);
        }
        //This algorithm has different approaches and this approach is not recommended for CS102
    } 

    /**
     * Finds the position of the pivot (arbitrarily chosen element)
     * @param arr array to be sorted
     * @param low start index of array (0)
     * @param high end index of array (arr.length-1)
     * @return correct position
     */
    private static int partition(int [] arr, int low, int high){
        //Defines pivot element 
        //Usually and most effectively it is last element in array (but it is arbitary)
        int pivot = arr[high];

        //Defines a tracker i which is initially -1
        int i = low-1;

        //Traverses through array until it reaches the high-1 (element that is one less than pivot) position
        for(int j=low; j<high; j++){
            //If an element before pivot is less than pivot, increments i pointer and swaps ith and jth pointers
            if(arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        //When all necessary swappings are done, then i+1th place is the place where pivot should be in
        //Thus swaps them two and returns the position of pivot
        swap(arr, high, i+1);
        return i+1;
    }

    /**
     * Quick sort with helper methods (Preferred in CS102)
     * @param arr array to be sorted
     * @param low start index of array (0)
     * @param high end index of array (arr.length-1)
     */
    public static void quickSort2(int [] arr, int low, int high){
        //This part is identical to the first one 
        //Nothing is different, only difference is the nature of partition methods
        if(low<high){
            int leftPointer = partition2(arr, low, high);

            quickSort2(arr, leftPointer+1, high);
            quickSort2(arr, low, leftPointer-1);
        }
        //partition2() approach is recommended in CS102
        //At partition step, this algorithm finds the correct place for the pivot and places it in there
        //Then does this for every subarrays until array is sorted
    }

    /**
     * Finds the position of the pivot (arbitrarily chosen element)
     * @param arr array to be sorted
     * @param low start index of array (0)
     * @param high end index of array (arr.length-1)
     * @return correct position
     */
    private static int partition2(int [] arr, int low, int high){
        //Defines the pivot as the same in partition();
        int pivot = arr[high];
        
        //Here, defines two pointers
        //One of them points the beginning of array, other one points the ending of array
        int left = low;
        int right = high;

        //Makes sure that they do not cross
        while(left<high){
            //Keeps incrementing leftPointer until it reaches an element that is greater than pivot
            while(arr[left]<pivot && left<right){
                left++;
            }
            //Keeps decrementing rightPointer until it reaches an element that is lesser than pivot
            while(arr[right]>pivot && left<right){
                right--;
            }
            //After these two pointers stop, swaps these elements (where pointers stopped)
            swap(arr, left, right);
        }
        //When these two pointers crossed, position of the leftPointer implies that pivot should be in there
        //Thus swaps them two and returns the position of pivot
        swap(arr, left, high);
        return left;

    }
}
