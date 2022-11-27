package com.example.javalab5;

import com.example.javalab5.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditDialog{
    @FXML
    private TextField workerNameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField salaryField;
    private Stage dialogStage;
    private Worker worker;
    private boolean okClicked = false;


    @FXML
    private void initialize() {
    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void setPerson(Worker worker) {
        this.worker = worker;
        workerNameField.setText(worker.getWorkerName());
        ageField.setText(String.valueOf(worker.getAge()));
        salaryField.setText(String.valueOf(worker.getSalary()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            worker.setWorkerName(workerNameField.getText());
            worker.setAge(Integer.parseInt(ageField.getText()));
            worker.setSalary(Double.parseDouble(salaryField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (workerNameField.getText() == null || workerNameField.getText().length() == 0) {
            errorMessage += "No valid worker name!\n";
        }
        if (ageField.getText() == null || ageField.getText().length() == 0) {
            errorMessage += "No valid age!\n";
        } else {
            try {
                Integer.parseInt(ageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid age (must be an integer)!\n";
            }
        }
        if (salaryField.getText() == null || salaryField.getText().length() == 0) {
            errorMessage += "No valid salary!\n";
        } else {
            try {
                Double.parseDouble(salaryField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid salary (must be a number)!\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }
}
