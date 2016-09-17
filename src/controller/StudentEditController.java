package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClassStanding;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by robertwaters on 9/4/16.
 * Some code reused from the code makery tutorial
 *
 * Controller for the Student Edit / Add dialog box
 */
public class StudentEditController {

    /*  **********************
        References to the FXML widgets in the .fxml file
     */
    @FXML
    private TextField nameField;

    @FXML
    private TextField majorField;

    @FXML
    private ComboBox<String> standingBox;

    /** the window for this dialog */
    private Stage _dialogStage;

    /** the student whose data is being manipulated */
    private Student _student;

    /** flag to signal whether dialog was closed normally */
    private boolean _okClicked = false;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        List<String> standings = new ArrayList<>();
        System.out.println(Arrays.toString(ClassStanding.values()));
        for (ClassStanding c : ClassStanding.values()) {
            standings.add(c.toString());
        }
        ObservableList<String>comboOptions = FXCollections.observableList(standings);

        standingBox.setItems(comboOptions);
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage the stage for this dialog
     */
    public void setDialogStage(Stage dialogStage) {
        _dialogStage = dialogStage;
    }

    /**
     * Sets the student to be edited in the dialog.
     *
     * @param student  the student who will be edited
     */
    public void setStudent(Student student) {
        //remember the current student
        _student = student;

        if (_student == null) System.out.println("Student was null in addStudent!");

        //make the data show up in the gui fields
        nameField.setText(_student.getName());
        majorField.setText(_student.getMajor());
        standingBox.setValue(_student.getStanding());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return  true if the user clicked the OK button
     */
    public boolean isOkClicked() {
        return _okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOKPressed() {
        //First validate the data to insure it is at least reasonable
        if (isInputValid()) {
            //if the data is reasonable, then remember the the student data in the window
            _student.setName(nameField.getText());
            _student.setMajor(majorField.getText());
            _student.setStanding(standingBox.getValue());

            //signal success and close this dialog window.
            _okClicked = true;
            _dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancelPressed() {
        _dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid student name!\n";
        }
        if (majorField.getText() == null || majorField.getText().length() == 0) {
            errorMessage += "No valid major entered!\n";
        }


        //no error message means success / good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(_dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
