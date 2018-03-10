package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) throws IOException{
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/MainWindow.fxml"));
		
		Pane pane = loader.load();
		Scene scene = new Scene(pane, 800, 600);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("AVL Tree");
		primaryStage.show();
	}
    
}
