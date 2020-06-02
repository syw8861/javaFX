package button_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonController implements Initializable
{

	@FXML
	private CheckBox checkBox1;
	@FXML
	private CheckBox checkBox2;
	@FXML
	private ImageView checkImageView;
	@FXML
	private ImageView radioImageView;
	@FXML
	private Button btnExit;
	@FXML
	private ToggleGroup group;
	@FXML
	RadioButton rad1;
	@FXML
	RadioButton rad2;
	@FXML
	RadioButton rad3;

	@Override

	public void initialize(URL location, ResourceBundle resources)
	{
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
		{ // selectedToggleProperty()라는 속성을 가지고와서 addListener변경될때마다 이벤트를 걸겠다.
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)
			{
				Image image = new Image(
						getClass().getResource("/images/" + newValue.getUserData().toString() + ".png").toString());
				radioImageView.setImage(image);
			}
		});

		
		checkBox2.setOnAction(new EventHandler<ActionEvent>()
		{//밑에 체크박스에 따로 onaction 메소드를 사용하지않고 바로 여기서 불러서 사용하는법 밑이랑 같음
			@Override
			public void handle(ActionEvent event)
			{
				handleChkAction(event);
			}
		});
	}

	
	public void handleChkAction(ActionEvent e)
	{
		String imageName = "";
		if (checkBox1.isSelected() && checkBox2.isSelected())
		{
			imageName = "geek-glasses-hair.gif";
		} else if (checkBox2.isSelected())
		{
			imageName = "geek-hair.gif";
		} else if (checkBox1.isSelected())
		{
			imageName = "geek-glasses.gif";
		} else
		{
			imageName = "geek.gif";
		}
		checkImageView.setImage(new Image("/images/" + imageName));
	}

	public void handleBtnExitAction(ActionEvent e)
	{
		Platform.exit();
	}

}
