package com.example.gui_basic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class info {

    public static void display() {
        VBox vbox = new VBox();
        vbox.setPrefWidth(300);
        Text szoveg = new Text();
        Button close = new Button("Bezár");
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(40);
        Stage infoablak = new Stage();
        infoablak.setTitle("Info");

        szoveg.setText("Árképzés:\n\n" +
                "Alapár a szállítási távolságtól függően:\n" +
                "0 <  t < 5 km             500 Ft\n" +
                "5 <= t < 100 km        750 Ft\n" +
                "t >= 100 km              1000 Ft\n\n" +
                "Csomag mérete:\n" +
                "11,5 cm x 36 cm x 61 cm (S)       alap ár\n" +
                "19,5 cm x 36 cm x 61 cm (M)     +10%\n" +
                "37,5 cm x 36 cm x 61 cm (L)       +20!\n\n" +
                "Csomag tömege:\n" +
                "0 < m <= 1 kg        alap ár\n" +
                "1 < m <= 3 kg        +10%\n" +
                "3 < m <= 10 kg      +20%\n" +
                "10 < m <= 20 kg    +30%\n\n" +
                "Darabszám:\n" +
                "1 db                   alap/térfogat/tömeg által meghatározott ár\n" +
                "2 <= x < 5 db    -15%\n" +
                "x >= 5 db           -25%");

        vbox.getChildren().addAll(szoveg, close);
        Scene infoscene = new Scene(vbox);
        infoablak.setScene(infoscene);
        infoablak.show();

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                infoablak.close();
            }
        });
        }


    }

