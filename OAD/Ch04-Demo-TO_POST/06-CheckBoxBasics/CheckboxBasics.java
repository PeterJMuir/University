import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CheckboxBasics extends Application
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
		// Define a checkbox and a button to display its state
		//
		CheckBox cb1 = new CheckBox("Check Box 1");
		cb1.setStyle("-fx-font: 20 monospace; -fx-background-color: yellow");

		Button displayBT = new Button("Click to display check box 1 state on command window");
		displayBT.setOnAction((e) ->
			{
				boolean state = cb1.isSelected();
				System.out.println("Check box 1 selected: " + state);
			});

		HBox hbox1 = new HBox(40, cb1, displayBT); // spacing = 40

		// Define a check box and a button to change its state
		//
		CheckBox cb2 = new CheckBox();
		cb2.setText("Check Box 2");

		Button toggleBT = new Button("Click to check or uncheck check box 2");
		toggleBT.setOnAction((e) ->
			{
				boolean state = cb2.isSelected()? false: true;
				cb2.setSelected(state);
				System.out.println("Check box 2 selected: " + state);
			});

		HBox hbox2 = new HBox(40, cb2, toggleBT);

		// Define a check box (put the label on the left)
		// and a button that can be switched on or off by the check box
		//

		// Set a state change listener
		CheckBox cb3 = new CheckBox("Click on this check box to enable/disable button on the left");
		Button bt = new Button("On or Off");
		cb3.setOnAction((e) ->
			{
				bt.setDisable(cb3.isSelected());
				System.out.println("Button disabled: " + bt.isDisable());
			});

		HBox hbox3 = new HBox(80, bt, cb3);

		CheckBox cb4 = new CheckBox();
		Label lb = new Label("Check Box 4 on top of text");
		lb.setGraphic(cb4);
		lb.setStyle("-fx-content-display: TOP"); // checkbox on the right
								// values: RIGHT,LEFT,TOP,BOTTOM

		VBox root = new VBox(hbox1, hbox2, hbox3, lb);

		root.setStyle("-fx-font-size: 20; -fx-spacing: 30");
		root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				// fit size to those of elements of the container

		//	Set scene and stage
		Scene scene = new Scene(root); //, 600, 300);
		stage.setScene(scene);
	}
}
