import java.util.Random;

public class Lotto {
    private int[] numbers; //holds 3 random numbers, 1-9
    private Random rng;

    public Lotto() {
        rng = new Random();
        numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rng.nextInt(9) + 1; // 1-9
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
