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

public class errormessage {
    public static void display(String hiba) {
        VBox vbox = new VBox();
        vbox.setPrefWidth(300);
        Text szoveg = new Text();
        Button close = new Button("OK");
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(30);
        Stage errormessage = new Stage();
        errormessage.setTitle("Hiba");

        szoveg.setText("\nHiba a bevitt adatokban: \n\n" + hiba);

        vbox.getChildren().addAll(szoveg, close);
        Scene errorscene = new Scene(vbox);
        errormessage.setScene(errorscene);
        errormessage.show();

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                errormessage.close();
            }
        });
    }
}
