import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the amount of numbers:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the numbers");
        for(int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(array));
        ArrayDeque<Integer>Numbers = new ArrayDeque<>(n);
        for(int i = 0; i<n; i++){
            if(array[i] >= 0){
                Numbers.addFirst(array[i]);
            } else if (array[i] < 0) {
                Numbers.addLast(array[i]);
            }
        }
        System.out.println(Numbers);
    }
}
