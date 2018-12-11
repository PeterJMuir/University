import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.*;
import java.io.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.scene.control.cell.*;
import javafx.beans.property.*;

public class CreateFilter extends Application
{
	// Data source controller
	Catalog catalog = new Catalog();

	public void start(Stage stage) throws Exception
	{
		addContents(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void addContents(Stage stage) throws Exception
	{

		// =============================================
		// Define the table data and table view
		// =============================================

		// Create table data (an observable list of objects)
		//
		ObservableList<Product> tableData= FXCollections.observableArrayList();

		// Define table columns
		//
		TableColumn<Product, String> idColumn =
							new TableColumn<Product, String>("Id");
		idColumn.setCellValueFactory(
							new PropertyValueFactory<Product, String>("Id"));

		TableColumn<Product, String> nameColumn =
							new TableColumn<Product, String>("Name");
		nameColumn.setCellValueFactory(
							new PropertyValueFactory<Product, String>("Name"));

		TableColumn<Product, Double> priceColumn =
							new TableColumn<Product, Double>("Price");
		priceColumn.setCellValueFactory(
							new PropertyValueFactory<Product, Double>("Price"));

		TableColumn<Product, Boolean> onSaleColumn =
							new TableColumn<Product, Boolean>("OnSale");
		onSaleColumn.setCellValueFactory(
							new PropertyValueFactory<Product, Boolean>("OnSale"));

		// Create the table view and add table columns to it
		TableView<Product> tableView = new TableView<Product>();

		tableView.getColumns().add(idColumn);
		tableView.getColumns().add(nameColumn);
		tableView.getColumns().add(priceColumn);
		tableView.getColumns().add(onSaleColumn);
						// Comment out a statement and see effect

		//	Set the table data to be the table view's items
		//
		tableView.setItems(tableData);

		// Can control the display of the table view
		idColumn.setMinWidth(150);
		nameColumn.setMinWidth(150);
		priceColumn.setMinWidth(150);
		onSaleColumn.setMinWidth(150);


		// ============================
		// Put in some data
		// ============================

		tableData.add(new Product("p50", "chair", 50.0, true));
		tableData.add(new Product("p10", "table", 10.0, false));
		tableData.add(new Product("p20", "chair", 20.0, true));
		tableData.add(new Product("p30", "desk", 30.0, false));
		tableData.add(new Product("p40", "bookcase", 40.0, true));

		System.out.println("\nLOAD DATA (quick demo)\n" + tableData);


		// ========================
		// Create a filter
		// ========================

		// Create a text field to enter the filter string (on product name)
		//
		Label filterLB = new Label("Filter by Product Name: ");
		TextField filterTF = new TextField();
		HBox filterHBox = new HBox(filterLB, filterTF);

		// We need to do the following steps

		// 1.	Create a filteredList for table data
		// 	The filtered list has a predicate to filter the rows
		// 	Initial the predicate is set to true (no filter)
		FilteredList<Product> filteredList =
			new FilteredList<>(tableData, p -> true);

		// 2.	Create a sorted list with the filtered list
		SortedList<Product> sortedList = new SortedList<>(filteredList);

		// 3.	Bind the comparator property of table VIEW and sorted list
		//		so that when the later is changed the former is changed as well
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());

		//	4.	Make the sorted list the items of the table view
		tableView.setItems(sortedList);

		// 5.	add a change listener to the text field
		// 	which sets the predicate for the filtered list
		// 	based on the value in the text field
		//
		filterTF.textProperty()
			.addListener((observable, oldValue, newValue) ->
			{
				filteredList.setPredicate(product ->
					{
						// If filter text is empty, display all products
						if (newValue == null || newValue.isEmpty())
						{
							return true;
						}

						// Compare product's name with filter text
						// If match, return true.
						// Else return false
						// Can combine with other columns as well if we wish
						// by evaluating a compound boolean expression
						//
						String filterString = newValue.toUpperCase();

						if (product.getName().toUpperCase().contains(filterString))
						{
							return true;
						}
						else
						{
							return false;
						}
					});
			  });


		// Create scene and set stage
		VBox root = new VBox(tableView,filterHBox);
		root.setStyle("-fx-font-size: 30");
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}