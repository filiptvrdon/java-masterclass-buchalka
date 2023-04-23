package com.example.lesson343javafxthreads;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

public class HelloController {
    @FXML
    private Label progressLabel;
    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    protected void onButtonClick() {
        // progressLabel.setText("Getting Employees...");
        new Thread(task).start();
    }

    public void initialize() {
        progressBar.setVisible(true);
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {
                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"
                };

                ObservableList<String> employees = FXCollections.observableArrayList();

                for (int i = 0; i < 6; i++) {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i + 1, 6);
                    Thread.sleep(500);
                }

                return employees;
            }
        };
        progressBar.progressProperty().bind(task.progressProperty());
        progressLabel.textProperty().bind(task.messageProperty());
        listView.itemsProperty().bind(task.valueProperty());


    }
}