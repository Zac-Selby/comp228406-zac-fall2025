package com.studentinfo.zacselby_comp228lab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentFormController {

    // Text fields for basic info
    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField provinceField;
    @FXML private TextField cityField;
    @FXML private TextField postalField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;

    // Major radio buttons
    @FXML private RadioButton csRadio;
    @FXML private RadioButton busRadio;
    private ToggleGroup majorGroup;

    // Courses and activities
    @FXML private ComboBox<String> courseCombo;
    @FXML private ListView<String> selectedCourses;
    @FXML private CheckBox studentCouncilCheck;
    @FXML private CheckBox volunteerCheck;

    // Output
    @FXML private Button displayBtn;
    @FXML private TextArea outputArea;

    // Course lists for each major
    private final ObservableList<String> csCourses = FXCollections.observableArrayList(
            "Java", "Python", "C#", "Data Structures", "Algorithms"
    );
    private final ObservableList<String> busCourses = FXCollections.observableArrayList(
            "Accounting I", "Marketing", "Business Law", "Economics", "Statistics"
    );

    @FXML
    private void initialize() {
        // Group the radio buttons so only one can be selected
        majorGroup = new ToggleGroup();
        csRadio.setToggleGroup(majorGroup);
        busRadio.setToggleGroup(majorGroup);

        // Disable course combo until a major is chosen
        courseCombo.setDisable(true);

        // When major changes, update courses in the ComboBox
        majorGroup.selectedToggleProperty().addListener((obs, oldT, newT) -> {
            if (newT == null) {
                courseCombo.getItems().clear();
                courseCombo.setDisable(true);
                return;
            }

            courseCombo.setDisable(false);
            if (newT == csRadio) {
                courseCombo.setItems(csCourses);
            } else {
                courseCombo.setItems(busCourses);
            }
            courseCombo.getSelectionModel().clearSelection();
        });

        // When a course is selected from the ComboBox, add it to the ListView (no duplicates)
        courseCombo.setOnAction(e -> {
            String course = courseCombo.getSelectionModel().getSelectedItem();
            if (course != null && !selectedCourses.getItems().contains(course)) {
                selectedCourses.getItems().add(course);
            }
        });
    }

    @FXML
    private void onDisplay() {
        String name = safe(nameField);
        if (name.isEmpty()) {
            showInfo("Validation", "Please enter the student's name.");
            return;
        }

        String major = (majorGroup.getSelectedToggle() == null)
                ? "Not selected"
                : ((RadioButton) majorGroup.getSelectedToggle()).getText();

        // One-line identity similar to the sample screenshot
        String identity = String.format(
                "%s, %s, %s, %s, %s, %s, %s",
                name,
                safe(addressField),
                safe(cityField),
                safe(provinceField),
                safe(postalField),
                safe(phoneField),
                safe(emailField)
        );

        StringBuilder sb = new StringBuilder();
        sb.append(identity).append(System.lineSeparator());
        sb.append("Major: ").append(major).append(System.lineSeparator());

        // Activities
        sb.append("Activities: ");
        boolean anyActivity = false;
        if (studentCouncilCheck.isSelected()) { sb.append("Student Council"); anyActivity = true; }
        if (volunteerCheck.isSelected()) { sb.append(anyActivity ? ", Volunteer Work" : "Volunteer Work"); anyActivity = true; }
        if (!anyActivity) sb.append("None");
        sb.append(System.lineSeparator());

        // Courses
        sb.append("Courses:").append(System.lineSeparator());
        if (selectedCourses.getItems().isEmpty()) {
            sb.append("(none)").append(System.lineSeparator());
        } else {
            for (String c : selectedCourses.getItems()) {
                sb.append(c).append(System.lineSeparator());
            }
        }

        outputArea.setText(sb.toString());
    }

    // Optional: use if you add a Clear button in FXML
    @FXML
    private void onClear() {
        nameField.clear(); addressField.clear(); provinceField.clear();
        cityField.clear(); postalField.clear(); phoneField.clear(); emailField.clear();

        majorGroup.selectToggle(null);
        courseCombo.getItems().clear();
        courseCombo.setDisable(true);
        selectedCourses.getItems().clear();

        studentCouncilCheck.setSelected(false);
        volunteerCheck.setSelected(false);

        outputArea.clear();
    }

    private String safe(TextField tf) {
        return tf.getText() == null ? "" : tf.getText().trim();
    }

    private void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
