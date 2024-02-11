package com.ua.tpm.aplication.demoanimationandgraphics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainViewController implements Initializable {

    @FXML
    private BorderPane pBorderPane;

    @FXML
    public void handleActionLoadCharts(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChartView.fxml"));
        pBorderPane.setCenter(root);
    }

    @FXML
    public void handleActionLoadAnimation(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AnimationsView.fxml"));
        pBorderPane.setCenter(root);
    }

    @FXML
    public void handleActionClear(ActionEvent e) {
        pBorderPane.setCenter(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            handleActionLoadCharts(new ActionEvent());
        }
        catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}