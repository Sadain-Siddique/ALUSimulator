package application;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.FadeTransition;

import javafx.animation.Interpolator;

import javafx.animation.RotateTransition;

import javafx.animation.ScaleTransition;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Scene2Controller extends Calculations implements Initializable {
	private Stage stage;
	 private Scene scene;
	 private Parent root;
	 
	 @FXML
	Label num1Label;
	 
	 @FXML
	Label num2Label;
	 
	 @FXML
	Label outputLabel;
	 
	 @FXML 
	 private ImageView hongIcon;
	 
	 @Override
	 public void initialize(URL arg0, ResourceBundle arg1) {	 
		 RotateTransition rotate = new RotateTransition();

		  rotate.setNode(hongIcon);

		  rotate.setDuration(Duration.millis(1300));

		  rotate.setCycleCount(TranslateTransition.INDEFINITE);

		  rotate.setInterpolator(Interpolator.LINEAR);

		  rotate.setByAngle(360);

		  rotate.setAxis(Rotate.Y_AXIS);

		  rotate.play();



	 }
	 
	 public void switchToScene1(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
		

	 public void displayNum(int num1, int num2, String operator) {
	   
		 Calculations alu = new Calculations();
		 
		 num1Label.setText("8 bit binary of " + num1 + ": " + alu.decimalToBinary(num1) );
		 
		 num2Label.setText("8 bit binary of " + num2 + ": " + alu.decimalToBinary(num2) );
		 
		 switch (operator) {
		 
			 case "Addition" :
			 outputLabel.setText("Addition Results: " + alu.calculateNum(num1, num2, operator));
			 break;
			 
			 case "Subtraction" :
			 outputLabel.setText("Subtraction Results: " + alu.calculateNum(num1, num2, operator));
			 break;
			 
			 case "Comparison" :
			 outputLabel.setText("Comparison Results: " + alu.calculateNum(num1, num2, operator));
			 break;
			 
			 default:
			 outputLabel.setText("Invalid operator");
		 
	 }
	 
	 } 	
	 
	  

	 
	/* public void displayNum(int num1, int num2, String operator) { 
		 
		 String registerA;
		 String registerB;
		 
		 
		 if (num1 < 0 && num2 < 0) {
			    registerA = toBinary(num1);
			    registerB = toBinary(num2);
			    num1Label.setText("8 bit binary of " + num1 + ": -" + registerA);
			    num2Label.setText("8 bit binary of " + num2 + ": -" + registerB);
			    if (operator.equals("Addition")) {
			        String result = add(registerA, registerB);
			        outputLabel.setText("Your added number is " + result);
			    } else if (operator.equals("Subtraction")) {
			        String result = subtract(registerA, registerB);
			        outputLabel.setText("Your subtracted number is " + result);
			    } else if (operator.equals("Comparison")) {
			        if (num1 == num2) {
			            outputLabel.setText("Numbers are equal!");          
			        } else {
			            outputLabel.setText("Numbers are not equal!");
			        }
		 	}
		 	}
	 
		 else if (num1 < 0) {
		 		 registerA = toBinary(num1);
				 registerB = toBinary(num2);
				 num1Label.setText("8 bit binary of " + num1 + ": -" + registerA);
				 num2Label.setText("8 bit binary of " + num2 + ": " + registerB);
				    if (operator.equals("Addition")) {
				        String result = add(registerA, registerB);
				        outputLabel.setText("Your added number is " + result);
				    } else if (operator.equals("Subtraction")) {
				        String result = subtract(registerA, registerB);
				        outputLabel.setText("Your subtracted number is " + result);
				    } else if (operator.equals("Comparison")) {
				        if (num1 == num2) {
				            outputLabel.setText("Numbers are equal!");          
				        } else {
				            outputLabel.setText("Numbers are not equal!");
				        }
				    
		 	}
		 	}

		 	 
		 	
		 	else if (num2 < 0) {
			    registerB = toBinary(num2);
			    registerA = toBinary(num1);
			    num1Label.setText("8 bit binary of " + num1 + ": " + registerA);
			    num2Label.setText("8 bit binary of " + num2 + ": -" + registerB);
			    if (operator.equals("Addition")) {
			        String result = add(registerA, registerB);
			        outputLabel.setText("Your added number is " + result);
			    } else if (operator.equals("Subtraction")) {
			        String result = subtract(registerA, registerB);
			        outputLabel.setText("Your subtracted number is " + result);
			    } else if (operator.equals("Comparison")) {
			        if (num1 == num2) {
			            outputLabel.setText("Numbers are equal!");          
			        } else {
			            outputLabel.setText("Numbers are not equal!");
			        }
		 	}
		 	}
		 	
		 	else {
		 	 registerA = toBinary(num1);
		     registerB = toBinary(num2);

		    num1Label.setText("8 bit binary of " + num1 + ": " + registerA);
		    num2Label.setText("8 bit binary of " + num2 + ": " + registerB);

		    // Perform the requested operation
		    if (operator.equals("Addition")) {
		        String result = add(registerA, registerB);
		        outputLabel.setText("Your added number is " + result);
		    } else if (operator.equals("Subtraction")) {
		        String result = subtract(registerA, registerB);
		        outputLabel.setText("Your subtracted number is " + result);
		    } else if (operator.equals("Comparison")) {
		        if (num1 == num2) {
		            outputLabel.setText("Numbers are equal!");          
		        } else {
		            outputLabel.setText("Numbers are not equal!");
		        }
		    } 
		}
	 }
	 
		// Helper method to convert a decimal number to 8-bit binary
		public static String toBinary(int decimal) {
		    String binary = Integer.toBinaryString(decimal);
		    if (decimal < 0) {
		        binary = twosComplement(binary);
		    }
		    while (binary.length() < 8) {
		        binary = "0" + binary;
		    }
		    return binary;
		}

		// Helper method to convert a binary number from unsigned to two's complement form
		public static String twosComplement(String binary) {
		    String inverted = "";
		    for (int i = 0; i < binary.length(); i++) {
		        if (binary.charAt(i) == '0') {
		            inverted += "1";
		        } else {
		            inverted += "0";
		        }
		    }
		    int decimal = Integer.parseInt(inverted, 2) + 1;
		    String twosComplement = Integer.toBinaryString(decimal);
		    while (twosComplement.length() < 8) {
		        twosComplement = "0" + twosComplement;
		    }
		    return twosComplement;
		}

		// Helper method to perform binary addition
		public static String add(String binary1, String binary2) {
		    String result = "";
		    int carry = 0;
		    for (int i = 7; i >= 0; i--) {
		        int bit1 = binary1.charAt(i) - '0';
		        int bit2 = binary2.charAt(i) - '0';
		        int sum = bit1 + bit2 + carry;
		        if (sum > 1) {
		            carry = 1;
		            result = (sum % 2) + result;
		        } else {
		            carry = 0;
		            result = sum + result;
		        }
		    }
		    if (carry == 1) {
		        result = "Overflow occurred!";
		    }
		    return result;
		}

		public static String subtract(String binary1, String binary2) {
			binary2 = twosComplement(binary2);
			return add(binary1, binary2);
		
		}
		*/	
		}
