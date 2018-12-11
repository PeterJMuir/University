import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.text.*;	// Font
import javafx.scene.paint.*;	// Color
import javafx.geometry.*;		// Pos
import javafx.scene.image.*;	// ImageView

public class ImageDisplaySimple extends Application
{
	private int count = 0;

	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		// Define image view
		ImageView imgView = new ImageView("minifoxterrier.jpg");
		imgView.setFitWidth(100);
		imgView.setPreserveRatio(true);

		// Add it to a pane
		Pane pane = new FlowPane();
		pane.getChildren().add(imgView);

		//	Set scene and stage
		Scene scene = new Scene(pane, 400, 300);
		stage.setScene(scene);
	}
}
