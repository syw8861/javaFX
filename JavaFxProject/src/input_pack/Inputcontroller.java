package input_pack;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Inputcontroller implements Initializable
{
	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPassword;
	@FXML private ComboBox<String> comboPublic;
	@FXML private DatePicker dateExit;
	@FXML private TextArea txtContent;
	@FXML private Button btnReg;
	@FXML private Button btnCancal;
	
	Connection conn;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void handleBtnRegAction(ActionEvent e) 
	{
		if(txtTitle.getText()==null || txtTitle.getText().equals(""))
		{
			messageDialog("제목을 입력하세요.");
		}
		else if(txtPassword.getText() ==null|| txtPassword.getText().equals(""))
		{
			messageDialog("비밀번호를 입력하세요"); //messagedialog로 호출할꺼냐 팝업으로 호출할꺼냐
		}
		else if(comboPublic.getValue() == null||comboPublic.getValue().equals(""))
		{
			messageDialog("공개여부를 선택하세요");
		}
		else if(dateExit.getValue()==null|| dateExit.getValue().equals(""))
		{
			messageDialog("종료일을 입력하세요");
		}
		else if(txtContent.getText()==null||txtContent.getText().equals(""))
		{
			messagePopup("내용을 입력하세요.");
		}
		else
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String sql = "insert into board2(title, password, publicity, exit_date, content)"
					+"values(?,?,?,?,?)";
			try
			{
				PreparedStatement pstmt = conn.prepareCall(sql);
				pstmt.setString(1, txtTitle.getText());
				pstmt.setString(2, txtPassword.getText());
				pstmt.setString(3, comboPublic.getValue());
				pstmt.setString(4, dateExit.getValue().format(formatter));
				pstmt.setString(5, txtContent.getText());
				
				int r = pstmt.executeUpdate();
				System.out.println(r + "건 입력됨.");
				
			} catch (SQLException e1)
			{
				e1.printStackTrace();
				//디비입력 해주기-->Connection, PreparedStatement, executeUpdate();필요
				//connection 연결객체
			}
			//각 필드 초기화 작업.
			txtTitle.setText(null);
			txtPassword.setText(null);
			comboPublic.setValue("공개");
			dateExit.setValue(null);
			txtContent.setText(null);
		}
		
		
		String title = txtTitle.getText();
		System.out.println("title: "+ title);
		
		String strPublic = comboPublic.getValue();
		System.out.println("public: " + strPublic);
		
		LocalDate localDate = dateExit.getValue();
		if(localDate != null) {
			System.out.println("dateExit: " +  localDate.toString());
		}
		
	String content = txtContent.getText();
	System.out.println("content: " + content);
	
	}
	
	public void handleBtnCancelAction(ActionEvent e) 
	{
		Platform.exit();
	}
	
	public void messageDialog(String message) //다이얼로그창 띄워주기 팝업창 대신
	{
		Stage customStage = new Stage(StageStyle.UTILITY);
		customStage.initModality(Modality.WINDOW_MODAL);
		customStage.initOwner(btnReg.getScene().getWindow());
		customStage.setTitle("오류");
				
		AnchorPane ap = new AnchorPane();
		ap.setPrefSize(400, 150);
		
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("/icons/dialog-error.png"));
		imageView.setFitWidth(50);
		imageView.setPreserveRatio(true); //정사각형 형태의 비율을 유지해주는거 가로가 늘어나면 세로도 늘려주는 형식 
		imageView.setLayoutX(15);
		imageView.setLayoutY(15);
		
		
		Button button = new Button("확인");
		button.setLayoutX(336);
		button.setLayoutY(104);
		button.setOnAction(e -> customStage.close());//람다식 포현 ActionEvent(
		
		
		Label label = new Label(message); //label.settext(message)넣어줘도 상관없음 지금은 생성자 기본 타입에 맞춰서 넣어줌
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefHeight(15);
		label.setPrefWidth(290);
		
		ap.getChildren().add(imageView);
		ap.getChildren().add(button);
		ap.getChildren().add(label);
		
		Scene scene = new Scene(ap);
		customStage.setScene(scene);
		customStage.show();
				
		
	}
	
	public void messagePopup(String message)
	{
		//컨테이너(HBox) 생성
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20;");
		hbox.setAlignment(Pos.CENTER);
	
		//컨테이너 안에 담길 컨트롤(imageView)
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("/icons/dialog-info.png"));
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		//컨테이너 안에 담길 컨트롤(Label)
		Label label = new Label();
		HBox.setMargin(label, new Insets(0,5,0,5));
		label.setText(message);
		label.setStyle("-fx-text-fill:white;"); //라벨 텍스트색 변경
		// 컨테이너에 컨트롤 담기. add를 써서
		hbox.getChildren().add(imageView);
		hbox.getChildren().add(label);
		//팝업창 생성
		Popup popup = new Popup();
		//컨테이너를 담아서(add.hbox) 팝업 호출
		popup.getContent().add(hbox);
		popup.setAutoHide(true);//모달리스 윈도우는 새로운 창이 뜨더라도 뒤에있는 메인창을 건드릴수있게 하는거임
		popup.show(btnReg.getScene().getWindow());//버튼(btnReg)가 소속되어있는 윈도우를 가지고 오는법/ 팝업창을 윈도우에 뛰우기 위해서 썻음
		
	}
}
