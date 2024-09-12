package application;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Scene1Controller implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label errorLabel;

	@FXML
	private JFXTextField firstNumField;
	
	@FXML
	private JFXTextField secondNumField;
	
	@FXML
	private JFXComboBox<String> comboBox;
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
		comboBox.setItems(FXCollections.observableArrayList("Addition", "Subtraction", "Comparison"));
		comboBox.setStyle("-fx-font: 17px \"Serif\";");
	}
	
	
	public void switchtoScene2(ActionEvent event) throws IOException {

		try {
		int firstNum = Integer.parseInt(firstNumField.getText());
		int secondNum = Integer.parseInt(secondNumField.getText());
		String operator = comboBox.getSelectionModel().getSelectedItem();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));	
		root = loader.load();	

		Scene2Controller scene2Controller = loader.getController();
		scene2Controller.displayNum(firstNum, secondNum, operator);	

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		
		catch (NumberFormatException e) {
			errorLabel.setTextFill(Color.RED);
			errorLabel.setFont(Font.font("Helvetica", 31));
			errorLabel.setText("Enter only numbers please!");
		}
		
		catch (IndexOutOfBoundsException e) {
			errorLabel.setText("Max value for number: 255!");
		}
		
		catch (Exception e) {
			errorLabel.setText("Choose a comparator!");
		}
	}
	
}
