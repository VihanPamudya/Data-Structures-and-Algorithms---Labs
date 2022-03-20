public class OrdArrayDemo {
    public static void main(String[] args) {
        OrdArray oa=new OrdArray(8);
        oa.insert(5);
        oa.insert(9);
        oa.insert(1);
        oa.insert(3);
        oa.insert(87);
        oa.insert(6);
        oa.display();
        oa.delete(3);
        oa.display();
    }
}

class OrdArray {
    private long[] a;
    private int nElements;

    public OrdArray(int max) {
        this.a = new long[max];
        this.nElements = 0;
    }

    public int size() {
        return a.length;
    }

    public int find(long searchKey) {
        for (int i = 0; i < this.nElements; i++) {
            if (a[i] == searchKey) {
                return i;
            }
        }
        return -1;
    }

    public void insert(long value) {
        if (nElements == size()) {
            System.out.println("Array is full");
            return;
        }
        for (int i = 0; i < nElements; i++) {
            if (a[i] > value) {
                for (int j = nElements - 1; j >= i; j--) {
                    a[j + 1] = a[j];
                }
                a[i] = value;
                nElements++;
                return;
            }
        }
        a[nElements] = value;
        nElements++;
    }

    public boolean delete(long value) {
        int index = find(value);
        if (index == -1) {
            System.out.println("Value not found.");
            return false;
        }
        for (int i = index; i < nElements-1; i++) {
            this.a[i] = this.a[i + 1];
        }
        nElements--;
        return true;
    }

    void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
