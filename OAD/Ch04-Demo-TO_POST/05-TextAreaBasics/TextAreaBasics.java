import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TextAreaBasics extends Application
{
	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		TextArea ta = new TextArea();
		ta.setText("This is line 1\n");
		ta.appendText("This is line 2\n");
		ta.appendText("We can cut and paste text in text area\n");
		ta.setWrapText(true);

		// can cut and paste text in text area
		// scrollbars are provided if necessary

		Button displayBT = new Button("Display text area content on command window");
		displayBT.setOnAction((e) ->
			{
				System.out.println(ta.getText());
			});

		TextArea ta2 = new TextArea("A long line to bring about scroll bar");
		ta2.setMaxWidth(150);
		ta2.setMaxHeight(150);
		ta2.setStyle(
			"-fx-font: 20 Arial;" +
			"-fx-text-fill: red;" +
			"-fx-background-color: yellow;"); // No effect?

		// Use a vbox to display text areas
		VBox root = new VBox(ta, displayBT, ta2);
		root.setStyle(
			"-fx-alignment: center;" +
			"-fx-spacing: 10");

		//	Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		ta2.requestFocus();

		stage.setScene(scene);
	}
}
