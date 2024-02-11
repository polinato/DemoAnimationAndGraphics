package com.ua.tpm.aplication.demoanimationandgraphics.controllers;

import com.ua.tpm.aplication.demoanimationandgraphics.charts.*;
import com.ua.tpm.aplication.demoanimationandgraphics.charts.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartViewController implements Initializable {
    @FXML
    private ToggleButton tb1, tb2, tb3, tb4, tb5;
    @FXML
    private StackPane stackpane;
    @FXML
    private ToggleGroup chartgroup;
    /*Зберігаємо графіки*/
    private MyAreaChart mac;
    private MyBarChart mbc;
    private MyBubbleChart bubbleChart;
    private MyLineChart lineChart;
    private MyStackedBarChart msbc;

    /*Метод, який поміщає графік у контейнер*/
    @FXML
    public void handleActionGetChart(ActionEvent e) {
        ToggleButton source = (ToggleButton) e.getSource();//Визначаємо кнопку, яка  натиснута
        Node node = (Node) source.getUserData();//витягуємо з кно-пки графік
        stackpane.getChildren().clear();//очищуємо контейнер
        stackpane.getChildren().add(node);//додаємо до контейнеру графік
    }

    /*Метод який поміщає у контейнер випадкові дані графіку*/
    @FXML
    public void handleActionGetRandom(ActionEvent e) {
        Toggle source = chartgroup.getSelectedToggle();//визначаємо, яка кнопка вибрана
        Node node = (Node) source.getUserData();//витягуємо графік
        stackpane.getChildren().clear();//очищуємо контейнер
        /*Визначаємо що саме за графік та повертаємо його випадкові дані*/
        if (node.equals(mac.getAreachart())) {
            stackpane.getChildren().add(mac.getRandomChart());
        } else if (node.equals(mbc.getBarchart())) {
            stackpane.getChildren().add(mbc.getRandomChart());
        } else if (node.equals(bubbleChart.getBubbleChart())) {
            stackpane.getChildren().add(bubbleChart.getRandomChart());
        } else if (node.equals(lineChart.getLinechart())) {
            stackpane.getChildren().add(lineChart.getRandomChart());
        } else if (node.equals(msbc.getStackedBarchart())) {
            stackpane.getChildren().add(msbc.getRandomChart());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mac = new MyAreaChart(50);//Створюємо графік на 50 точок
        tb1.setUserData(mac.getAreachart());//поміщаємо графік у кнопку
        stackpane.getChildren().add(mac.getAreachart());//Поміщаємо графік у контейнер
        mbc = new MyBarChart();//створюємо інший графік
        tb2.setUserData(mbc.getBarchart());//поміщаємо його у кнопку
        bubbleChart = new MyBubbleChart();//Створюємо ще 1 графік
        tb3.setUserData(bubbleChart.getBubbleChart());//Поміщаємо його у кнопку
        lineChart = new MyLineChart(50);//Створюємо ще 1 графік
        tb4.setUserData(lineChart.getLinechart());//Поміщаємо його у кнопку
        msbc = new MyStackedBarChart();//створюємо інший графік
        tb5.setUserData(msbc.getStackedBarchart());//поміщаємо його у кно-пку
    }
}
