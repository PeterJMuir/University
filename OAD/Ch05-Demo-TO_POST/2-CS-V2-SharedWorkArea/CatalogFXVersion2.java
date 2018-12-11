import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;	// Modality

public class CatalogFXVersion2 extends Application
{
	private Catalog catalog = new Catalog();

	private TextArea displayTA = new TextArea();
	private TextField idTF = new TextField();
	private TextField nameTF = new TextField();
	private TextField priceTF = new TextField();
	private TextField onSaleTF = new TextField();


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
		// Text area
		//
		displayTA.setMinWidth(200);
		displayTA.setMinHeight(200);

		// Work area: 4 labels and text fields
		//
		Label idLB = new Label("ID: ");
		idTF = new TextField();
		HBox idHBox = new HBox();
		idHBox.getChildren().addAll(idLB, idTF);

		Label nameLB = new Label("Name: ");
		nameTF = new TextField();
		HBox nameHBox = new HBox();
		nameHBox.getChildren().addAll(nameLB, nameTF);

		Label priceLB = new Label("Price: ");
		priceTF = new TextField();
		HBox priceHBox = new HBox();
		priceHBox.getChildren().addAll(priceLB, priceTF);

		Label onSaleLB = new Label("On Sale: ");
		onSaleTF = new TextField();
		HBox onSaleHBox = new HBox();
		onSaleHBox.getChildren().addAll(onSaleLB, onSaleTF);

		//	Buttons to perform operations
		//
		Button loadDataBT = new Button("Load Data");
		Button displayProductsBT = new Button("Display Products");
		Button searchProductBT = new Button("Search Product");
		Button addProductBT = new Button("Add Product");
		Button updatePriceBT = new Button("Update Product Price");
		Button saveDataBT = new Button("SaveData");
		FlowPane buttonsPane = new FlowPane();
		buttonsPane.getChildren().addAll(loadDataBT, displayProductsBT,
			searchProductBT, addProductBT, updatePriceBT, saveDataBT);

		VBox root = new VBox();
		root.getChildren().addAll(displayTA, idHBox, nameHBox, priceHBox, onSaleHBox,
			buttonsPane);
		root.setStyle("-fx-alignment: center; -fx-font-size: 20; -fx-spacing:10");

		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);

		// catch exceptions
		Thread.currentThread().setUncaughtExceptionHandler((thread, exception) ->
		{
			System.out.println("ERROR: " + exception);
		});

		// Implement behaviors

		// Load data
		loadDataBT.setOnAction((e) -> loadData());

		// Display Products
		displayProductsBT.setOnAction((e) -> displayProducts());

		// Search Product
		searchProductBT.setOnAction((e) -> searchProduct());

		// add product
		addProductBT.setOnAction((e) -> addProduct());

		// update product price
		updatePriceBT.setOnAction((e) -> updateProductPrice());

		// Save data
		saveDataBT.setOnAction((e) -> saveData());
	}

	private void loadData()
	{
		try
		{
			catalog.loadData();
			System.out.println("\nLOAD DATA:\n" + catalog);	// to verify
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception.getMessage());
		}
	}

	private void displayProducts()
	{
		String result = catalog.toString();	// effectively get all products
		displayTA.setText(result);
	}

	private void searchProduct()
	{
		String id = idTF.getText();
		Product product = catalog.searchProduct(id);

		nameTF.setText(product.getName());
		priceTF.setText(product.getPrice() + "");
		onSaleTF.setText(product.isOnSale() + "");

		displayTA.setText(product.toString());
		// System.out.println(product);

	}

	private void addProduct()
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

		System.out.println("\nADD PRODUCT:\n" + catalog); // to check
	}

	private void updateProductPrice()
	{
		String id = idTF.getText().trim();
		double price = Double.parseDouble(priceTF.getText().trim());

		try
		{
			catalog.updateProductPrice(id, price);
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception.getMessage());
		}

		System.out.println("\nUPDATE PRODUCT PRICE:\n" + catalog); // to check
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

		System.out.println("\nSAVE DATA:\n" + catalog); // to check
	}
}

