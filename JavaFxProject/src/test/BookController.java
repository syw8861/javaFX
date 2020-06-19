package test;

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

public class BookController implements Initializable
{
	@FXML
	TableView<Book> tableView;
	@FXML
	Button btnAdd, btnChart;
	ObservableList<Book> scores;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		scores = FXCollections.observableArrayList();

		btnAdd.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				buttonAddaction(arg0);

			}
		});

		btnChart.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				buttonChartAction(event);
			}

		});
		TableColumn<Book, ?> booka = tableView.getColumns().get(0);
		booka.setCellValueFactory(new PropertyValueFactory("booka"));
		TableColumn<Book, ?> bookb = tableView.getColumns().get(1);
		bookb.setCellValueFactory(new PropertyValueFactory("bookb"));
		TableColumn<Book, ?> bookc = tableView.getColumns().get(2);
		bookc.setCellValueFactory(new PropertyValueFactory("bookc"));
		TableColumn<Book, ?> bookd = tableView.getColumns().get(3);
		bookd.setCellValueFactory(new PropertyValueFactory("bookd"));
		TableColumn<Book, ?> booke = tableView.getColumns().get(4);
		booke.setCellValueFactory(new PropertyValueFactory("booke"));
		
		tableView.setItems(scores);
	
	}
	//tableView.getSelectionModel(().selecrtdItemProperty().getValue().getBookb().
	public void buttonAddaction(ActionEvent aa)
	{
		Stage addStage = new Stage(StageStyle.UTILITY);
		addStage.initModality(Modality.WINDOW_MODAL);
		addStage.initOwner(btnAdd.getScene().getWindow());

		try
		{
			Parent parent = FXMLLoader.load(getClass().getResource("AddBook.fxml"));

			Scene scene = new Scene(parent);
			addStage.setScene(scene);
			addStage.setResizable(false);
			addStage.show();
			
			Button btnCancel = (Button) parent.lookup("#btnCancel");
			btnCancel.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0)
				{
					addStage.close();
				}
				
			});
			Button btnAddAdd = (Button) parent.lookup("#btnAddAdd");
			btnAddAdd.setOnAction(new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent arg0)
				{
					TextField booka = (TextField) parent.lookup("#booka");
					TextField bookb = (TextField) parent.lookup("#bookb");
					TextField bookc = (TextField) parent.lookup("#bookc");
					TextField bookd = (TextField) parent.lookup("#bookd");
					TextField booke = (TextField) parent.lookup("#booke");

					Book book = new Book(booka.getText(), bookb.getText(), bookc.getText(),
							Integer.parseInt(bookd.getText()), Integer.parseInt(booke.getText()));
					scores.add(book);
					addStage.close();
				}

			});
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	public void buttonChartAction(ActionEvent ff)
	{
		Stage chartStage = new Stage(StageStyle.UTILITY);
		chartStage.initModality(Modality.WINDOW_MODAL);
		chartStage.initOwner(btnChart.getScene().getWindow());
		
		try {
		Parent parent = FXMLLoader.load(getClass().getResource("BookChart.fxml"));
		BarChart barChart = (BarChart) parent.lookup("#barChart");
		
		Button btnCancel2 = (Button) parent.lookup("#btnCancel2");
		btnCancel2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0)
			{
				chartStage.close();
			}
			
		});
		//도서코드 기준으로 단가비교
		XYChart.Series<String, Integer> seriesBooka = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> datasBooka = FXCollections.observableArrayList();
		for(int i=0; i<scores.size(); i++)
		{
			datasBooka.add(new XYChart.Data(scores.get(i).getBookb(), scores.get(i).getBookd()));
		}
		seriesBooka.setData(datasBooka);
		seriesBooka.setName("단가");
		
		//도서코드 기준으로 판매량비교
		XYChart.Series<String, Integer> seriesBookb = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> datasBookb = FXCollections.observableArrayList();
		for(int i=0; i<scores.size(); i++)
		{
			datasBookb.add(new XYChart.Data(scores.get(i).getBookb(), scores.get(i).getBooke()));
		}
		seriesBookb.setData(datasBookb);
		seriesBookb.setName("판매량");
		
		barChart.setData(FXCollections.observableArrayList(seriesBooka, seriesBookb));
		
		Scene scene = new Scene(parent);
		chartStage.setScene(scene);
		chartStage.setResizable(false);
		chartStage.show();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
