package com.example.javalab5;

import com.example.javalab5.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class OverviewController{
    @FXML
    private TableView<Worker> personTable;
    @FXML
    private TableColumn<Worker,String> workerNameColumn;
    @FXML
    private TableColumn<Worker,String> ageColumn;
    @FXML
    private TableColumn<Worker,String> salaryColumn;
    @FXML
    private Label workerNameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label salaryLabel;

    private com.example.javalab5.MainApp mainApp;

    public OverviewController() {}
    @FXML
    private void initialize() {
        workerNameColumn.setCellValueFactory(cellData->cellData.getValue().workerNameProperty());
        showWorkerDetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showWorkerDetails(newValue));
    }

    public void setMainApp(com.example.javalab5.MainApp mainApp) {
        this.mainApp=mainApp;
        personTable.setItems(mainApp.getWorkerData());
    }

    private void showWorkerDetails(Worker worker) {
        if(worker!=null) {
            workerNameLabel.setText(worker.getWorkerName());
            ageLabel.setText(String.valueOf(worker.getAge()));
            salaryLabel.setText(String.valueOf(worker.getSalary()));
        }else{
            workerNameLabel.setText("");
            ageLabel.setText("");
            salaryLabel.setText("");
        }
    }


    public void handleDeleteWorker() {
        int selectedIndex=personTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex>=0) {
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Подтвердите выбор");
            alert.setHeaderText("Точно хотите удалить?");
            //alert.setContentText("Да/Нет");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent() || result.get() == ButtonType.OK){
                personTable.getItems().remove(selectedIndex);
            }
        }else{
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Worker Selected");
            alert.setContentText("Please select a worker in the table.");
            alert.showAndWait();
        }
    }


    @FXML
    private void handleNewWorker() {
        Worker tempWorker =new Worker();
        boolean okClicked=mainApp.showWorkerEditDialog(tempWorker);
        if(okClicked) {
            mainApp.getWorkerData().add(tempWorker);
        }
    }
    @FXML
    private void handleEditWorker() {
        Worker selectedWorker=personTable.getSelectionModel().getSelectedItem();
        if(selectedWorker!=null) {
            boolean okClicked=mainApp.showWorkerEditDialog(selectedWorker);
            if(okClicked) {
                showWorkerDetails(selectedWorker);
            }
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No worker Selected");
            alert.setContentText("Please select a worker in the table.");
            alert.showAndWait();
        }
    }

}
