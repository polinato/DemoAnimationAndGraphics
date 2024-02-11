package com.ua.tpm.aplication.demoanimationandgraphics.charts;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Random;

public class MyBarChart {

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();

    final XYChart.Series series1 = new XYChart.Series();
    final XYChart.Series series2 = new XYChart.Series();

    final String[] countries = {"China", "India", "USA", "Indonesia", "Brazil", "Ukraine"};

    final Double[] numbers2004 = {1308.0, 1087.0, 295.4, 220.1, 183.9, 47.5};
    final Double[] numbers2015 = {1393.0, 1260.0, 325.7, 246.8, 209.4, 45.2};

    final Random random = new Random();

    private BarChart<String, Number> bc;

    public MyBarChart() {

        this.bc = new BarChart<>(xAxis, yAxis);
        this.xAxis.setLabel("Country");
        this.yAxis.setLabel("People(M)");
        this.series1.setName("2004");
        this.series2.setName("2015");

        for (int i = 0; i < countries.length; i++) {
            this.series1.getData().add(new XYChart.Data<>(countries[i], numbers2004[i]));
            this.series2.getData().add(new XYChart.Data<>(countries[i], numbers2015[i]));
        }

        this.bc.getData().addAll(series1, series2);
    }

    public BarChart<String, Number> getBarchart() {
        return bc;
    }

    public void setBarchart(BarChart<String, Number> bc) {
        this.bc = bc;
    }

    public BarChart<String, Number> getRandomChart() {

        getBarchart().getData().clear();

        this.series2.getData().clear();
        this.series1.getData().clear();

        for (String countrie : countries) {
            series2.getData().add(new XYChart.Data<>(countrie, random.nextDouble() * 2000));
            series1.getData().add(new XYChart.Data<>(countrie, random.nextDouble() * 1000));
        }

        this.bc.getData().addAll(series1, series2);
        return bc;
    }
}
