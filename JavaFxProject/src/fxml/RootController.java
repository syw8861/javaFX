package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RootController implements Initializable // 컨트롤러는 initializable 인터페이스를 구현해야함
{
	@FXML
	TextField textField; // fxml이랑 씬/컨트롤/텍스트필드 import
	@FXML
	Button btnOk;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		textField.setText("초기화합니다.");
		btnOk.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0)
			{

			}

		});

	}
}
