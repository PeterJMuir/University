import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

public class CSSDemo extends Application
{
	public void start(Stage stage)
	{
		addContents(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	private void addContents(Stage stage)
	{
		// Define the root for the scene
		VBox root = new VBox();

		TextField tf1 = new TextField();
		tf1.setText("Hello!");

		TextField tf2 = new TextField();
		tf2.setText("Welcome!");
		tf2.setId("tf2");

		root.getChildren().addAll(tf1, tf2);

		// VBox.setMargin(tf2,new Insets(10,50,10,50));
		// top, right, bottom, left


		//	Define the scene and set style sheet for the scene
		Scene scene = new Scene(root);
		scene.getStylesheets().add("sample.css");

		// Set the stage
		stage.setScene(scene);
	}
}
