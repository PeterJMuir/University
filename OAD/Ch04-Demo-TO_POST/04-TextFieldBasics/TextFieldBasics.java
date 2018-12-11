import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TextFieldBasics extends Application
{
	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		// Create text fields
		TextField tf = new TextField("Text Field ");

		// Set font
		tf.setStyle(
			"-fx-font: 20 Arial;" +
			"-fx-text-fill: blue;" +
			"-fx-background-color: yellow;" +
			"-fx-border-style:solid;" +
			"-fx-alignment: center");	// align text in the text field

		// Set size
		tf.setMinWidth(200);
		tf.setMinHeight(100);

		Button appendBT = new Button("Append Text");
		appendBT.setOnAction(e ->
			{
				tf.appendText(tf.getText());
			});

		// TextField to illustrate setEditable
		TextField tf2 = new TextField("You cannot change me");
		tf2.setEditable(false);

		// TexrField 3 to illustrate set focus
		// See request focus statement further down
		TextField tf3 = new TextField("Text Field 3 - request focus");
		tf3.setMaxWidth(200);

		// Example of password field
		PasswordField pwf = new PasswordField();

		TextField tf4 = new TextField("Respond to ENTER");
		tf4.setOnAction( e ->
		{
			System.out.println("ENTER pressed: " + tf4.getText());
		});

		// Use a vbox to display buttons
		VBox root = new VBox(tf, appendBT, tf2, tf3, pwf, tf4);
		root.setStyle(
			"-fx-alignment: center;" +
			"-fx-spacing: 20");

		//Set scene and stage
		Scene scene = new Scene(root, 400, 400);
		tf3.requestFocus(); // must be after placing it in the scene

		stage.setScene(scene);
	}
}
