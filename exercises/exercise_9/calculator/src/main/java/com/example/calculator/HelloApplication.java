package com.example.calculator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private TextField resultField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label num1Label = new Label("Number 1:");
        GridPane.setConstraints(num1Label, 0, 0);

        num1Field = new TextField();
        GridPane.setConstraints(num1Field, 1, 0);

        Label num2Label = new Label("Number 2:");
        GridPane.setConstraints(num2Label, 0, 1);

        num2Field = new TextField();
        GridPane.setConstraints(num2Field, 1, 1);

        Label resultLabel = new Label("Result:");
        GridPane.setConstraints(resultLabel, 0, 2);

        resultField = new TextField();
        resultField.setEditable(false);
        GridPane.setConstraints(resultField, 1, 2);

        Button addButton = new Button("+");
        addButton.setOnAction(e -> calculateResult("+"));
        GridPane.setConstraints(addButton, 2, 0);

        Button subtractButton = new Button("-");
        subtractButton.setOnAction(e -> calculateResult("-"));
        GridPane.setConstraints(subtractButton, 3, 0);

        Button multiplyButton = new Button("*");
        multiplyButton.setOnAction(e -> calculateResult("*"));
        GridPane.setConstraints(multiplyButton, 2, 1);

        Button divideButton = new Button("/");
        divideButton.setOnAction(e -> calculateResult("/"));
        GridPane.setConstraints(divideButton, 3, 1);

        grid.getChildren().addAll(num1Label, num1Field, num2Label, num2Field, resultLabel, resultField,
                addButton, subtractButton, multiplyButton, divideButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateResult(String operator) {
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        resultField.setText(String.valueOf(result));
    }
}

//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}