package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.control.Slider;

public class BindingController implements Initializable
{
	@FXML TextArea txtArea1;
	@FXML TextArea txtArea2;
	@FXML Label label;
	@FXML Slider slider;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		slider.valueProperty().addListener(new ChangeListener<Number>()
		{

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
			{
				System.out.println(newValue.doubleValue());
				label.setFont(new Font(newValue.doubleValue()));	
			}
			
			
			
		});
//		txtArea2.textProperty().bind(txtArea1.textProperty());
		txtArea2.textProperty().bindBidirectional(txtArea1.textProperty());
//		Bindings.bindBidirectional(txtArea1.textProperty(), txtArea2.textProperty());
		//세개가 쓰이는 방식은 비슷한데 첫번째꺼는 1에다가 쓰면 2에 써지는거고
		//2번3번째꺼는 양방향 묶임임 서로 쓰면 서로한테 쓰임
	}
}
