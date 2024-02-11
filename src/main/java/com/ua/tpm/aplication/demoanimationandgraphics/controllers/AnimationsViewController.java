package com.ua.tpm.aplication.demoanimationandgraphics.controllers;

import com.ua.tpm.aplication.demoanimationandgraphics.animations.MyAnimations;
import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimationsViewController implements Initializable {

    double rate;

    @FXML
    private ToggleGroup togglegroup;

    @FXML
    private ToggleButton tba1, tba2, tba3;

    @FXML
    private StackPane stackpaneA;

    @FXML
    private Label labelRate;

    @FXML
    private Button bPlay;

    private MyAnimations boxAnimate;
    private MyAnimations circleAnimate;
    private MyAnimations sphereAnimate;

    @FXML
    public void handleActionToggle(ActionEvent e) {

        stackpaneA.getChildren().clear();

        Toggle toggle = togglegroup.getSelectedToggle();
        MyAnimations selected = (MyAnimations) toggle.getUserData();
        Node node = selected.getShape();
        stackpaneA.getChildren().add(node);
        labelRate.setText(selected.getRate() + "");

        Animation.Status status = selected.getStatus();
        if (status == Animation.Status.RUNNING)
            selected.stop();

        bPlay.setText("Play");
    }

    @FXML
    public void handleActionPlay(ActionEvent e) {

        Toggle toggle = togglegroup.getSelectedToggle();
        MyAnimations selected = (MyAnimations) toggle.getUserData();
        bPlay.setText("Pause");
        Animation.Status status = selected.getStatus();

        if (!selected.getTimeline().getKeyFrames().isEmpty()) {
            if (status == Animation.Status.STOPPED) {
                selected.playFromStart();
            }
            else if (status == Animation.Status.PAUSED) {
                selected.play();
                bPlay.setText("Pause");
            }
            else if (status == Animation.Status.RUNNING) {
                selected.pause();
                bPlay.setText("Play");
            }
        }
        else {
            selected.initRotateAnimation();
            selected.playFromStart();
        }
    }

    @FXML
    public void handleActionStop(ActionEvent e) {

        Toggle toggle = togglegroup.getSelectedToggle();
        MyAnimations selected = (MyAnimations) toggle.getUserData();
        selected.stop();
        bPlay.setText("Play");
    }

    @FXML
    public void handleActionNextAnim(ActionEvent e) {

        Toggle toggle = togglegroup.getSelectedToggle();
        MyAnimations selected = (MyAnimations) toggle.getUserData();

        switch (selected.getAnimationName()){
            case "RotateAnimation":
                selected.initBounceAnimation();
                break;
            case "BounceAnimation":
                selected.initRotateAnimation();
                break;
        }
    }

    @FXML
    public void handleActionRate(ActionEvent e) {

        Button source = (Button) e.getSource();
        Toggle toggle = togglegroup.getSelectedToggle();
        MyAnimations selected = (MyAnimations) toggle.getUserData();
        rate = selected.getRate();
        switch (source.getText()) {
            case "+":
                rate++;
                break;
            case "-":
                rate--;
                break;
        }
        selected.setRate(rate);//Встановлюємо змінену швид-кість
        labelRate.setText(selected.getRate() + "");//Показуємо на мітці
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Box box = new Box(200, 200, 200);
        box.getTransforms().addAll(new Rotate(45, Rotate.X_AXIS), new Rotate(45, Rotate.Y_AXIS));
        boxAnimate = new MyAnimations((Node) box);

        Circle circle = new Circle(200);
        circle.getTransforms().addAll(new Rotate(45, Rotate.X_AXIS), new Rotate(45, Rotate.Y_AXIS));
        circleAnimate = new MyAnimations((Node) circle);

        Sphere sphere = new Sphere(180);
        sphere.getTransforms().addAll(new Rotate(45, Rotate.X_AXIS), new Rotate(45, Rotate.Y_AXIS));
        sphereAnimate = new MyAnimations((Node) sphere);

        tba1.setUserData(boxAnimate);
        tba2.setUserData(circleAnimate);
        tba3.setUserData(sphereAnimate);

        Toggle toggle = togglegroup.getSelectedToggle();
        MyAnimations selected = (MyAnimations) toggle.getUserData();
        stackpaneA.getChildren().add(selected.getShape());

        selected.initRotateAnimation();
        labelRate.setText(selected.getRate() + "");
    }
}
