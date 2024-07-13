import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of elements for the array: ");
            int n = scanner.nextInt();
            
            int[] arr = new int[n];
            System.out.println("Enter the elements: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println("The original array is: " + Arrays.toString(arr));

            int [] ngeArr = nextGreaterElement(arr);
            System.out.println("The next greater element for original array is: " + Arrays.toString(ngeArr));
        }
    }

    public static int[] nextGreaterElement (int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        
        for (int i = 0; i < arr.length ; i++) {
            nge[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                nge[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return nge;
    }
}
