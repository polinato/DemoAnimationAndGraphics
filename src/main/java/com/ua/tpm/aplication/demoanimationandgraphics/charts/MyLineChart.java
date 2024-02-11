package com.ua.tpm.aplication.demoanimationandgraphics.charts;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Random;

public class MyLineChart {

    final NumberAxis yAxis = new NumberAxis();
    final NumberAxis xAxis = new NumberAxis();

    final XYChart.Series series1 = new XYChart.Series();
    final XYChart.Series series2 = new XYChart.Series();

    final Random random = new Random();

    private LineChart<Number, Number> lc;

    public MyLineChart(int n) {

        this.lc = new LineChart<>(xAxis, yAxis);

        this.series1.setName("April");
        this.series2.setName("May");

        for (int i = 0; i < n; i++) {
            this.series1.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
            this.series2.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
        }

        this.lc.getData().addAll(series1, series2);
    }

    public LineChart<Number, Number> getLinechart() {//Повертаємо графік
        return lc;
    }

    public void setLinechart(LineChart<Number, Number> lc) {//Можемо присвоїти інший графік
        this.lc = lc;
    }

    public LineChart<Number, Number> getRandomChart() {

        int size = random.nextInt(50);
        getLinechart().getData().clear();

        this.series2.getData().clear();
        this.series1.getData().clear();

        for (int i = 0; i < size; i++) {
            this.series1.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
            this.series2.getData().add(new XYChart.Data<>(random.nextDouble() * 50, random.nextDouble() * 50));
        }

        this.lc.getData().addAll(series1, series2);
        return lc;
    }
}
