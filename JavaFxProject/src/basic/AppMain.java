package basic;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class AppMain extends Application
{
	public static void main(String[] args) //실행0번
	{
		Application.launch(args); // 어플리케이션 클래스가 가지고있는 처리순서를 따라서 런치가 처리순서를 따라서 실행해준다. 
	}

	
	public AppMain() //생성자 호출~/실행1번 /
	{
		System.out.println(Thread.currentThread().getName()+ " : AppMain() 실행.");
	}

	@Override
	public void init() throws Exception //실행2번
	{
		super.init();
		System.out.println(Thread.currentThread().getName()+ " : init() 실행.");
	}

	@Override
	public void start(Stage primaryStage) throws Exception //실행3번 //start메소드가 stage를 호출
	{
		
		VBox root = new VBox();//컨테이너 생성  //vBox는 수직으로 쭉 정렬함 그래서 밑에처럼 위치를 직접 선정해줘야함
		root.setPrefWidth(350); //컨테이너 넓이 
		root.setPrefHeight(150); // 컨테이너 높이
		root.setAlignment(Pos.CENTER); //컨테이너의 위치 선정
		root.setSpacing(20); //컨트롤 사이 간격주기
		
		Label label = new Label(); //라벨 생성/javafx.scene.control import
		label.setText("Hell, JavaFx"); //라벨에다가 글 담아줄땐 setText
		label.setFont(new Font(50)); //매게값으로는 폰트클래스가 와야함
		
		Button button = new Button();//버튼생성 javafx.scene.control import
		button.setText("확인");
		
//		button.setOnAction(event -> Platform.exit()); //바로 밑에꺼를 람다식으로 표현했을때
		button.setOnAction(new EventHandler<ActionEvent>() //확인을 눌렀을때 이벤트를 주기  / eventhandler는 T extends Event 한마디로
//				이벤트를 상속받는 T<것만 받겠다.
		{
			@Override
			public void handle(ActionEvent arg0)
			{
				Platform.exit();
			}
		});
		
		
		
		root.getChildren().add(label); //루트 컨테이너에 add를 써서 라벨을 붙여주기
		root.getChildren().add(button); //루트 컨테이너에 add를 써서 버튼을 붙여주기
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene); //primaryStage 스테이지에 setScene써서 씬(root) 붙여주기
		
		primaryStage.show(); //stage클래스가 가지고 있는 윈도우를 띄우는
		System.out.println(Thread.currentThread().getName()+ " : start() 실행.");
		
	}
	

	@Override
	public void stop() throws Exception //실행4번   스테이지가 닫길때 실행한다 (start메소드에서 이벤트를 줘서 닫던 그냥 닫던)
	{
		super.stop();
		System.out.println(Thread.currentThread().getName()+ " : stop() 실행.");
	}
	
	
}
