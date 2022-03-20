import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter memory size:");
        num = sc.nextInt();
        char[] arr = new char[num];
        Demo demo = new Demo();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter data (type 'e' for end):");
            arr[i] = sc.next().charAt(0);
            if (arr[i] == 'e') {
                System.out.println("Good bye");
                break;
            }
            if (i == (num - 1)) {
                demo.displayArray(arr);
                while (true) {
                    System.out.print("Enter data (type 'e' for end):");
                    char x = sc.next().charAt(0);
                    if (x == 'e') {
                        System.out.println("Good bye");
                        break;
                    } else {
                        demo.updateArray(arr, x);
                        demo.displayArray(arr);
                    }
                }
            }
        }
    }

    void displayArray(char[] array) {
        int [] arr = new int [array.length];
        int y = -1;
        for(int i = 0; i < array.length; i++){
            int count = 1;
            for(int j = i+1; j < array.length; j++){
                if(array[i] == array[j]){
                    count++;
                    arr[j] = y;
                }
            }
            if(arr[i] != y) {
                arr[i] = count;
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != y)
                System.out.print(array[i] + "->" + arr[i] +" ");
        }
        System.out.println();
    }

    void updateArray(char[] array, char input) {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = input;
    }

}