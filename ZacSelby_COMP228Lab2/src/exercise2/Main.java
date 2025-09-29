import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog(
                null,
                "Welcome to the Lotto Game!\nChoose a number between 3 and 27:",
                "Lotto Game",
                JOptionPane.QUESTION_MESSAGE
        );

        if (input == null) return; //closed dialog
        int userChoice;
        try {
            userChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Exiting game.");
            return;
        }

        if (userChoice < 3 || userChoice > 27) {
            JOptionPane.showMessageDialog(null, "Number must be between 3 and 27. Exiting game.");
            return;
        }

        boolean won = false;
        for (int attempt = 1; attempt <= 5; attempt++) {
            Lotto lotto = new Lotto();
            int[] nums = lotto.getNumbers();
            int sum = lotto.getSum();

            String message = "Roll " + attempt + ": " +
                    nums[0] + ", " + nums[1] + ", " + nums[2] +
                    " (Sum = " + sum + ")";
            JOptionPane.showMessageDialog(null, message);

            if (sum == userChoice) {
                JOptionPane.showMessageDialog(
                        null,
                        "Congratulations! You matched the sum in " + attempt + " roll(s). You win!",
                        "Winner",
                        JOptionPane.INFORMATION_MESSAGE
                );
                won = true;
                break;
            }
        }

        if (!won) {
            JOptionPane.showMessageDialog(
                    null,
                    "Sorry! You did not match your number in 5 rolls.\nComputer wins!",
                    "Game Over",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}