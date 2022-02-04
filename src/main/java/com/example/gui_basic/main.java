package com.example.gui_basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    VBox vbox = new VBox();
    HBox sor1 = new HBox();
    static Label sszMezo = new Label("1");
    Button infoGomb = new Button("Info");
    HBox sor2 = new HBox();
    HBox sor3 = new HBox();
    static TextField m1Mezo = new TextField();
    static TextField m2Mezo = new TextField();
    static TextField m3Mezo = new TextField();
    HBox sor4 = new HBox();
    static TextField tomegMezo = new TextField();
    static TextField tavMezo = new TextField();
    HBox sor5 = new HBox();
    static TextField osszeg = new TextField();
    Button clear = new Button("Mezők törlése");
    HBox sor6 = new HBox();
    Button tovabb = new Button("Tovább");
    Button kesz = new Button("Kész");
    Button uj = new Button("Új csomagfeladás");
    Button kilepes = new Button("Kilépés");
    Scene scene = new Scene(vbox);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Csomagküldés");
        osszeg.setEditable(false);
        sszMezo.setMaxWidth(30);
        m1Mezo.setMaxWidth(50);
        m2Mezo.setMaxWidth(50);
        m3Mezo.setMaxWidth(50);
        tomegMezo.setMaxWidth(50);
        tavMezo.setMaxWidth(50);
        osszeg.setMaxWidth(100);
        primaryStage.setScene(scene);
        sor1.setSpacing(10);
        sor3.setSpacing(10);
        sor4.setSpacing(10);
        sor5.setSpacing(10);
        sor6.setSpacing(30);
        vbox.setMargin(sor1, new Insets(20, 20, 20, 20));         // top, right, bottom, left
        vbox.setMargin(sor2, new Insets(0, 20, 5, 20));
        vbox.setMargin(sor3, new Insets(0, 20, 25, 20));
        vbox.setMargin(sor4, new Insets(0, 20, 40, 20));
        vbox.setMargin(sor5, new Insets(0, 20, 50, 20));
        vbox.setMargin(sor6, new Insets(0, 20, 20, 20));
        sor1.setMargin(infoGomb, new Insets(0,0,0,180));
        sor5.setMargin(tovabb, new Insets(0, 0, 0, 55));
        sor6.setAlignment(Pos.CENTER);
        sszMezo.setStyle("-fx-background-color: transparent");
        osszeg.setStyle("-fx-background-color: transparent");

        ObservableList list1 = sor1.getChildren();
        list1.addAll(new Label("Csomag sorszáma: "), sszMezo, infoGomb);
        ObservableList list2 = sor2.getChildren();
        list2.add(new Label("Csomag méretei (cm): "));
        ObservableList list3 = sor3.getChildren();
        list3.addAll(m1Mezo, m2Mezo, m3Mezo);
        ObservableList list4 = sor4.getChildren();
        list4.addAll(new Label("Csomag tömege (kg): "), tomegMezo, new Label("Szállítási távolság (km): "), tavMezo);
        ObservableList list5 = sor5.getChildren();
        list5.addAll(new Label("Rész/végösszeg (Ft): "), osszeg, tovabb, kesz);
        ObservableList list6 = sor6.getChildren();
        list6.addAll(clear, uj, kilepes);
        ObservableList egesz = vbox.getChildren();
        egesz.addAll(sor1, sor2, sor3, sor4, sor5, sor6);

        primaryStage.close();
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            Platform.exit();
        });
        primaryStage.show();

        infoGomb.setOnAction(event);
        tovabb.setOnAction(event);
        kesz.setOnAction(event);
        clear.setOnAction(event);
        uj.setOnAction(event);
        kilepes.setOnAction(event);
    }

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
        // Kilépés gomb
            if (actionEvent.getSource() == kilepes) {
                Platform.exit();
        // Clear gomb
            } else if (actionEvent.getSource() == clear) {
                util.reset();
        // Tovább gomb
            } else if (actionEvent.getSource() == tovabb) {
                boolean kitoltes = util.inputCheck();
                if (kitoltes) {
                    util.szamitas(Integer.parseInt(tavMezo.getText()), Double.parseDouble(m1Mezo.getText()), Double.parseDouble(m2Mezo.getText()), Double.parseDouble(m3Mezo.getText()), Double.parseDouble(tomegMezo.getText()));
                    util.reset();
                    sszMezo.setText(util.ssz.toString());
                    osszeg.setText(Double.toString(util.szum));
                }
            }
        // Kész gomb
            else if (actionEvent.getSource() == kesz) {
                boolean kitoltes = util.inputCheck();
                if (kitoltes) {
                    util.szamitas(Integer.parseInt(tavMezo.getText()), Double.parseDouble(m1Mezo.getText()), Double.parseDouble(m2Mezo.getText()), Double.parseDouble(m3Mezo.getText()), Double.parseDouble(tomegMezo.getText()));
                    Integer db = util.ssz - 1;
                    eredmeny.display(db.toString(), Double.toString(util.szum));
                }
            }
        // Új csomagfeladás gomb
            else if (actionEvent.getSource() == uj) {
                    util.clear();
        // Info gomb
                } else if (actionEvent.getSource() == infoGomb) {
                    info.display();
                }
            }
            ;
        };

}
