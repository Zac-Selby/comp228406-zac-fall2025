import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Test t = new Test();
            t.inputAnswer(); //start the test
        });
    }
}