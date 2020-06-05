package stages_pack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stagecontroller implements Initializable
{
	
	@FXML
	TableView<Student> tableView;
	@FXML
	Button btnAdd, btnChart;

//	Stage primaryStage; // main에서 스테이지를 호출해서 쓰기위해서 선언해줬음 필드를 밑에 메소드도
//	void setPrimaryStage(Stage primaryStage)
//	{
//		this.primaryStage = primaryStage;
//	}
	
	ObservableList<Student> scores; // 버튼차트액션 애드액션에 다 써야해서 밖에다가 선언해줬음
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		scores = FXCollections.observableArrayList(); //scores인스턴스 초기화
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				buttonAddAction(arg0);

			}
		});

		btnChart.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				buttonChartAction(arg0);
			}
		});

		// Student에서 적어준거랑 tableView랑 매칭시켜주기
		TableColumn<Student, ?> tcName = tableView.getColumns().get(0);
		tcName.setCellValueFactory(new PropertyValueFactory("name"));
		TableColumn<Student, ?> tcKorean = tableView.getColumns().get(1);
		tcKorean.setCellValueFactory(new PropertyValueFactory("korean"));
		TableColumn<Student, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("math"));
		TableColumn<Student, ?> tcEnglish = tableView.getColumns().get(3);
		tcEnglish.setCellValueFactory(new PropertyValueFactory("english"));

		tableView.setItems(scores);
	}

	public void buttonAddAction(ActionEvent ae)
	{
		Stage addStage = new Stage(StageStyle.UTILITY); // 유틸리티라는 유형의스테이지를 addstage에 적용시키겠다.
		addStage.initModality(Modality.WINDOW_MODAL); // 모달로 만들면 이 창을 닫기전엔 다른 창은 못씀
		addStage.initOwner(btnAdd.getScene().getWindow());// addstage를 어디다가 달꺼냐 btnadd가 있는 씬에 그씬이 속한 윈도우에 달겠다

		try
		{
			Parent parent = FXMLLoader.load(getClass().getResource("AddForm.fxml")); // 씬이 있어야 볼수있으니 ADDform으로 만들어준 씬을
																						// 가져와서 쓴다
			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();
			// parent <<-는 지금 Boarderpane 컨테이너임
			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(new EventHandler<ActionEvent>()
			{ // add버튼 눌렀을때 이벤트 정의해주기

				@Override
				public void handle(ActionEvent arg0)
				{
					TextField txtName = (TextField) parent.lookup("#txtName"); // lookup은 아이디값을 읽어오는법
					TextField txtKorean = (TextField) parent.lookup("#txtKorean");
					TextField txtMath = (TextField) parent.lookup("#txtMath");
					TextField txtEnglish = (TextField) parent.lookup("#txtEnglish");
					Student student = new Student(txtName.getText(),   
												Integer.parseInt(txtKorean.getText()),  //int 
												Integer.parseInt(txtMath.getText()),
												Integer.parseInt(txtEnglish.getText()));
												scores.add(student);
												addStage.close();
												
				}

			});

		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("buttonAddAction Scene 에러에러에러에ㅓㄹ");
		}
	}

	public void buttonChartAction(ActionEvent ae)
	{
		Stage chartStage = new Stage(StageStyle.UTILITY);
		chartStage.initModality(Modality.WINDOW_MODAL);
		chartStage.initOwner(btnChart.getScene().getWindow()); //이렇게 해도 되고 아니면 메인에서 해당컨트롤러 가져와서 컨트롤러가 속해있는 페이지를 던져준다? Main보자
		
		try
		{
			Parent parent = FXMLLoader.load(getClass().getResource("ScoreChart.fxml"));
			BarChart barChart = (BarChart) parent.lookup("#barChart");
			//국어
			XYChart.Series<String, Integer> seriesKorean = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasKorean = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {
				datasKorean.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getKorean()));
				//이름 , 국어점수가 나오게 할려고
			}
			seriesKorean.setData(datasKorean);
			seriesKorean.setName("국어");
			
			//수학
			XYChart.Series<String, Integer> seriesMath = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasMath = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {	
				datasMath.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getMath()));
				//이름 , 국어점수가 나오게 할려고
			}
			seriesMath.setData(datasMath);
			seriesMath.setName("수학");
			
			//영어
			XYChart.Series<String, Integer> seriesEnglish = new XYChart.Series<String, Integer>();
			ObservableList<XYChart.Data<String, Integer>> datasEnglish = FXCollections.observableArrayList();
			for(int i=0; i<scores.size(); i++) {	
				datasEnglish.add(new XYChart.Data(scores.get(i).getName(), scores.get(i).getEnglish()));
				//이름 , 국어점수가 나오게 할려고
			}
			seriesEnglish.setData(datasEnglish);
			seriesEnglish.setName("영어");
			
			barChart.setData(FXCollections.observableArrayList(seriesKorean, seriesMath, seriesEnglish));
			
//			seriesKorean.setData(XYChart.Data<String, Integer>());
//			barChart.setData(series1, series2);
			
			Scene scene = new Scene(parent);
			chartStage.setScene(scene);
			chartStage.setResizable(false);
			chartStage.show();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
