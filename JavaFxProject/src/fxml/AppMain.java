package fxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application
{
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	
	@Override
	public void init() throws Exception
	{
		super.init();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		HBox root = new HBox(); //컨테이너 안에 컨테이너가 올 수있는데 root컨테이너가 최상위컨테이너
		////hbox는 컨트롤들을 가로로 쭉 나열하는거 Bbox는 세로로 나열
		root.setPadding(new Insets(10));  
		root.setSpacing(10);
		
		TextField textfield = new TextField();
		textfield.setPrefWidth(300);
		
		Button button = new Button();
		button.setText("확인");
		
		ObservableList list = root.getChildren();
		list.add(textfield);
		list.add(button);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception
	{
		super.stop();
	}

}
