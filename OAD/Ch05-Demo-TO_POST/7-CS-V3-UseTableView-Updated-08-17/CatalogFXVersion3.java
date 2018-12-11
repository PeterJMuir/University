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

public class CatalogFXVersion3 extends Application
{
	// Data source controller
	Catalog catalog = new Catalog();

	public void start(Stage stage) throws Exception
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();

		Thread.currentThread().setUncaughtExceptionHandler((thread, exception) ->
		{
			System.out.println("ERROR: " + exception);
		});
	}

	public void build(Stage stage) throws Exception
	{

		// =============================================
		// Task 1 - Define the table data and table view
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

		//	Attach table data to the table view
		//
		tableView.setItems(tableData);


		// Can control the display of the table view
		tableView.setMinWidth(500);
		tableView.setMaxWidth(600);
		idColumn.setMinWidth(100);
		nameColumn.setMinWidth(100);
		priceColumn.setMinWidth(100);
		onSaleColumn.setMinWidth(100);


		// =====================================
		// Task 2 - LOAD DATA (for a quick demo)
		// =====================================

		/*	MODIFIED (commented out) on 17/08/16

		tableData.add(new Product("p50", "chair", 50.0, true));
		tableData.add(new Product("p10", "table", 10.0, false));
		tableData.add(new Product("p20", "chair", 20.0, true));
		tableData.add(new Product("p30", "desk", 30.0, false));
		tableData.add(new Product("p40", "bookcase", 40.0, true));

		System.out.println("\nLOAD DATA (quick demo)\n" + tableData);
		*/



		// ========================
		// Task 3 - Create a filter
		// ========================

		// Create a text field to enter the filter string (on product name)
		//
		Label filterLB = new Label("Filter by Product Name: ");
		TextField filterTF = new TextField();
		HBox filterHBox = new HBox(filterLB, filterTF);

		// We need to
		//		1.	Create a filtered list
		// 	2.	Create a sorted list from the filtered list
		//		3.	Bind comparators of sorted list with that of table view
		// 	4.	Set items of table view to be sorted list
		//		5.	Set a change listener to text field to set the filter predicate
		//			of filtered list

		// Create a filteredList
		FilteredList<Product> filteredList =
			new FilteredList<>(tableData, p -> true);

		// Create a sorte list (based on the filtered list)
		// By the comparator property of table list and sorted list
		//	so that when one is changed the other is changed as well
		//	Make the sorted list the items of the table view
		//
		SortedList<Product> sortedList = new SortedList<>(filteredList);
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedList);

		// add a change listener to the text field
		// which set the predicate for the filer list
		// based on the value in the text field
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
				 		// If match, return true. Otherwise return false
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




		// =====================================================================
		// Task 4 - Add Customized Sorter
		// Sorts by name (in ascending order) and then price (in descending order)
		// IN ADDITION TO EXISTING SORTING ORDER IN OTHER COLUMNS IF ANY
		//
		// Also add button to unsort the table view
		// =====================================================================

		Button sortBT = new Button("Sort by Name and Price");
		sortBT.setOnAction((e) ->
			{
				nameColumn.setSortType(TableColumn.SortType.ASCENDING);
				priceColumn.setSortType(TableColumn.SortType.DESCENDING);
				tableView.getSortOrder().clear();
				tableView.getSortOrder().add(nameColumn);
				tableView.getSortOrder().add(priceColumn);
			});

		Button unsortBT = new Button("Restore Original Order");
		unsortBT.setOnAction((e) ->
			{
				tableView.getSortOrder().clear();
			});

		HBox sortHBox = new HBox(sortBT, unsortBT);

		// ===================================================================
		// Task 5 - Create Work Area
		// ===================================================================

		Label idLB = new Label("Product ID: ");
		TextField idTF = new TextField();

		Label nameLB = new Label("Name: ");
		TextField nameTF = new TextField();

		Label priceLB = new Label("Price: ");
		TextField priceTF = new TextField();

		Label onSaleLB = new Label("On Sale: ");
		TextField onSaleTF = new TextField();

		HBox workAreaHBox = new HBox();
		workAreaHBox.getChildren().addAll(idLB, idTF, nameLB, nameTF,
			priceLB, priceTF, onSaleLB, onSaleTF);


		//	==================================================================
		//	Task 6 - Create button to copy selected row
		// ==================================================================
		Button copyBT = new Button("Copy Selected Product");

		copyBT.setOnAction(e ->
			{
				Product p = tableView.getSelectionModel().getSelectedItem();
				idTF.setText(p.getId());
				nameTF.setText(p.getName());
				priceTF.setText(new String() + p.getPrice());
				onSaleTF.setText(new String() + p.isOnSale());
			});



		// ===================================================================
		// Task 7 - Create buttons to add, update and delete product
		// ====================================================================


		Button addBT = new Button("Add Product");
		addBT.setOnAction(e ->
			{
				try
				{
					// Get input values
					String id = idTF.getText().trim();
					String name = nameTF.getText().trim();
					double price = Double.parseDouble(priceTF.getText().trim());
					boolean onSale= Boolean.parseBoolean(onSaleTF.getText().trim());

					// add to both catalog and table data
					// MODIFIED ON 17/08/2016
					catalog.addProduct(id, name, price, onSale);
					tableData.add(catalog.searchProduct(id));
					// tableData.add(new Product(id, name, price, onSale));

					System.out.println("\nAFTER Add / table data:\n" + tableData);
					System.out.println("\nAFTER Add / catalog:\n" + catalog);
				}
				catch(Exception exception)
				{
					throw new RuntimeException(exception.getMessage());
				}

			});

		Button updateBT = new Button("Update Price, On Sale");
		updateBT.setOnAction((e) ->
			{
				try
				{
					String id = idTF.getText();
					double price = Double.parseDouble(priceTF.getText().trim());
					boolean onSale= Boolean.parseBoolean(onSaleTF.getText().trim());

					catalog.updateProductPrice(id, price);
					catalog.updateProductOnSaleStatus(id, onSale);

					/* MODIFIED ON 17/08/16 */

					// Refresh the column to see the change in the table view
					// (This is a work around)
					tableView.getColumns().get(0).setVisible(false);
					tableView.getColumns().get(0).setVisible(true);

					System.out.println("\nAFTER Update / table data:\n" + tableData);
					System.out.println("\nAFTER Update / catalog:\n" + catalog);

					/*	COMMENTED out on 17/08/16
						It is unnecessary to take these actions, due to the change
						made to add product method

					for(Product p: tableData)
					{
						if(p.getId().equals(id))
						{
							p.setPrice(price);
							p.setOnSale(onSale);


							// Refresh the column to see the change
							// (This is a work around)
							tableView.getColumns().get(0).setVisible(false);
							tableView.getColumns().get(0).setVisible(true);

							break;
						}
					}
					*/
				}
				catch(Exception exception)
				{
					throw new RuntimeException(exception.getMessage());
				}
			});

		Button deleteBT = new Button("Delete Product");
		deleteBT.setOnAction((e) ->
		{
			try
			{
				/* MODIFIED on 17/08/2016 to delete the product whose id
					id in the id text field in the work area (not the product
					selected in the table view. This change makes it more
					consistent with operation such as update price, etc.
				*/

				/*
				Product selectedProduct = tableView.getSelectionModel().getSelectedItem();
				catalog.removeProduct(selectedProduct.getId());
				tableData.remove(selectedProduct);
				*/

				String id = idTF.getText().trim();
				Product p = catalog.searchProduct(id);
				catalog.removeProduct(id);
				tableData.remove(p);
			}
			catch(Exception exception)
			{
				throw new RuntimeException(exception.getMessage());
			}

			System.out.println("\nAFTER Delete / table data:\n" + tableData);
			System.out.println("\nAFTER Delete / catalog:\n" + catalog);

		});

		HBox changeHBox = new HBox(addBT, updateBT, deleteBT, copyBT);

		// =====================================================
		// Load and Save Data
		// =====================================================

		Button loadDataBT = new Button("Load Data (for demo)");
		loadDataBT.setOnAction((e) ->
			{
				try
				{
					catalog.loadData();
					tableData.clear();
					tableData.addAll(catalog.getAllProducts());
				}

				catch(Exception exception)
				{
					throw new RuntimeException(exception.getMessage());
				}
			});


		Button saveDataBT = new Button("Save Data");
		saveDataBT.setOnAction((e) ->
			{
				try
				{
					/* MODIFIED on 17/08/16 */

					catalog.saveData();

					/*
					PrintWriter out = new PrintWriter(new File("out.txt"));
					for(Product p: tableData)
					{
						out.println(p);
					}
					out.close();
					*/
				}

				catch(Exception exception)
				{
					throw new RuntimeException(exception.getMessage());
				}
			});


		HBox loadSaveHBox = new HBox(loadDataBT, saveDataBT);



		// =====================================================================
		// SET UP and SHOW the Stage
		// =====================================================================
		// Create scene and set stage
		VBox root = new VBox(tableView, filterHBox, sortHBox, workAreaHBox,
			changeHBox, loadSaveHBox);

		root.setStyle(
				"-fx-background-color: wheat; -fx-font-size: 20;" +
				"-fx-alignment: center; -fx-spacing: 30");

		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}
