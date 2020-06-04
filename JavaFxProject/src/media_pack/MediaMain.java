package media_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//MediaControl.fxml
//Mediacontroller.java

public class MediaMain extends Application
{

	@Override
	public void start(Stage arg0) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("MediaControl.fxml"));
		Scene scene = new Scene(root);
		arg0.show();
		arg0.setScene(scene);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
