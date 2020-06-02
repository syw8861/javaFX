package button_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ButtonMain extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		BorderPane border = FXMLLoader.load(getClass().getResource("ButtonControl.fxml"));
		Scene scene = new Scene(border);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
