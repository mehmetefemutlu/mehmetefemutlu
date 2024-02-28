import java.util.Arrays;
import java.util.Scanner;

public class ArrayTrials {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int [] trial = new int[10];
        System.out.println("Enter numbers: ");

        String inter = in.nextLine();
        String [] splitted = inter.split(",");
        for(int i=0; i<trial.length; i++){
            trial[i] = Integer.parseInt(splitted[i]);
        }
        sort(trial);
        insert(trial, 3);
        delete(trial, 3);
        System.out.println(search(trial, 1));


        in.close();
    }

    public static void sort(int [] array){
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp; 
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void insert(int [] array, int num){
        boolean done = false;
        for(int i:array){
            if(array[i]>num && !done){
                int temp = array[i];
                array[i] = num;
                for(int j=i; j<array.length-1; j++){
                    int temp2 = array[j+1];
                    array[j+1] = temp;
                    temp = temp2;
                }
                done = true;
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void delete(int [] array, int num){
        boolean done = false;
        for(int i:array){
            if(array[i]==num && !done){
                for(int j=i; j<array.length-1; j++){
                   array[j]= array[j+1];
                   if(j+1==array.length-1){
                    array[j+1]=0;
                   }
                }
                done = true;
            }
        }
        System.out.println(Arrays.toString(array));
    }
   public static int search(int [] array, int num){
        for(int i:array){
            if(array[i]==num){
                return i;
            }
        }
        return -1;
   }    
}
