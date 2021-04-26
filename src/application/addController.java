package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addController implements Initializable {
	@FXML
	public TextField nameText;
	@FXML
	public TextField nicknameText;
	@FXML
	public ComboBox<String> combo;
	@FXML
	public Button Yesbtn;
	@FXML
	private Button Nobtn;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	public void nobutton() {
		Stage stage = (Stage) Nobtn.getScene().getWindow(); // Ã¢ ´Ý±â
		stage.close();
	}

	public void yesbutton() {
		DataModel.name = nameText.getText();
		DataModel.nickname = nicknameText.getText();
		DataModel.kind = (String)combo.getValue();

		Stage stage = (Stage) Yesbtn.getScene().getWindow(); // Ã¢ ´Ý±â
		stage.close();
	}
}

