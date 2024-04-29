import java.util.Arrays;
import java.util.Scanner;

public class Searching {
    
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
            System.out.println("Result for binary search is: " + Searching.linearSearch(n, arr));
            System.out.println("Average case complexity is: O(n) \n");

            //Binary search needs the array to be sorted
            Arrays.sort(arr);
            System.out.println("Result for recursive binary search is: " + Searching.binarySearch(arr, 0, arr.length, n));
            System.out.println("Result for iterative binary search is: " + Searching.binarySearch2(arr, 0, arr.length, n));
            System.out.println("Average case complexity: O(log(n)) \n");

            in.close();
        }
    }

    /**
     * Linear search
     * Average complexity: O(n)
     * @param num
     * @param arr
     * @return
     */
    public static int linearSearch(int num, int [] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==num){return i;}
        }
        return -1;
    }

    /**
     * Binary Search with recursion
     * Average complexity: O(log(n))
     * @param arr
     * @param low
     * @param high
     * @param num
     * @return
     */
    public static int binarySearch(int [] arr, int low, int high, int num){
        if(low>high){
            return -1;
        }
        else{
            int mid = (low+high)/2;

            if(arr[mid]<num){
                return binarySearch(arr, mid+1, high, num);
            }
            else if(arr[mid]==num){
                return mid;
            }
            else{
                return binarySearch(arr, low, mid-1, num);
            }
        }
    }

    /**
     * Binary Search with iteration
     * Average complexity: O(log(n))
     * @param arr
     * @param low
     * @param high
     * @param num
     * @return
     */
    public static int binarySearch2(int [] arr, int low, int high, int num){
        while(low<=high){

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
        return -1;
    }   
}
