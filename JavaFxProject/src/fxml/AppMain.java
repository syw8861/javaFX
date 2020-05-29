package fxml;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
		HBox root = new HBox(); // 컨테이너 안에 컨테이너가 올 수있는데 root컨테이너가 최상위컨테이너
		//// hbox는 컨트롤들을 가로로 쭉 나열하는거 Bbox는 세로로 나열
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setPrefSize(500, 300);

		TextField textfield = new TextField();
		textfield.setPrefWidth(300);
		textfield.setPrefSize(300, 20);

		Button button1 = new Button();
		button1.setText("확인");
		button1.setPrefSize(110, 20);
		button1.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) // 매개값변수이름은 아무거나 해줘도 됌
			{
				textfield.setText("확인을 눌렀습니다.");

			}

		});

		Button button2 = new Button();
		button2.setText("취소");
		button2.setPrefSize(110, 20);
		button2.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				textfield.setText(null);
			}

		});
		ObservableList list = root.getChildren();
		list.add(textfield);
		list.add(button1);
		list.add(button2);

		Scene scene = new Scene(root);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
		{

			@Override
			public void handle(WindowEvent event)
			{
				System.out.println(event);
			}

		});
	}

	@Override
	public void stop() throws Exception
	{
		super.stop();
	}

}
