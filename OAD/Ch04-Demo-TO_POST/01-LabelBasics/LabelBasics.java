import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LabelBasics extends Application
{
	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		// Create label
		Label label = new Label("A LABEL");

		// Set text font and color
		label.setStyle(
			"-fx-font-family: Arial; " +
			"-fx-font-size: 30;" +
			"-fx-text-fill: red;" +
			"-fx-background-color: yellow;" +
			"-fx-border-style: dashed; " +
			"-fx-alignment: center;");

		// Set size
		label.setMinWidth(200);
		label.setMaxWidth(200);
		label.setPrefHeight(100);

		// Set tooltip
		label.setTooltip(new Tooltip("This is a tooltip"));

		// Register a mouse listener
		label.setOnMouseEntered((e) ->
			{
				System.out.println("Mouse enters label area");
			});

		Label instructionLB = new Label("Move mouse into the above label to see tooltip and message on command window");
		instructionLB.setStyle("-fx-wrap-text: true; -fx-border-style: solid");
		instructionLB.setMaxWidth(300);
		instructionLB.setMinHeight(100);

		// Place label in the pane
		FlowPane root = new FlowPane(label, instructionLB);

		//	Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}
