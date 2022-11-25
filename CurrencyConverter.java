package CurrencyConverter;

/**
 *  Brian Dao
 *  11/25/2022
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CurrencyConverter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the title for the stage
        primaryStage.setTitle("Currency Converter");

        // Create the grid object
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Create text saying "Currency Converter"
        // GRID ROW 0
        Text scenetitle = new Text("Currency Converter");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Create Combobox object and list of currencies
        // GRID ROW 1 COL 0
        String[] currecies = { "USD", "EUR", "JPY", "VND", "MXN", "KRW"};

        ComboBox startingCurrency = new ComboBox(FXCollections.observableArrayList(currecies));
        grid.add(startingCurrency, 0, 1);

        // Create a TextField
        // GRID ROW 1 COL 1
        TextField startingValue = new TextField();
        grid.add(startingValue, 1, 1);

        // Create Combobox object
        // GRID ROW 2 COL 0
        ComboBox endingCurrency = new ComboBox(FXCollections.observableArrayList(currecies));
        grid.add(endingCurrency, 0, 2);

        // Create a TextField
        // GRID ROW 2 COL 1
        Text result = new Text();
        result.setText("Result Here");
        grid.add(result, 1, 2);

        Button btn = new Button("Convert");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String starting = "";
                String ending = "";
                starting += startingCurrency.getValue();
                ending += endingCurrency.getValue();
                result.setText(String.valueOf(converter(starting, ending, Double.parseDouble(startingValue.getText()))));
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public double converter(String current, String convertTo, double value){
        double result = 0.0;
        Currencies curCurrency = Currencies.USD;
        Currencies currencyTo = Currencies.USD;

        switch(current)
        {
            case "USD":
                curCurrency = Currencies.USD;
                break;
            case "EUR":
                curCurrency = Currencies.EUR;
                break;
            case "JPY":
                curCurrency = Currencies.JPY;
                break;
            case "VND":
                curCurrency = Currencies.VND;
                break;
            case "MXN":
                curCurrency = Currencies.MXN;
                break;
            case "KRW":
                curCurrency = Currencies.KRW;
                break;
        }

        switch(convertTo)
        {
            case "USD":
                currencyTo = Currencies.USD;
                break;
            case "EUR":
                currencyTo = Currencies.EUR;
                break;
            case "JPY":
                currencyTo = Currencies.JPY;
                break;
            case "VND":
                currencyTo = Currencies.VND;
                break;
            case "MXN":
                currencyTo = Currencies.MXN;
                break;
            case "KRW":
                currencyTo = Currencies.KRW;
                break;

        }

        result = (value * curCurrency.valueTo) * currencyTo.valueFrom;

        return Double.parseDouble(String.format("%.2f", result));
    }
}
