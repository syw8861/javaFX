package input_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//fxml: InputControl.fxml
//Ctrler : InputController.java
public class InputMain extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		AnchorPane anchorpane = FXMLLoader.load(getClass().getResource("InputControl.fxml"));
		Scene scene = new Scene(anchorpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}

}
