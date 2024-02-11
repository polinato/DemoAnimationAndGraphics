package com.ua.tpm.aplication.demoanimationandgraphics.animations;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.util.Duration;

public class MyAnimations {

    private final Timeline timeline;//таймер
    private final Node shape;//елемент
    String animationName = "RotateAnimation";

    public MyAnimations(Node obj) {

        this.shape = obj;
        timeline = new Timeline();
    }

    public String getAnimationName() {
        return animationName;
    }

    public void setAnimationName(String animationName) {
        this.animationName = animationName;
    }

    public Node getShape() {
        return shape;
    }

    public Animation.Status getStatus() {
        return timeline.getStatus();
    }

    public double getRate() {
        return timeline.getRate();
    }

    public void setRate(double rate) {
        timeline.setRate(rate);
    }

    public Timeline getTimeline() {//Повертає анімацію
        return timeline;
    }

    public void play() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    public void playFromStart() {
        timeline.playFromStart();
    }

    public void pause() {
        timeline.pause();
    }

    public void initRotateAnimation() {

        setAnimationName("RotateAnimation");
        timeline.getKeyFrames().clear();

        timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
                        new KeyValue(shape.rotationAxisProperty(), Rotate.Z_AXIS),
                        new KeyValue(shape.rotateProperty(), 0d)),
                        new KeyFrame(Duration.seconds(5),
                        new KeyValue(shape.rotationAxisProperty(), Rotate.Z_AXIS),
                        new KeyValue(shape.rotateProperty(), 360d)));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void initBounceAnimation() {

        setAnimationName("BounceAnimation");
        timeline.getKeyFrames().clear();

        double maxY = Screen.getPrimary().getVisualBounds().getMaxY()/3;
        double minY = Screen.getPrimary().getVisualBounds().getMinY();

        timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,
                        new KeyValue(shape.translateYProperty(), minY )),
                        new KeyFrame(Duration.millis(3000),
                        new KeyValue(shape.translateYProperty(), maxY)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
    }
}
