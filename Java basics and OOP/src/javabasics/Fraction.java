package javabasics;

/*
    设计一个表示分数的类Fraction。这个类用两个int类型的变量分别表示分子和分母。
    这个类的构造函数是：Fraction(int a, int b)构造一个a/b的分数。
    这个类要提供以下的功能：
    double toDouble();
        将分数转换为double
    Fraction plus(Fraction r);
        将自己的分数和r的分数相加，产生一个新的Fraction的对象。注意小学四年级学过两个分数如何相加的哈。
    Fraction multiply(Fraction r);
        将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
    void print();
        将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。如果分数是1/1，应该输出1。
        当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
    注意，在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。
 */
public class Fraction {
    public int denominator;
    public int numerator;

    public Fraction(int denominator, int nominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int gcd = GreatestCommonDivisor.gcd2(denominator, nominator);
        this.denominator = denominator / gcd;
        this.numerator = nominator / gcd;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public Fraction plus(Fraction r) {
        int newNumerator = this.numerator * r.denominator + this.denominator * r.numerator;
        int newDenominator = this.denominator * r.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction r) {
        int newD = r.denominator * this.denominator;
        int newN = r.numerator * this.numerator;
        return new Fraction(newD, newN);
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 9);
        f1.print();
        Fraction f2 = new Fraction(2, 5);
        f2.print();
        Fraction f3 = f1.plus(f2);
        f3.print();
        Fraction f4 = f1.multiply(f2);
        f4.print();
    }
}
