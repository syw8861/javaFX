package fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//Root.fxml 호출하기~
public class AppRoot extends Application
{

	public static void main(String[] args)
	{
		launch(args);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		//Parent라는 객체는 모든 컨테이너의 상위임
		// fxmlloader라는 객체는 load라는 메소드르르 활용해서 (객체를가져오겠다 / 리소스(~)를) 
		// Root.fxml이 지금 경로보다 위에 있으면 ../~~~/Root.fxml 이런식으로 써주면됨
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Fxml sample");
		
	}
}
