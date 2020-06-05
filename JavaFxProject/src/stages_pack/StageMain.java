package stages_pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageMain extends Application
{
//Root.fxml
//Addform.fxml
//Chart.fxml
//StageController.java	

	
	@Override
	public void start(Stage arg0) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
//		FXMLLoader loader = new FXMLLoader();
//		Parent root = loader.load(getClass().getResource("Root.fxml"));
//		
		//controller에 stage값을 넘겨주는처리
//		Stagecontroller cont = loader.getController(); 
//		cont.setPrimaryStage(arg0);
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
