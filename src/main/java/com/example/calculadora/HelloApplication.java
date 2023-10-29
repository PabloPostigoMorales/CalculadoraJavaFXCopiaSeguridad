package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author Pablo
 * @version 2.0
 * @since 1.0
 */

public class HelloApplication extends Application {
    @Override
    public void start (Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("paginaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 300);
        //stage.initStyle(StageStyle.UTILITY);
        stage.setMaxWidth(450);
        stage.setMaxHeight(435);
        stage.setTitle("Calculadora JavaFX");
        stage.setScene(scene);
        stage.show();

    }

    public static void main (String[] args) {
        launch();
    }
}