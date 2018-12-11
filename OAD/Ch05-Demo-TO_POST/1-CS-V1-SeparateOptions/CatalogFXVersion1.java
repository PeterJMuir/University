import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

import javafx.stage.*;	// Modality

public class CatalogFXVersion1 extends Application
{
	private Catalog catalog = new Catalog();

	public void start(Stage stage) throws Exception
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();

		Thread.currentThread().setUncaughtExceptionHandler((thread, exception) ->
		{
			// System.out.println("ERROR: " + exception);
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText("Exception thrown: " + exception);
			alert.showAndWait();
		});
	}

	public void build(Stage primaryStage) throws Exception
	{
		// Define buttons to perform options
		Button loadBT = new Button("Load Data");
		Button displayBT = new Button("Display Products");
		Button addBT = new Button("Add Product");
		Button saveBT = new Button("Save Data");

		HBox root = new HBox();
		root.getChildren().addAll(loadBT, displayBT, addBT, saveBT);
		root.setStyle("-fx-alignment: top-center; -fx-font-size: 20; -fx-spacing: 20");

		// Load data
		loadBT.setOnAction((e) -> loadData());


		// Display Products
		displayBT.setOnAction((e) -> displayProducts());

		// Add Product
		addBT.setOnAction((e) -> addProduct());

		// Save Data
		saveBT.setOnAction((e) -> saveData());

		//	Set scene and stage
		Scene scene = new Scene(root, 800, 400);
		primaryStage.setScene(scene);
	}

	private void loadData()
	{
		try
		{
			catalog.loadData();
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception.getMessage());
		}

		// data loaded OK
		System.out.println("LOAD DATA:\n" + catalog);	// print out to verify

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("Data has been successfully loaded.");
		alert.showAndWait();
	}

	private void displayProducts()
	{
		String result = catalog.toString();	// effectively get all products
		TextArea root = new TextArea(result);
		root.setStyle("-fx-font: 20 arial");
		Scene scene = new Scene(root);

		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
	}

	private void addProduct()
	{
		// Create the stage
		Label idLB = new Label("Product ID: ");
		TextField idTF = new TextField();
		HBox idHBox = new HBox();
		idHBox.getChildren().addAll(idLB, idTF);

		Label nameLB = new Label("Name: ");
		TextField nameTF = new TextField();
		HBox nameHBox = new HBox();
		nameHBox.getChildren().addAll(nameLB, nameTF);

		Label priceLB = new Label("Price: ");
		TextField priceTF = new TextField();
		HBox priceHBox = new HBox();
		priceHBox.getChildren().addAll(priceLB, priceTF);

		Label onSaleLB = new Label("On Sale: ");
		TextField onSaleTF = new TextField();
		HBox onSaleHBox = new HBox();
		onSaleHBox.getChildren().addAll(onSaleLB, onSaleTF);

		Button doAddBT = new Button("Add Product");
		doAddBT.setOnAction((e) ->
			{
				String id = idTF.getText().trim();
				String name = nameTF.getText().trim();
				double price = Double.parseDouble(priceTF.getText().trim());
				boolean onSale = Boolean.parseBoolean(onSaleTF.getText().trim());

				try
				{
					catalog.addProduct(id, name, price, onSale);
				}
				catch(Exception exception)
				{
					throw new RuntimeException(exception.getMessage());
				}

				System.out.println("\nADD PRODUCT:\n" + catalog); // display to check
			});

		VBox root = new VBox();
		root.getChildren().addAll(idHBox, nameHBox, priceHBox, onSaleHBox, doAddBT);
		root.setStyle("-fx-font-size: 20");

		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);

		// Show the stage
		stage.show();
	}

	private void saveData()
	{
		try
		{
			catalog.saveData();
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception.getMessage());
		}

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("Data has been successfully saved.");
		alert.showAndWait();
	}
}
