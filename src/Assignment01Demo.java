import java.util.Scanner;
public class Assignment01Demo {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter memory size: ");
        int mSize = sn.nextInt();
        DataOccurrence d = new DataOccurrence(mSize);
        String data;
        while (true){
            System.out.print("Enter data (type 'e' for end):");
            data=sn.next();
            if(data.toUpperCase().equals("E")){
                break;
            }
            d.add(data.toUpperCase());
        }
        System.out.println("Good bye");
    }
}

class DataOccurrence {
    private String[] arr;// an array for store user data
    private int max; // maximum size of the array 'arr'
    private int nElements; // number of elements in the array 'arr'
    private StoreData[] sd; // an array for save user data with their occurrence
    public DataOccurrence(int size) {// default constructor for initialize instance variables
        this.arr=new String[size];
        this.nElements=0;
        this.max=size-1;
    }
    private boolean isFull() { // check the array 'arr' is full or not
        if(this.nElements== this.max){
            return true;
        }
        return false;
    }
    private void shiftAll() { //shift each element in the 'arr' one location to left
        for (int i = 0; i < this.nElements; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.nElements--;
    }
    public void add(String element) { // add an element to the array 'arr'
        if(isFull()==true){
//            shiftAll();
//            this.arr[this.max - 1] = element;
           displayResults();
        }
        else{
            this.arr[nElements] = element;
        }
        this.nElements++;
        // call the isFull(), shiftAll(), saveResults() and displayResults() in appropriate places.
    }
    private void saveResults() {// store each element in the 'arr' with their occurrence to 'sd'

    }
    private void displayResults() {
        // display all the data in 'sd' in the format of 'element->occurrence' (eg: A->3)
        int [] arr = new int [this.arr.length];
        int y = -1;
        for(int i = 0; i < this.arr.length; i++){
            int count = 1;
            for(int j = i+1; j < this.arr.length; j++){
                if(this.arr[i] == this.arr[j]){
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
                System.out.print(this.arr[i] + "->" + arr[i] +" ");
        }
        System.out.println();
    }
}
class StoreData {// this class is used to save the element with their occurrence
    String name; // name of the element
    int count; // occurrence of the element
    StoreData(String name) { // default constructor
        this.name = name;
        this.count = 0;
    }
}