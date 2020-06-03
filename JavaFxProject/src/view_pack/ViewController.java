package view_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewController implements Initializable
{
	@FXML ListView<String> listView;
	@FXML TableView<Phone> tableView;
	@FXML ImageView imageView;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		ObservableList<String> list = FXCollections.observableArrayList("GalaxyS1","GalaxyS2","GalaxyS3");//밑에 list.add로 넣어주는거랑 같음
		list.add("GalaxyS4");
		list.add("GalaxyS5");
		list.add("GalaxyS6");
		listView.setItems(list); 
		
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() 
		
		
		{
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue)
			{
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue()); //scrollTo라는 메소드를써서 왼쪽에서 5,6을 누르더라도 오른쪽 창에서 바로 그 위치로 이동하도록 해주는메소드~
			}
		});
		
		tableView.setItems(FXCollections.observableArrayList
				(new Phone("GalaxyS1", "phone01.png"),
				new Phone("GalaxyS2", "phone02.png"),
				new Phone("GalaxyS3", "phone03.png"),
				new Phone("GalaxyS4", "phone04.png"),
				new Phone("GalaxyS5", "phone05.png"),
				new Phone("GalaxyS6", "phone06.png")
				)); 
		TableColumn<Phone, ?> tcSmartPhone = tableView.getColumns().get(0); //이거랑 밑에꺼가 칼럼이랑 스마트폰필드랑 연결해주는거
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		
//		tableView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("smartPhone")); //위에꺼랑 구조는 똑같음
		
		TableColumn<Phone, ?> tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() 
		{
			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue)
			{
				imageView.setImage(new Image("/images/"+ newValue.getImage()));
			}
		});
		
		imageView.setImage(new Image("/images/phone01.png"));
	}
	public void handleBtnOkAction(ActionEvent e)
	{
		
	}
	public void handleBtnCancelAction(ActionEvent e)
	{
		Platform.exit();
	}
}
