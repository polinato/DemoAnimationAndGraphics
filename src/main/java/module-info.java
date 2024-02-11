module com.ua.tpm.aplication.demoanimationandgraphics {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.logging;

    opens com.ua.tpm.aplication.demoanimationandgraphics to javafx.fxml;
    exports com.ua.tpm.aplication.demoanimationandgraphics;
    exports com.ua.tpm.aplication.demoanimationandgraphics.controllers;
    opens com.ua.tpm.aplication.demoanimationandgraphics.controllers to javafx.fxml;
}