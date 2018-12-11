import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ButtonBasics extends Application
{
	private int count;

	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		// Create button
		Button button = new Button("A Button");

		// Set text font and color, background color, draw border
		button.setStyle(
			"-fx-font: 30 Arial;" +
			"-fx-text-fill: red;" +
			"-fx-background-color: yellow;" +
			"-fx-border-style: solid;" +
			"-fx-alignment: center");

		// Set size
		button.setMinWidth(200);
		button.setMinHeight(100);

		// Register an action event listener
		count = 0;	// note that count is an attribute
		button.setOnAction(e ->
			{
				count++;
				button.setText("Times Clicked: " + count);
			});

		// set tooltip and event listener
		button.setTooltip(new Tooltip("This is a tooltip"));
		button.setOnMouseExited((e) -> System.out.println("Mouse exited"));

		// For a quick test, uncomment next statement and see effect
		// button.setDisable(true);

		// Place button in a pane
		FlowPane root = new FlowPane(button);
		root.setStyle("-fx-alignment: center;");

		//	Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}
