/* CSE3OAD
* Modified by: Peter MUIR
* Student Number and Username: 18477719
* Used with RecipeDSC (user: root)
* */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.scene.control.cell.*;
import javafx.beans.property.*;
import javafx.util.Callback;

public class RecipeMain extends Application
{
	private ObservableList<Recipe> tableData;
	private TableView<Recipe> tableView;
	private RecipeDSC recipeDSC;

	public void start(Stage primaryStage) throws Exception
	{
		build(primaryStage);
		primaryStage.setTitle(getClass().getName());
		primaryStage.show();

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
		loadData();

		Node searchArea = makeSearchArea();
		Node tableViewArea = makeTableView();
		Node addViewDeleteArea = makeViewAddDeleteArea(primaryStage);

		VBox root = makeSceneRoot();

		root.getChildren().addAll(searchArea, tableViewArea, addViewDeleteArea);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
	}


	// To load data from the database into tableData
	// and tableView
	//
	private void loadData() throws Exception
	{
		recipeDSC = new RecipeDSC();
		List<Recipe> recipes = recipeDSC.findAll();

		tableData = FXCollections.observableArrayList();
		tableData.clear();
		tableData.addAll(recipes);

		tableView = new TableView<Recipe>();
		tableView.setItems(tableData);
	}


	// TO DO: Create and return a VBox to be the root of the scene graph
	//
	private VBox makeSceneRoot()
	{
		VBox root = new VBox();
		root.setStyle("-fx-spacing: 20;");
		return root;
	}


	// TO DO: Create the area to allow the user to search the table view
	// The program should provide option to apply the search to every field, or
	// to the ingredients, or the recipe names.
	//
	private Node makeSearchArea()
	{
		HBox searchBox = new HBox();
		Label searchLb = new Label("Enter Search Text:");
		TextField searchTF = new TextField();
		searchBox.getChildren().addAll(searchLb,searchTF);
		searchBox.setAlignment(Pos.CENTER);

		HBox sButtonsBox = new HBox();
		Label sButtonsLb = new Label("Search By: ");
		RadioButton anyFieldRB = new RadioButton("Any Field");
		RadioButton ingredientsRB = new RadioButton("Ingredients");
		RadioButton recipeNameRB = new RadioButton("Recipe Name");
		ToggleGroup searchTog = new ToggleGroup();
		anyFieldRB.setToggleGroup(searchTog);
		ingredientsRB.setToggleGroup(searchTog);
		recipeNameRB.setToggleGroup(searchTog);
		searchTog.selectToggle(anyFieldRB);
		sButtonsBox.getChildren().addAll(sButtonsLb, anyFieldRB,ingredientsRB,recipeNameRB);
		sButtonsBox.setAlignment(Pos.CENTER);
		sButtonsBox.setStyle("-fx-spacing: 5;");

		FilteredList<Recipe> filteredList =
				new FilteredList<>(tableData, p -> true);
		SortedList<Recipe> sortedList = new SortedList<Recipe>(filteredList);
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());

		tableView.setItems(sortedList);

		searchTF.textProperty().addListener((observable, oldValue, newValue) ->
		{
			filteredList.setPredicate(recipe ->
			{
				if(newValue == null || newValue.isEmpty())
				{
					return true;
				}
				String filterString = newValue.toUpperCase();
				if(anyFieldRB.isSelected() || recipeNameRB.isSelected()) {
					if (recipe.getName().toUpperCase().contains(filterString)) {
						return true;
					}
				}
				if(anyFieldRB.isSelected() || ingredientsRB.isSelected()){
					if (recipe.getIngredients().toString().toUpperCase().contains(filterString)) {
						return true;
					}
				}
				if(anyFieldRB.isSelected()){
					if(recipe.getRemarks().toUpperCase().contains(filterString)){
						return true;
					}
				}
				return false;
			});
		});

