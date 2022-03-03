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

public class eredmeny {

    public static void display(String darabszam, String osszeg) {
        VBox vbox = new VBox();
        vbox.setPrefWidth(300);
        Text szoveg = new Text();
        Button close = new Button("OK");
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.setSpacing(30);
        Stage eredmenyablak = new Stage();
        eredmenyablak.setTitle("Csomagküldés díja");

        szoveg.setText("\nFeladott csomagok darabszáma:   " + darabszam +
                "\n\n Csomagfeladás díja összesen:      " + osszeg + " Ft");

        vbox.getChildren().addAll(szoveg, close);
        Scene eredmenyscene = new Scene(vbox);
        eredmenyablak.setScene(eredmenyscene);
        eredmenyablak.show();

        eredmenyablak.setOnCloseRequest(evt -> {
            evt.consume();
            eredmenyablak.close();
            util.clear();
        });
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                eredmenyablak.close();
                util.clear();
            }
        });
    }
}
