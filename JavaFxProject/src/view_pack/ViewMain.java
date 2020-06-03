package view_pack;
//ViewControl.fxml

//ViewController.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewMain extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("ViewControl.fxml"));
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		arg0.setTitle("뷰컨트롤");

	}
}
