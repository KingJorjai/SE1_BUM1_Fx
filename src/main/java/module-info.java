module eus.ehu.backend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires okhttp3;

    opens eus.ehu.backend to javafx.fxml;
    exports eus.ehu.backend;
    exports eus.ehu.common;
    opens eus.ehu.common to javafx.fxml;
    exports eus.ehu.frontend;
    opens eus.ehu.frontend to javafx.fxml;
    exports eus.ehu.frontend.gui;
    opens eus.ehu.frontend.gui to javafx.fxml;
    exports eus.ehu.frontend.cli;
    opens eus.ehu.frontend.cli to javafx.fxml;
}
