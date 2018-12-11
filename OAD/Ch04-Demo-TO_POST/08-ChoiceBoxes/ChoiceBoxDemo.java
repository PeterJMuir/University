import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ChoiceBoxDemo extends Application
{
	private int count = 0;

	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.sizeToScene();
		stage.show();
	}

	public void build(Stage stage)
	{
		// Define a choice list of Strings (objetcs)
		String choice1 = "Choice 1";
		String choice2 = "Choice 2";
		String choice3 = "Choice 3";
		String choice4 = "Choice 4";

		ChoiceBox<String>  choices = new ChoiceBox<String>();
		choices.getItems().addAll(choice1, choice2, choice3, choice4);

		// Set default value
		choices.setValue(choice2);

		// Get selected value
		Button bt = new Button("Get Choice and display on command window");
		bt.setOnAction((e) ->
			{
				String selected = choices.getValue();
				System.out.println("\n" + selected);
			});

		// Add a change listener
		choices.getSelectionModel().selectedItemProperty().addListener(
			// ChangeListener
			(ov, oldValue, newValue) ->
			{
				System.out.println("\n" + oldValue + " -> " + newValue);
				System.out.println("current choice: " + choices.getValue());
			});

		VBox root = new VBox(20, choices, bt);  // 20 px gaps between elements
		root.setStyle("-fx-font-size: 20");

		//	Set scene and stage
		Scene scene = new Scene(root, 500, 300);
		stage.setScene(scene);
	}
}
