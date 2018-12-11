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

public class CreateTableView extends Application
{
	// Data source controller
	// Catalog catalog = new Catalog();

	public void start(Stage stage) throws Exception
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage) throws Exception
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
							// required to get instructions to display the cells
							// comment out and see effect

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


		// =================================
		// Put some data into the table data
		// =================================

		tableData.add(new Product("p50", "chair", 50.0, true));
		tableData.add(new Product("p10", "table", 10.0, false));
		tableData.add(new Product("p20", "chair", 20.0, true));
		tableData.add(new Product("p30", "desk", 30.0, false));
		tableData.add(new Product("p40", "bookcase", 40.0, true));

		System.out.println("\nLOAD DATA (quick demo)\n" + tableData);


		// Create scene and set stage
		VBox root = new VBox(tableView);
		root.setStyle(" -fx-font-size: 30");
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}