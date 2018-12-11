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

public class CreateCustomizedSorter extends Application
{
	public void start(Stage stage) throws Exception
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage) throws Exception
	{
		ObservableList<Product> dataList = FXCollections.observableArrayList();
		dataList.addAll(
			new Product("P40", "table", 40.10, true),
			new Product("P10", "table", 20.10, false),
			new Product("P20", "chair", 30.10, true),
			new Product("P30", "desk", 50.10, false));

		// To create table view, create table columns and  add columns
		// to the view

		TableColumn<Product, String> idCol = new TableColumn<Product, String>("Id");
		TableColumn<Product, String> nameCol = new TableColumn<Product, String>("Name");
		TableColumn<Product, Double> priceCol = new TableColumn<Product, Double>("Price");
		TableColumn<Product, Boolean> onSaleCol = new TableColumn<Product, Boolean>("OnSale");
		// "On Sale" does not work!

		nameCol.setMinWidth(100);

		// add columns to view
		TableView<Product> tableView = new TableView<Product>();
		tableView.getColumns().add(idCol);
		tableView.getColumns().add(nameCol);
		tableView.getColumns().add(priceCol);
		tableView.getColumns().add(onSaleCol);

		// add data to view
		tableView.setItems(dataList);

		// set cell value factory to display data
		//
		idCol.setCellValueFactory(new PropertyValueFactory<Product, String>("Id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
		priceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("Price"));
		onSaleCol.setCellValueFactory(
			new PropertyValueFactory<Product, Boolean>("OnSale"));

		/* Add button to do custom sort.
			Can still click on column header to sort
		*/
		Button sortBT = new Button("Sort Rows by Name (ascending) and Price (descending)");
		sortBT.setOnAction((e) ->
			{
				nameCol.setSortType(TableColumn.SortType.ASCENDING);
				priceCol.setSortType(TableColumn.SortType.DESCENDING);
				tableView.getSortOrder().clear();
				tableView.getSortOrder().add(nameCol);
				tableView.getSortOrder().add(priceCol);
			});

		VBox root = new VBox(tableView, sortBT);
		root.setStyle("-fx-font-size: 20");
		Scene scene = new Scene(root, 600, 300);
		stage.setScene(scene);
	}
}
