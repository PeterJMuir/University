// Binding text property of text field

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.geometry.*;

import javafx.beans.property.*;		// Property

public class BindingDemo extends Application
{
	public void start(Stage stage)
	{
		addContents(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	private void addContents(Stage stage)
	{
		VBox root = new VBox();

		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		Label header1 = new Label("One-way binding:");

		root.getChildren().addAll(header1, tf1, tf2);

		System.out.println(tf1.textProperty());
				// Output shows that this is a String property

		// Bind the property of tf1 to that of tf2
		// tf1 is not editable
		// tf2 changes -> tf1 changes
		tf1.textProperty().bind(tf2.textProperty());


		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		Label header2 = new Label("Two-way binding:");
		root.getChildren().addAll(header2, tf3, tf4);

		// Bind the properties in both directions
		// Both tf3 and tf4 are editable
		// When one changes, the other one changes too
		tf3.textProperty().bindBidirectional(tf4.textProperty());


		// Can add a change listener to a text field via its property
		tf3.textProperty().addListener((obs, oldValue, newValue) ->
			{
				System.out.println(">>> old: " + oldValue + ", new: " + newValue);
			});

		//	Define the scene and set the stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}
