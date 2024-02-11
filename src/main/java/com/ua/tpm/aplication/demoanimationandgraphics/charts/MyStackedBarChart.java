package com.ua.tpm.aplication.demoanimationandgraphics.charts;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.util.Random;

public class MyStackedBarChart {

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();

    final XYChart.Series series1 = new XYChart.Series();
    final XYChart.Series series2 = new XYChart.Series();

    final String[] countries = {"China", "India", "USA", "Indonesia", "Brazil", "Ukraine"};

    final Double[] numbers2020 = {1308.0, 1087.0, 295.4, 220.1, 183.9, 47.5};
    final Double[] numbers2021 = {1393.0, 1260.0, 325.7, 246.8, 209.4, 45.2};

    final Random random = new Random();

    private StackedBarChart<String, Number> sbc;

    public MyStackedBarChart() {

        this.sbc = new StackedBarChart<>(xAxis, yAxis);
        this.xAxis.setLabel("Country");
        this.yAxis.setLabel("People(M)");
        this.series1.setName("2020");
        this.series2.setName("2021");

        for (int i = 0; i < countries.length; i++) {
            this.series1.getData().add(new XYChart.Data<>(countries[i], numbers2020[i]));
            this.series2.getData().add(new XYChart.Data<>(countries[i], numbers2021[i]));
        }

        this.sbc.getData().addAll(series1, series2);
    }

    public StackedBarChart<String, Number> getStackedBarchart() {
        return sbc;
    }

    public void setStackedBarchart(StackedBarChart<String, Number> sbc) {
        this.sbc = sbc;
    }

    public StackedBarChart<String, Number> getRandomChart() {

        getStackedBarchart().getData().clear();

        this.series2.getData().clear();
        this.series1.getData().clear();

        for (String countrie : countries) {
            series2.getData().add(new XYChart.Data<>(countrie, random.nextDouble() * 2000));
            series1.getData().add(new XYChart.Data<>(countrie, random.nextDouble() * 1000));
        }

        this.sbc.getData().addAll(series1, series2);
        return sbc;
    }
}
