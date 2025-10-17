package exercise2;

public abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public String getName() {
        return name;
    }
    public boolean isFullTime() {
        return isFullTime;
    }

    public String toString() {
        return "Name: " + name + ", Full Time: " + isFullTime;
    }

    public abstract double determineSalary();
}