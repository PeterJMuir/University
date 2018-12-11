import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ComboBoxOfProducts extends Application
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
		// Define combo box
		Product p1 = new Product("P1", "table", 10.50);
		Product p2 = new Product("P2", "table", 20.50);
		Product p3 = new Product("P3", "table", 30.50);
		Product p4 = new Product("P4", "table", 40.50);
		Product p5 = new Product("P5", "table", 50.50);
		Product p6 = new Product("P6", "table", 60.50);
		Product p7 = new Product("P7", "table", 70.50);
		Product p8 = new Product("P8", "table", 80.50);

		ComboBox<Product>  choice = new ComboBox<Product>();
		choice.getItems().addAll(p1, p2, p3, p4, p5, p6, p7, p8);
		choice.setVisibleRowCount(4);

		choice.setPromptText("Choose an item");
		// OR
		// choice.setValue(p2);

		// Define a button to get the selected item
		Button getValueBT = new Button("Get Choice");
		getValueBT.setOnAction((e) ->
			{
				System.out.println(choice.getValue());
			});

		// can attach an action listener to the box
		choice.setOnAction((e) ->
			{
				System.out.println("value changed to: " + choice.getValue());
			});

		choice.getSelectionModel().selectedItemProperty().addListener( (ov, oldValue, newValue) ->
			{
				System.out.println("\n" + oldValue + " -> " + newValue);
			});

		VBox root = new VBox(choice, getValueBT);
		root.setMinWidth(800);
		root.setStyle("-fx-font-size: 20");

		// Define button to change the selected item
		// Only to demonstrate that we can change items of the box
		Button updateBT = new Button("Update selected choice");
		root.getChildren().add(updateBT);
		updateBT.setOnAction((e) ->
			{
				Product p = choice.getValue();
				p.setPrice(1000);

				// need to do the following to refresh the display of the box
				int i = choice.getItems().indexOf(p);
				choice.getItems().set(i, p);
				choice.setValue(p);

				System.out.println(p);
			});

		// Define a button to delete the selected item from the list
		// To show that we can delete (and add) items
		Button deleteBT = new Button("Delete selected choice");
		root.getChildren().add(deleteBT);
		deleteBT.setOnAction((e) -> choice.getItems().remove(choice.getValue()));

		//	Set scene and stage
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}

/*	EDITABLE combo box

	ComboBox<String> myComboBox = new ComboBox<String>();
   myComboBox.getItems().addAll("A","B","C","D","E");
   myComboBox.setEditable(true);
*/
