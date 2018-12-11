import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import javafx.collections.*;
import java.util.*;

public class ProductChoiceBox extends Application
{
	private int count = 0;

	public void start(Stage stage)
	{
		addContents(stage);
		stage.setTitle("Sample");
		stage.sizeToScene();
		stage.show();
	}

	public void addContents(Stage stage)
	{
		// Define a choice list of Strings (objetcs)
		Product p1 = new Product("P10", "Table", 100.50);
		Product p2 = new Product("P20", "Chair", 30.50);
		Product p3 = new Product("P30", "Desk", 200.50);
		Product p4 = new Product("P40", "Light", 80.50);


		ChoiceBox<Product>  choices = new ChoiceBox<Product>();
		choices.getItems().addAll(p1, p2, p3, p4);

		Collections.sort(choices.getItems(), (pr1, pr2) ->
			pr1.getPrice() > pr2.getPrice()? -1: 1);

		choices.getSelectionModel().selectedItemProperty().addListener(
			// ChangeListener
			(ov, oldValue, newValue) ->
			{
				System.out.println("\n" + ov);
				System.out.println(oldValue + " -> " + newValue);
				System.out.println(choices.getValue());
			});

		/*
		choices.getItems().addListener( change ->
		{
			System.out.println("\n" + change);	// off by 1 - STUPID!
			System.out.println(choices.getValue());
		});

		error: reference to addListener is ambiguous
				choices.getItems().addListener( change ->
				                  ^
		  both method addListener(InvalidationListener) in Observable and method addListener(ListChangeListener<? super E>) in ObservableList match

		Hence: Must use an anonymous class to indicate that it is ListChangeListener
		that we want.
		*/

		/*	Compiler warns about unsafe
			But if has parameter type, then error. FK!

		choices.getItems().addListener( new ListChangeListener()
			{
				public void onChanged(ListChangeListener.Change change)
				{
					System.out.println("\n" + change);	// off by 1 - STUPID!
					System.out.println(choices.getValue());
				}
			});
		*/

		/*	This works. What is the listener here?
			It is a ListChangeListener

		choices.getSelectionModel().selectedItemProperty().addListener( change ->
		{
			System.out.println("\n" + change);	// off by 1 - STUPID!
			System.out.println(choices.getValue());
		});
		*/

		// Set default value
		choices.setValue(p2);

		// Get selected value
		Button bt = new Button("Get Choice");
		bt.setOnAction((e) ->
			{
				Product selected = choices.getValue();
				System.out.println("\n" + selected);
			});

		FlowPane pane = new FlowPane(choices, bt);
		pane.setHgap(20);

		//	Set scene and stage
		Scene scene = new Scene(pane, 400, 300);
		stage.setScene(scene);
	}
}
