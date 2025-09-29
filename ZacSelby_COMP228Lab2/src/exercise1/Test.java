import javax.swing.JOptionPane;
import java.util.Random;
import java.text.DecimalFormat;

public class Test {
    private final String[] questions;
    private final String[][] choices; //4 options per question
    private final int[] correctIndex; // 0-3
    private int correctCount = 0;
    private int incorrectCount = 0;
    private final Random rng = new Random();

    public Test() {
        questions = new String[]{
                "1) In which year did Sun Microsystems fund an internal corporate research project led by James Gosling,\nwhich resulted in a C++ -based object-oriented programming language that Sun called Java?",
                "2) Which of the following tools support the software-development process, including editors for\nwriting and editing programs and debuggers for locating logic errors—errors that cause programs to execute incorrectly?",
                "3) Which of the following Java program units defines a group of related objects?",
                "4) Which of the following statements is false in relation to Java parameters?",
                "5) Which of the following typically groups related classes so that they could be imported into programs and reused?",
                "6) What may method arguments be?"
        };

        choices = new String[][]{
                {"A) 1998", "B) 1999", "C) 1990", "D) 1991"},
                {"A) Java Virtual Machine (JVM)", "B) Java Integrated Development Envronments (IDE)", "C) Java Application Programming Interfaces (API)", "D) Java Development Kit (JDK)"},
                {"A) Java method", "B) Java", "C) Java default constructor", "D) Java Class"},
                {"A) Parameters do not need to specify a datatype.", "B) Parameters are located inside the parentheses that follow the method name in the method declaration.",
                        "C) Parameter names must follow the naming rules of identifiers.", "D) Parameters are declared in a comma-separated parameter list"},
                {"A) Method", "B) IDE", "C) Package", "D) Function"},
                {"A) only constants.", "B) only variables", "C) only strings.", "D) constants, variables, or expressions."}
        };

        correctIndex = new int[]{3, 1, 3, 0, 2, 3};
    }

    public void inputAnswer() {
        JOptionPane.showMessageDialog(
                null,
                "Welcome to the Java Basics Quiz.\nThere are " + questions.length + " questions.\nPick A, B, C, or D.",
                "Java Test", JOptionPane.INFORMATION_MESSAGE
        );

        for (int i = 0; i < questions.length; i++) {
            Integer userChoice = simulateQuestion(i);
            if (userChoice == null) {
                //user closed dialog; confirm exit
                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to end the test?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) break;
                i--; //re-ask same question
                continue;
            }

            boolean isRight = checkAnswer(i, userChoice);
            if (isRight) {
                correctCount++;
                JOptionPane.showMessageDialog(
                        null,
                        generateMessage(true),
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                incorrectCount++;
                String explain = "Correct answer: " + letterFor(correctIndex[i]) + ") " +
                        stripLabel(choices[i][correctIndex[i]]);
                JOptionPane.showMessageDialog(
                        null,
                        generateMessage(false) + "\n" + explain,
                        "Result",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }

        showSummary();
    }

    //shows one question and returns option index of selected option, null if closed
    private Integer simulateQuestion(int qIndex) {
        String prompt = questions[qIndex] + "\n\n" +
                choices[qIndex][0] + "\n" +
                choices[qIndex][1] + "\n" +
                choices[qIndex][2] + "\n" +
                choices[qIndex][3] + "\n\n" +
                "Select an option:";
        Object[] buttons = {"A", "B", "C", "D"};
        int selected = JOptionPane.showOptionDialog(
                null,
                prompt,
                "Question " + (qIndex + 1),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]
        );
        if (selected < 0) return null;
        return selected;
    }

    //compares user answer to correct answer
    private boolean checkAnswer(int qIndex, int userIndex) {
        return userIndex == correctIndex[qIndex];
    }

    //random feedback using switch
    private String generateMessage(boolean correct) {
        int pick = rng.nextInt(4);
        if (correct) {
            switch (pick) {
                case 0: return "Excellent!";
                case 1: return "Good!";
                case 2: return "Keep up the good work!";
                default: return "Nice work!";
            }
        } else  {
            switch (pick) {
                case 0: return "No. Please try again.";
                case 1: return "Wrong. Try once more.";
                case 2: return "Don't give up!";
                default: return "No. Keep trying.";
            }
        }
    }

    //final stats
    private void showSummary() {
        int total = correctCount + incorrectCount;
        if (total == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "No answers recorded",
                    "Summary",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        double pct = 100.0 * correctCount / total;
        DecimalFormat df = new DecimalFormat("0.00");
        String summary = "Summary: " +
                "Correct: " + correctCount + "\n" +
                "Incorrect: " + incorrectCount + "\n" +
                "Score: " + df.format(pct) + "%";
        JOptionPane.showMessageDialog(
                null,
                summary,
                "Summary",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    //helpers
    private String letterFor(int idx) { return new String[]{"A","B","C","D"}[idx]; }

    private String stripLabel(String labeledOption) {
        //turns "A) text" int "text"
        int i = labeledOption.indexOf(") ");
        return i >= 0 ? labeledOption.substring(i + 2) : labeledOption;
    }
}
