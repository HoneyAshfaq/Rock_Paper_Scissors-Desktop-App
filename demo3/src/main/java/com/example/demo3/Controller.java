package com.example.demo3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {


	   public Label name_l;
	   public Label  count_l_1;
	   public  Label count_l_2;
	   public Button b1;
	   public  Button b2;
	   public TextField text;
	   public ChoiceBox cb;

	   public  Boolean r_value=false;
	   public  Boolean p_value=false;
	   public  Boolean s_value=false;
	   public  String c_s_v="";
	   public  String winner_dialogue="";
	   public int computer_count = 0;
	   public int player_count = 0;
	   public   String player_name="";
	   public String s_text="";
	   public  String p_s_v="";
	   public  Boolean cgm5=false;
	   public int count=0;
	   public  String text_2;
	   public  Boolean butt=true;




	   @Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	   	cb.getItems().addAll("Rock","Paper","Scissors");
		   cb.setValue("Choose Any One");

		    cb.getSelectionModel().selectedItemProperty().addListener((object,o,n)->{

		    	if(n=="Rock"){
		    		r_value=true;
		    		p_value=false;
		    		s_value=false;
		    		p_s_v="rock";
				}
		    	if(n=="Paper"){
					p_value=true;
					r_value=false;
					s_value=false;
					p_s_v="paper";
				}
		    	if(n=="Scissors"){
					s_value=true;
					p_value=false;
					r_value=false;
					p_s_v="scissors";
				}

			});
		   b2.setOnAction(event ->{
		   	butt =true;

			   s_text= text.getText();
			   if(s_text.length()!=0) {
				   name_l.setText(s_text);
				   player_name =name_l.getText();
			   }else{
				   name_l.setText("Player");
				   player_name=name_l.getText();
			   }
		   });


		     b1.setOnAction(event ->{

				 text_2 = text.getText();

				 if(text_2.length()==0) {
					 butt = false;
				 }
                        if(butt) {

							if ((text_2.length() != 0)) {


								if (r_value) {
									r_is_choosed();

								}
								if (p_value) {
									p_is_choosed();

								}
								if (s_value) {
									s_is_choosed();
								}
							}
						}
			 });

	}


	private void s_is_choosed() {

      if(s_text.length()!=0) {

		  Random value = new Random();
		  int computer = value.nextInt(3);// a=c,b=p;
		  if (computer == 0) {
			  c_s_v = "scissors";

		  } else if (computer == 1) {
			  c_s_v = "paper";

		  } else {
			  c_s_v = "rock";
		  }
		  int player = 0;

		  System.out.printf("Computer choose (%d) & %s choose (%d)" + "\n", computer, player_name, player);

		   if (computer == 1 && player == 0) {
			   winner_dialogue = "[The Winner is ".concat(player_name+"]");
			  count_l_1.setText(String.valueOf(++player_count));
			  show_winner();
			  System.out.printf("[%s won]" + "\n", player_name);

		  } else if (computer == 2 && player == 0) {
			   winner_dialogue = "[The Winner is Computer]";
			  count_l_2.setText(String.valueOf(++computer_count));
			  show_winner();
			  System.out.println("[computer won]");

		  } else {
			  winner_dialogue = "[Match draw]";
			  show_winner();
			  System.out.println("[ Match Draw ]");
		  }
	  }

	}


	private void p_is_choosed() {

		if(s_text.length()!=0) {
			Random value = new Random();
			int computer = value.nextInt(3);// a=c,b=p;
			if (computer == 0) {
				c_s_v = "scissors";

			} else if (computer == 1) {
				c_s_v = "paper";

			} else {
				c_s_v = "rock";
			}
			int player = 1;

			System.out.printf("Computer choose (%d) & %s choose (%d)" + "\n", computer, player_name, player);

			if (computer == 0 && player == 1) {
				winner_dialogue = "[The Winner is Computer]";
				count_l_2.setText(String.valueOf(++computer_count));
				show_winner();
				System.out.println("[computer won]");

			} else if (computer == 2 && player == 1) {
				winner_dialogue = "[The Winner is ".concat(player_name+"]");
				count_l_1.setText(String.valueOf(++player_count));
				show_winner();
				System.out.printf("[%s won]" + "\n", player_name);

			} else {
				winner_dialogue = "[Match draw]";
				show_winner();
				System.out.println("[Match Draw]");
			}

		}
	}


	private void r_is_choosed() {

		if(s_text.length()!=0) {

			Random value = new Random();
			int computer = value.nextInt(3);// a=c,b=p;
			if (computer == 0) {
				c_s_v = "scissors";

			} else if (computer == 1) {
				c_s_v = "paper";

			} else {
				c_s_v = "rock";
			}
			int player = 2;

			System.out.printf("Computer choose (%d) & %s choose (%d)" + "\n", computer, player_name, player);

			if (computer == 0 && player == 2) {
				winner_dialogue = "[The Winner is ".concat(player_name+"]");   /////[].......
				count_l_1.setText(String.valueOf(++player_count));
				show_winner();
				System.out.printf("[%s won]" + "\n", player_name);

			} else if (computer == 1 && player == 2) {
				winner_dialogue = "[The Winner is Computer]";
				count_l_2.setText(String.valueOf(++computer_count));
				show_winner();
				System.out.println("[computer won]");

			} else {
				winner_dialogue = "[Match Draw]";
				show_winner();
				System.out.println("[Match draw]");
			}

		}
	}

	private void show_winner() {

		count++;

			Alert a = new Alert(Alert.AlertType.INFORMATION);
			a.setTitle("Result");
			a.setHeaderText(player_name + "= " + p_s_v + "   &   " + "Computer= " + c_s_v);
			a.setContentText(winner_dialogue+"\n"+"Click (OK) for next round" );
			ButtonType o = new ButtonType("OK");
			ButtonType p=new ButtonType("exit game");
			a.getButtonTypes().setAll(o,p);
			Optional<ButtonType> h = a.showAndWait();
			if (h.isPresent() && h.get() == o) {

				if (cgm5) {
					if (count > 4) {
						select_winner();
					}
				}
			}else {
				Platform.exit();
				System.exit(0);
			}
	}

	public void reset_game(){
		 r_value=false;
		p_value=false;
		s_value=false;
		computer_count=0;
		player_count=0;
		name_l.setText("Player");
		count_l_1.setText("0");
	   	count_l_2.setText("0");
	   	text.setText("");
	   	cb.setValue("Choose Any One");
	   	count=0;
	}

	private void select_winner() {
	   	System.out.printf("The final score of computer: %d & %s: %d"+"\n",computer_count,player_name,player_count);

		if (computer_count>player_count)
		{
			computer_won();

		}else if(computer_count<player_count){

			player_won();

		}else{
			match_draw();
		}

	}

	private void match_draw() {

		Alert v=new Alert(Alert.AlertType.INFORMATION);
		v.setTitle("Final Result");
		v.setHeaderText(player_name+"= "+player_count+"   &  "+"Computer= "+computer_count+"\n"+"Series draw");
		v.setContentText("Want to play again ?");
		ButtonType b4=new ButtonType("yes");
		ButtonType b5=new ButtonType("no");
		v.getButtonTypes().setAll(b4,b5);
		Optional<ButtonType> click2 = v.showAndWait();
		if(click2.isPresent() && click2.get()==b4){
			reset_game();

		}else {
			Platform.exit();
			System.exit(0);
		}

		System.out.println("[Series Draw]");
	}

	private void player_won() {

		Alert v=new Alert(Alert.AlertType.INFORMATION);
		v.setTitle("Final Result");
		v.setHeaderText(player_name+"= "+player_count+"   &  "+"Computer= "+computer_count+"\n"+player_name+" won the series");
		v.setContentText("Want to play again ?");
		ButtonType b4=new ButtonType("yes");
		ButtonType b5=new ButtonType("no");
		v.getButtonTypes().setAll(b4,b5);
		Optional<ButtonType> click2 = v.showAndWait();
		if(click2.isPresent() && click2.get()==b4){
			reset_game();

		}else {
			Platform.exit();
			System.exit(0);
		}

		System.out.printf("[%s Won the Series]"+"\n",player_name);
	}

	private void computer_won() {

		Alert v=new Alert(Alert.AlertType.INFORMATION);
		v.setTitle("Final Result");
		v.setHeaderText(player_name+"= "+player_count+"   &   "+"Computer= "+computer_count+"\n"+"Computer won the series");
		v.setContentText("Want to play again ?");
		ButtonType b4=new ButtonType("yes");
		ButtonType b5=new ButtonType("no");
		v.getButtonTypes().setAll(b4,b5);
		Optional<ButtonType> click2 = v.showAndWait();
		if(click2.isPresent() && click2.get()==b4){
			reset_game();

		}else {
			Platform.exit();
			System.exit(0);
		}

		System.out.println("[copmuter won series]");
	}

}


