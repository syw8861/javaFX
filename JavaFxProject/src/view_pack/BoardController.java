package view_pack;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class BoardController implements Initializable
{
	Connection conn;
	@FXML
	TableView<Board> tableView;
	@FXML
	TextField textfield;
	@FXML
	TextField textfield2;
	@FXML
	TextArea textarea;
	@FXML
	ComboBox<String> combobox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			System.out.println("주소또는 아이디비번이 잘못됨");
		}

		ObservableList<Board> boardList = getBoardList();
//		boardList.add(new Board("test","1234","공개","2020/05/04","내용")); //이런식으로 DB에서 가져와서 보여줘야함 밑에 18번째줄 밑에꺼에
		// title column
		TableColumn<Board, String> tcTitle = new TableColumn<Board, String>();
		tcTitle.setCellValueFactory(new Callback<CellDataFeatures<Board, String>, ObservableValue<String>>()
		{

			@Override
			public ObservableValue<String> call(CellDataFeatures<Board, String> param)
			{
				return param.getValue().titleProperty();
			}
		});
		tcTitle.setText("제목");
		// exitDate //이거랑 위에 타이틀컬럼이랑 쓰는법 같음
		TableColumn<Board, String> tcExitDate = new TableColumn<>();
		tcExitDate.setCellValueFactory(new PropertyValueFactory<Board, String>("exitDate"));
		tcExitDate.setText("종료일");

		// 칼럼하고 테이블뷰하고 매칭시켜주는 작업 2개
		tableView.getColumns().add(tcTitle);
		tableView.getColumns().add(tcExitDate);

		tableView.setItems(boardList);

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Board>()
		{
			@Override
			public void changed(ObservableValue<? extends Board> observalbe, Board oldValue, Board newValue)
			{
				textfield.setText(newValue.getTitle());
				textfield2.setText(newValue.getExitDate());
				combobox.setValue(newValue.getPublicity());
				textarea.setText(newValue.getContent());
			}
		});
	}

	public ObservableList<Board> getBoardList()
	{
		ObservableList<Board> list = FXCollections.observableArrayList();

		String sql = "select title, publicity, exit_date, content from board2";
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
			{
				Board board = new Board(rs.getString("title"), null, rs.getString("publicity"),
						rs.getString("exit_date"), rs.getString("content"));
				list.add(board);
			}
			conn.prepareStatement(sql);
		} catch (SQLException e)
		{

			e.printStackTrace();
		}
		return list;
	}

}
