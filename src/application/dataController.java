package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class dataController implements Initializable {
	@FXML public ImageView image;
	@FXML public Button push;
	@FXML public TableView<TableData> mytable;
	@FXML private TableColumn<TableData, String> name;
	@FXML private TableColumn<TableData, String> nickname;
	@FXML private TableColumn<TableData, String> kind;
	ObservableList<TableData> list = FXCollections.observableArrayList(
			new TableData(new SimpleStringProperty("스폰지밥"), new SimpleStringProperty("스폰지죽"), new SimpleStringProperty("스폰지")),
			new TableData(new SimpleStringProperty("뚱이"), new SimpleStringProperty("땅딸이"), new SimpleStringProperty("불가사리")));

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.setCellValueFactory(cellData ->cellData.getValue().name());
		nickname.setCellValueFactory(cellData ->cellData.getValue().nickname());
		kind.setCellValueFactory(cellData ->cellData.getValue().kind());
		mytable.setItems(list);
		mytable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TableData>() {
			@Override
			public void changed(ObservableValue<? extends TableData> observable, TableData oldValue,
					TableData newValue) {

				TableData td = mytable.getSelectionModel().getSelectedItem();
				StringProperty name1 = td.name();
				Image img = new Image("/"+name1.get()+".png");
				image.setImage(img);
			}
		});
	}
	public void pushbutton() {
		try {
			Stage stage = new Stage();
			VBox root = FXMLLoader.<VBox>load(getClass().getResource("addbutton.fxml"));
			stage.setScene(new Scene(root,350,380));
			stage.setTitle("정보를 입력해주세요.");
			stage.showAndWait(); //자식창이 꺼질때까지 기다린 후 뒤에 코드를 실행
			input_data(DataModel.name, DataModel.nickname, DataModel.kind);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void input_data(String name, String nickname, String kind) {
		mytable.getItems().add(new TableData(new SimpleStringProperty(name),new SimpleStringProperty(nickname),new SimpleStringProperty(kind)));
	}
}