		VBox searchArea = new VBox(searchBox,sButtonsBox);
		searchArea.setStyle("-fx-spacing: 10;" +
				"-fx-padding: 10 50 10 50;" +
				"-fx-border-style: solid;" +
				"-fx-border-color: black;" +
				"-fx-border-width: 2;");
		return searchArea;
	}


	//
	// TO DO: Define the table view and put it in a hbox
	//
	private Node makeTableView()
	{
		TableColumn<Recipe, String> idColumn =
				new TableColumn<Recipe, String>("Id");
		idColumn.setCellValueFactory(
				new PropertyValueFactory<Recipe, String>("ID"));
		// required to get instructions to display the cells
		// comment out and see effect

		TableColumn<Recipe, String> nameColumn =
				new TableColumn<Recipe, String>("Recipe Name");
		nameColumn.setCellValueFactory(
				new PropertyValueFactory<Recipe, String>("Name"));
		TableColumn<Recipe, Integer> servesColumn =
				new TableColumn<Recipe, Integer>("Serves");
		servesColumn.setCellValueFactory(
				new PropertyValueFactory<Recipe, Integer>("Serves"));

		TableColumn<Recipe, String> ingredientsColumn =
				new TableColumn<Recipe, String>("Ingredients");
		ingredientsColumn.setCellValueFactory(
				new PropertyValueFactory<Recipe, String>("IngredientString"));

		TableColumn<Recipe, String> remarksColumn =
				new TableColumn<Recipe, String>("Remarks");
		remarksColumn.setCellValueFactory(
				new PropertyValueFactory<Recipe, String>("Remarks"));




		// Create the table view and add table columns to it
		//TableView<Recipe> tableView = new TableView<Recipe>();

		tableView.getColumns().add(idColumn);
		tableView.getColumns().add(nameColumn);
		tableView.getColumns().add(servesColumn);
		tableView.getColumns().add(ingredientsColumn);
		tableView.getColumns().add(remarksColumn);
		// Comment out a statement and see effect

		//	Set the table data to be the table view's items
		//
		//tableView.setItems(tableData);


		// Can control the display of the table view
		idColumn.setMinWidth(50);
		nameColumn.setMinWidth(200);
		servesColumn.setMinWidth(50);
		ingredientsColumn.setMinWidth(250);
		ingredientsColumn.setStyle("-fx-wrap-text: true;");
		ingredientsColumn.setResizable(true);
		ingredientsColumn.setCellFactory(new Callback<TableColumn<Recipe,String>,TableCell<Recipe,String>>(){
			public TableCell<Recipe,String> call(TableColumn<Recipe,String> param){
				TableCell<Recipe,String> cell = new TableCell<>();
				Text text =new Text();
				cell.setGraphic(text);
				cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
				text.wrappingWidthProperty().bind(ingredientsColumn.widthProperty());
				text.textProperty().bind(cell.itemProperty());
				return cell;
			}
		});
		remarksColumn.setMinWidth(200);
		return tableView;
	}


	// TO DO: Create the area with the buttons to view, add and delete reviews
	//
	private Node makeViewAddDeleteArea(Stage primaryStage)
	{
		HBox buttBox = new HBox();
		Button addBT = new Button("Add Recipe");
		Button deleteBT = new Button("Delete Selected Recipe");
		Button viewBT = new Button("View/Update Selected Recipe");
		buttBox.getChildren().addAll(viewBT,addBT,deleteBT);
		buttBox.setAlignment(Pos.CENTER);
		buttBox.setStyle("-fx-spacing: 15;");
		RecipeStageMaker rsm = new RecipeStageMaker(recipeDSC,tableData,tableView,primaryStage);
		viewBT.setOnAction(e -> {
			try {
				rsm.showViewRecipeStage();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		addBT.setOnAction(e -> {
			try {
				rsm.showAddRecipeStage();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		deleteBT.setOnAction(e -> {
			try {
				rsm.showDeleteRecipeStage();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		return buttBox;
	}

}

