package chart_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable
{
	@FXML
	PieChart pieChart;
	@FXML
	BarChart<String, Integer> barChart;
	@FXML
	AreaChart<String, Integer> areaChart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		pieChart.setData(FXCollections.observableArrayList(new PieChart.Data("AWT", 10.0),
													       new PieChart.Data("Swing", 30.0),
													       new PieChart.Data("SWT", 25.0),
													       new PieChart.Data("JavaFX", 35.0)));

		XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
		series1.setName("gg");
		series1.setData(FXCollections.observableArrayList(new XYChart.Data<String, Integer>("2015", 70),
														  new XYChart.Data<String, Integer>("2016", 40),
														  new XYChart.Data<String, Integer>("2017", 50),
														  new XYChart.Data<String, Integer>("2085", 60)));
	
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
		series2.setName("ss");
		series2.setData(FXCollections.observableArrayList(new XYChart.Data<String, Integer>("2063", 40),
														  new XYChart.Data<String, Integer>("2016", 10),
														  new XYChart.Data<String, Integer>("2123", 20),
														  new XYChart.Data<String, Integer>("2085", 30)));
		barChart.setData(FXCollections.observableArrayList(series2,series1));
		
		
		XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
		series3.setName("ff");
		series3.setData(FXCollections.observableArrayList(new XYChart.Data<String, Integer>("2063", 40),
														  new XYChart.Data<String, Integer>("2016", 10),
														  new XYChart.Data<String, Integer>("2123", 20),
														  new XYChart.Data<String, Integer>("2085", 30)));
		areaChart.setData(FXCollections.observableArrayList(series3));
	}

}
