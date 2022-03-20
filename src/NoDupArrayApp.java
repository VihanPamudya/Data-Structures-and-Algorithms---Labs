class NoDupArray {
    private long[] a;
    private int nEliments;

    public NoDupArray(int max) {
        this.a = new long[max];
        this.nEliments = 0;
    }

    public boolean find(long SearchKey) {
        boolean status = false;
        for (int i = 0; i < this.nEliments; i++) {
            if (a[i] == SearchKey) {
                status = true;
                break;
            }
        }
        return status;
    }

    public void insert(long value) {
        if (this.nEliments != a.length) {
            if (find(value) == false) {
                this.a[this.nEliments] = value;
                nEliments++;
                System.out.println("Value inserted");
            } else {
                System.out.println("This can't inserted. Duplicate value");
            }
        } else {
            System.out.println("Array is full");
        }
    }

    public boolean delete(long value) {
        for (int i=0;i<nEliments;i++){
            if(a[i]==value){
                for (int j=i+1;j<nEliments;j++){
                    a[j-1]=a[j];
                }
                nEliments--;
                System.out.println("Value deleted");
                return true;
            }
        }
        System.out.println("Value not found");
        return false;
    }

    public void display() {
        for (int i = 0; i < nEliments; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

class NoDupArrayApp {
    public static void main(String[] args) {
        NoDupArray n = new NoDupArray(8);
        n.insert(7);
        n.insert(6);
        n.insert(5);
        n.insert(4);
        n.insert(3);
        n.insert(2);
        n.insert(23);
        n.insert(25);
        n.insert(30);
        n.display();
        n.delete(4);
        n.display();
    }
}