public class FractionDemo {
    public static void main(String[] args) {
        ADTFraction a = new ADTFraction();
        a.display();
        a.set(12, 30);
        a.display();

        ADTFraction b = new ADTFraction(3, 7);
        b.display();
        ADTFraction c = a.plus(b);
        c.display();
        c.refine();
        c.display();
        ADTFraction d = a.times(3);
        d.display();
        ADTFraction e = a.times(b);
        e.display();
        e.refine();
        e.display();
        ADTFraction f = a.reciprocal();
        f.display();
        float v=a.value();
        System.out.println(v);
    }
}

class ADTFraction {
    private int n; //numerator
    private int d; //denomenator


    public ADTFraction() {
        this.n = 0;
        this.d = 1;
    }


    public ADTFraction(int a, int b) {
        if (b != 0) {
            this.n = a;
            this.d = b;
        } else {
            this.n = 0;
            this.d = 1;
            System.out.println("Denominator can't be zero");
        }
    }

    public void set(int a, int b) {
        if (b != 0) {
            this.n = a;
            this.d = b;
        } else {
            this.n = 0;
            this.d = 1;
            System.out.println("Denominator can't be zero");
        }
    }


    public ADTFraction plus(ADTFraction x) {
        int num, max;
        if (this.d > x.d) {
            max = this.d;
        } else {
            max = x.d;
        }
        int comDen = max;
        while (true) {
            if (comDen % this.d == 0 && comDen % x.d == 0) {
                break;
            } else {
                comDen += max;
            }
        }
        num = comDen / this.d * this.n + comDen / x.d * x.n;
        ADTFraction ans = new ADTFraction(num, comDen);
        return ans;
    }


    public ADTFraction times(int a) {
        int num, den;
        num = this.n * a;
        den = this.d;
        ADTFraction ans = new ADTFraction(num, den);
        return ans;
    }


    public ADTFraction times(ADTFraction x) {//multiply two fractions
        int num, den;
        num = this.n * x.n;
        den = this.d * x.d;
        ADTFraction ans = new ADTFraction(num, den);
        return ans;
    }

    public ADTFraction reciprocal() {
        ADTFraction ans = new ADTFraction(this.d, this.n);
        return ans;
    }


    public float value() {
        float val = this.n / (float) this.d;
        return val;
    }


    public void display() {
        System.out.println("Fraction = " + this.n + "/" + this.d);
    }


    public void refine() {
        int min;
        if (this.n < this.d) {
            min = this.n;
        } else {
            min = this.d;
        }

        for (int i = min; i >= 2; i--) {
            if (this.n % i == 0 && this.d % i == 0) {
                this.n /= i;
                this.d /= i;
            }
        }
    }
}
