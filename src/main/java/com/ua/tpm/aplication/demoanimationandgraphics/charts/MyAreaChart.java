package com.ua.tpm.aplication.demoanimationandgraphics.charts;

import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Random;

public class MyAreaChart {

    final NumberAxis yAxis = new NumberAxis();
    final NumberAxis xAxis = new NumberAxis();

    final XYChart.Series series1 = new XYChart.Series();
    final XYChart.Series series2 = new XYChart.Series();

    final Random random = new Random();

    private AreaChart<Number, Number> ac;

    public MyAreaChart(int n) {

        this.ac = new AreaChart<>(xAxis, yAxis);
        this.series1.setName("April");
        this.series2.setName("May");
        for (int i = 0; i < n; i++) {
            this.series1.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
            this.series2.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
        }

        this.ac.getData().addAll(series1, series2);
    }

    public AreaChart<Number, Number> getAreachart() {
        return ac;
    }

    public void setAreachart(AreaChart<Number, Number> ac) {
        this.ac = ac;
    }

    public AreaChart<Number, Number> getRandomChart() {

        int size = random.nextInt(250);
        getAreachart().getData().clear();

        this.series2.getData().clear();
        this.series1.getData().clear();

        for (int i = 0; i < size; i++) {
            this.series1.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
            this.series2.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
        }

        this.ac.getData().addAll(series1, series2);
        return ac;
    }
}
