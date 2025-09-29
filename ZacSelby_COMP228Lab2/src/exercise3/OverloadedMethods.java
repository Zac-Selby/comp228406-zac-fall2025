public class OverloadedMethods {

    //method with 2 integers
    public static int add(int a, int b) {
        return a + b;
    }

    //method with 3 integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    //method with 2 doubles
    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        //calling each overloaded method
        int sum1 = add(5, 10);          //method call with 2 ints
        int sum2 = add(2, 3, 7);        //method call with 3 ints
        double sum3 = add(2.5, 5.3);    //method call with 2 doubles

        //display results
        System.out.println("Sum of two ints (5 + 10): " + sum1);
        System.out.println("Sum of three ints (2 + 3 + 7): " + sum2);
        System.out.println("Sum of two doubles (2.5 + 5.3): " + sum3);
    }
}