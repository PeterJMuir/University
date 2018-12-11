import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RadioButtonDemo extends Application
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
		// Define radio buttons
		RadioButton smallRB = new RadioButton("Small");
		RadioButton medRB = new RadioButton("Medium");
		RadioButton largeRB = new RadioButton("Large");

		//	Add them to a group
		ToggleGroup group = new ToggleGroup();
		smallRB.setToggleGroup(group);
		medRB.setToggleGroup(group);
		largeRB.setToggleGroup(group);
		// largeRB.setToggleGroup(null);	// to remove from toggle group?

		// Add a button to get the selected button
		Button bt1 = new Button("Get Selected Button");
		bt1.setOnAction((e) ->
			{
				RadioButton selected = (RadioButton) group.getSelectedToggle();
				System.out.println(selected);
				System.out.println(selected.getText());
			});

		// Add a button to get the selected button
		Button bt2 = new Button("Deselect all buttons of the group");
		bt2.setOnAction((e) ->
			{
				group.selectToggle(null);	// deselect all buttons
			});

		// Add the radio buttons and the button to the root pane
		VBox root = new VBox(20, smallRB, medRB, largeRB, bt1, bt2);
											// 20 is the gap between elements
		root.setStyle("-fx-font-size: 20");

		//	Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}
