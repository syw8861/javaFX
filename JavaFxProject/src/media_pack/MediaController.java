package media_pack;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MediaController implements Initializable
{
	@FXML
	ImageView imageView;
	@FXML
	MediaView mediaView;
	@FXML
	Button btnPlay, btnStop, btnPause;
	@FXML
	Label labelTime;
	@FXML
	Slider sliderVolume;
	@FXML
	ProgressIndicator progressIndicator;
	@FXML
	ProgressBar progessBar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		Media media = new Media(getClass().getResource("/media/video.mp4").toString()); // Media는 스트링타입으로 매개값이 들어가야해서
																						// tostring으로 바꿔줌
		MediaPlayer player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		
		player.setOnReady(new Runnable() { //레디상태일때 run에 내용적기

			@Override
			public void run()
			{
				btnPlay.setDisable(false); //false일때 enable상태임
				btnStop.setDisable(true);
				btnPause.setDisable(true);
				
				player.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
							Duration newValue)
					{
						double progress = player.getCurrentTime().toSeconds() / player.getTotalDuration().toSeconds();
						progessBar.setProgress(progress);
						progressIndicator.setProgress(progress);
					}
					
				});
				
			}
			
		});
		player.setOnPlaying(new Runnable() {//플레잉상태일때 run에 내용적기

			@Override
			public void run()
			{
				btnPlay.setDisable(true); //false일때 enable상태임
				btnStop.setDisable(false);
				btnPause.setDisable(false);
				
			}
			
		});
		player.setOnPaused(new Runnable() { //중지상태일때 run에 내용적기

			@Override
			public void run()
			{
				btnPlay.setDisable(false); //false일때 enable상태임
				btnStop.setDisable(false);
				btnPause.setDisable(true);
			}
			
		});
		player.setOnStopped(new Runnable() {

			@Override
			public void run()
			{
				btnPlay.setDisable(false); //false일때 enable상태임
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
			
		});
		player.setOnEndOfMedia(new Runnable() {

			@Override
			public void run()
			{
				btnPlay.setDisable(false); //false일때 enable상태임
				btnStop.setDisable(true);
				btnPause.setDisable(true);
				
			}
			
		});
		btnPlay.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent arg0)
			{
				player.play();
			}
		});
		
		
		btnStop.setOnAction ((e)->player.stop());
		//위에거를 람다표현식으로 한거 위아래 두개다
		btnPause.setOnAction((e)->player.pause());			
		
	}
}
