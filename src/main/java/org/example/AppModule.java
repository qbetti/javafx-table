package org.example;

import com.google.inject.AbstractModule;
import javafx.fxml.FXMLLoader;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(FXMLLoader.class).toProvider(FXMLLoaderProvider.class);
    }
}
