package com.example.lesson343javafxthreads;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    protected void onButtonClick() {
        welcomeText.setText("Getting Employees...");
        new Thread(task).start();
    }

    public void initialize() {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                ObservableList<String> employees = FXCollections.observableArrayList(
                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"
                );
                return employees;
            }
        };
        listView.itemsProperty().bind(task.valueProperty());

    }
}