package com.example.javalab5;

import com.example.javalab5.model.Worker;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Worker> workerData = FXCollections.observableArrayList();

    public MainApp() {
        workerData.add(new Worker("Andrew", 19, 3700.8));
        workerData.add(new Worker("Kim", 40, 13900.1));
        workerData.add(new Worker("Kanye", 38, 5120.2));
        workerData.add(new Worker("Jamal", 20, 9000.0));
    }

    public ObservableList<Worker> getWorkerData() {
        return workerData;
    }


    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("WorkerApp");
        initRootLayout();
        showPersonOverview();
    }

    public void initRootLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/com/example/javalab5/view/RootLayout.fxml"));
        try {
            rootLayout = fxmlLoader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showPersonOverview() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("/com/example/javalab5/view/PersonOverview.fxml"));
        try {
            AnchorPane personOverview = fxmlLoader.load();
            rootLayout.setCenter(personOverview);
            OverviewController controller = fxmlLoader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public boolean showWorkerEditDialog(Worker worker) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/com/example/javalab5/view/PersonEditDialog.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Worker");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            EditDialog controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(worker);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        launch();
    }

}
