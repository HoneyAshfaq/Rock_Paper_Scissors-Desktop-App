package com.example.demo3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

	public Controller c;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fl = new FXMLLoader(Main.class.getResource("App_layout.fxml"));
		GridPane g=fl.load();
		stage.setResizable(false);
		c=fl.getController();
		MenuBar cm  = create_menu();
		cm.prefWidthProperty().bind(stage.widthProperty());
		VBox v= (VBox) g.getChildren().get(0);
		v.getChildren().addAll(cm);
		Scene scene = new Scene(g);
		stage.setTitle("Rock-Paper-Scissors");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}


	public MenuBar create_menu() {

		SeparatorMenuItem spm1=new SeparatorMenuItem();
		SeparatorMenuItem spm2=new SeparatorMenuItem();



		Menu f = new Menu("File");
		MenuItem ng = new MenuItem("New Game");
		ng.setOnAction(event ->{
			 c.reset_game();
		});

		MenuItem rg = new MenuItem("Reset Game");
		rg.setOnAction(event ->{
			c.reset_game();
		});

		MenuItem eg = new MenuItem("Exit Game");
		eg.setOnAction(event->{
			Platform.exit();
			System.exit(0);
		});
         f.getItems().addAll(ng,spm1,rg,spm2,eg);


		SeparatorMenuItem spm3=new SeparatorMenuItem();
		Menu cgm = new Menu("Change Game Mode");
		MenuItem nm = new MenuItem("Normal Game");
		nm.setOnAction(event ->{
			c.cgm5=false;
			c.count=0;
			c.reset_game();
		});

		MenuItem srg = new MenuItem("5 Round game");
		srg.setOnAction(event->{
			c.cgm5=true;
			c.count=0;
		c.reset_game();
		});

		cgm.getItems().addAll(nm,spm3,srg);

		SeparatorMenuItem spm4=new SeparatorMenuItem();
		Menu h = new Menu("Help");
		MenuItem ad = new MenuItem("About Developer");
		ad.setOnAction(event->{
			Alert a=new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("About the developer");
			a.setHeaderText("Honey Ashfaq");
			a.setContentText("Hi i am Honey, a aspiring software developer. I am an B.tech" +
					" Engineer from Electronic & Communication & i loved to create that type of desktop " +
					"application. My hobbies are cricket, video games ,watching movies." +
					"Always eager to gain new skills.");
			a.show();
		});

		MenuItem ag = new MenuItem("About Game");
		ag.setOnAction(event->{
			Alert a=new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("About (Rock-Paper-Scissors) game");
			a.setHeaderText("How to play");
			a.setResizable(true);
			String s=String.format(("Rock paper scissors is a hand game usually played between" +
					" two people, in which each player simultaneously forms one of three " +
					"shapes with an outstretched hand.").concat("\n"+"These shapes are rock," +
					" paper, and scissors. It has only two possible outcomes- a draw, or a" +
					" win for one player and a loss for the other. A player who decides to" +
					" play rock will beat another player who has chosen " +
					"scissors (\"rock crushes scissors\" or sometimes \"blunts scissors\")," +
					" but will lose to one who has played paper (\"paper covers rock\") a " +
					"play of paper will lose to a play of scissors (\"scissors cuts paper\")." +
					" If both players choose the same shape, the game is tied and is usually" +
					" immediately replayed to break the tie."));
			a.setContentText(s);

			a.show();
		});

		h.getItems().addAll(ad,spm4,ag);


		MenuBar mb = new MenuBar();
		mb.getMenus().addAll(f,cgm,h);
		return mb;


	}



}








