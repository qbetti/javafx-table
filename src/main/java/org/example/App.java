package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Injector injector;

    @Override
    public void start(Stage stage) throws IOException {
        injector = Guice.createInjector();

        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = injector.getInstance(FXMLLoader.class);
        try (InputStream fxmlInputStream = ClassLoader.getSystemResourceAsStream("org/example/" + fxml + ".fxml")) {
            return fxmlLoader.load(fxmlInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        launch();
    }

}