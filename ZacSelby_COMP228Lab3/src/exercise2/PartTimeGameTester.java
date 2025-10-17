package exercise2;

public class PartTimeGameTester extends GameTester{
    private int hours;

    public PartTimeGameTester(String name, int hours) {
        super(name, false);
        this.hours = hours;
    }

    public double determineSalary(){
        return this.hours * 20.0;
    }
}