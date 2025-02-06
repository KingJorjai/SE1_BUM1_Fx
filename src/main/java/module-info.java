module eus.ehu.backend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires okhttp3;

    exports eus.ehu.bum_fx.business_logic;
    opens eus.ehu.bum_fx.business_logic to javafx.fxml;
    exports eus.ehu.bum_fx.presentation;
    opens eus.ehu.bum_fx.presentation to javafx.fxml;
}
