package com.ua.tpm.aplication.demoanimationandgraphics.charts;

import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBubbleChart {

    final XYChart.Series series1 = new XYChart.Series();
    final XYChart.Series series2 = new XYChart.Series();

    final NumberAxis yAxis = new NumberAxis();
    final NumberAxis xAxis = new NumberAxis();

    final Random random = new Random();

    final int countData = 50;

    final List<XYChart.Series> series = new ArrayList<>();

    private BubbleChart<Number, Number> blc;

    public MyBubbleChart() {

        this.blc = new BubbleChart<>(xAxis, yAxis);

        this.yAxis.setLabel("Product Budget");
        this.xAxis.setLabel("Week");
        this.series1.setName("Product 1");
        this.series2.setName("Product 2");

        for (int i = 0; i < countData; i++) {
            this.series1.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
            this.series2.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
        }

        this.blc.getData().addAll(series1, series2);
    }

    public BubbleChart<Number, Number> getRandomChart() {

        getBubbleChart().getData().clear();

        this.series2.getData().clear();
        this.series1.getData().clear();

        for (int i = 0; i < countData; i++) {
            this.series1.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
            this.series2.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
        }

        this.blc.getData().addAll(series1, series2);
        return blc;
    }

    public BubbleChart<Number, Number> getBubbleChart() {
        return blc;
    }

    public void setBubbleChart(BubbleChart<Number, Number> blc) {
        this.blc = blc;
    }
}
