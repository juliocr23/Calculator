/**
 * Author: Julio Rosario
 * Last Update: 12.22.17
 * Purpose: The purpose of this program is to create a basic calculator that 
 *          perform basic calculation such as addition,subtraction,multiplication
 *          and division, as well as unary operation such as cosine,sine and tangent.
 */

package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class Main extends Application {
	
	@FXML
	private Label display;
	private boolean userIsTyping;
	private CalculatorBrain brain;
	
	
	/*******************************
	 * The initialize method 
	 * initialize the data
	 * of this class.
	 *********************************/
	public void initialize() {
		userIsTyping = false;
		brain = new CalculatorBrain();
	}
	
	/*********************************************
	 * The pressedDigit method receives a
	 * @param event which is call whenever the user
	 * pressed a digit.
	 **********************************************/
	public void pressedDigit(ActionEvent event) {
		Button digit =(Button) event.getSource();
		
		if(!userIsTyping) {
			display.setText(digit.getText());
		}
		else{
			String tmp = display.getText();
			tmp += digit.getText();
			display.setText(tmp);
		}
		
		userIsTyping = true;
	}
	
	/*******************************************
	 * The performCalculation method receives 
	 * @param event is an operator, this method
	 * is triggered every time the user pressed
	 * one of the operators of the calculator.
	 ********************************************/
	public void performCalculation(ActionEvent event) {
		
		//Get the operator button pressed by the user 
		//and set operator.
		Button operator = (Button)event.getSource();
		double number = Double.parseDouble(display.getText());
		
		//If the first operand has not been set operand
		if(!brain.set()) 
			brain.setOperand(number);
		
		if(userIsTyping && brain.set())
			//brain.performUnaryOperation();
			brain.performBinaryOperation(number);
	
		//Set operator and if there is a unary operation do it
		brain.setOperator(operator.getText());
		brain.performUnaryOperation();
		
		//Display result
		display.setText(brain.getResult());
		userIsTyping = false;
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		initialize();
		
		//Load the FXML file
		Parent parent = FXMLLoader.load(
				 getClass().getResource("CalculatorView.fxml"));
		
		//Build the scene graph
		Scene scene = new Scene(parent);
		
		//Display the window using the scene graph
	    stage.setTitle("Calculator");
	    stage.setScene(scene);
	    stage.show();
	}
	
	public static void main(String[]args) {
		
		//Launch the application
		launch(args);
	}
	

}
