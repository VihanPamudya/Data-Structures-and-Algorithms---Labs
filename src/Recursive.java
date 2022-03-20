public class Recursive {
    public static void main(String[] args) {
//        Recursive1 r=new Recursive1();
//        System.out.println(r.sum(6));

//        Recursive2 r = new Recursive2();
//        System.out.println(r.multi(5));

//        Recursive3 r = new Recursive3();
//        System.out.println(r.multiply(5, 4));

//        Recursive4 r = new Recursive4();
//        System.out.println(r.fibo(6));

        Recursive5 r = new Recursive5();
        r.SolveHanoi(3,'a','b','c');
    }
}

class Recursive1 {
    public int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }
}

class Recursive2 {
    public int multi(int num) {
        if (num == 1) {
            return 1;
        }
        return num * multi(num - 1);
    }
}

class Recursive3 {
    public int multiply(int num1, int num2) {
        if (num2 == 1) {
            return num1;
        }
        return num1 + multiply(num1, num2 - 1);
    }
}

class Recursive4 {
    public int fibo(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibo(num - 1) + fibo(num - 2);
    }
}

class Recursive5 {
    public void SolveHanoi(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
        SolveHanoi(n - 1, a, c, b);
        System.out.println("Move plate " + n + " from " + a + " to " + c);
        SolveHanoi(n - 1, b, a, c);
    }

}
