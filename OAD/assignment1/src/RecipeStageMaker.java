/*
This class is used to define and show three stages: one to view and/od update
a recipe, one to add a ne recipe, and one to delete a recipe.
*/
/* CSE3OAD
* Modified by: Peter MUIR
* Student Number and Username: 18477719
* Used with RecipeDSC (user: root)
* */

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

import java.sql.SQLException;
import java.util.*;
import java.io.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.scene.control.cell.*;
import javafx.beans.property.*;

public class RecipeStageMaker
{
	private RecipeDSC recipeDSC;
	private ObservableList<Recipe> tableData;
	private TableView<Recipe> tableView;
	private Stage primaryStage;
	//private TableView<Ingredient> ingTV;
	private ObservableList<Ingredient> ingTD;

	// id
	private Label idLB = new Label("Id: ");
	private TextField idTF = new TextField();
	private HBox idHBox = new HBox(idLB, idTF);

	// name
	private Label nameLB = new Label("Recipe Name: ");;
	private TextField nameTF = new TextField();
	private HBox nameHBox = new HBox(nameLB, nameTF);

	// serves
	private Label servesLB = new Label("Serves: ");
	private TextField servesTF = new TextField();
	private HBox servesHBox = new HBox(servesLB, servesTF);

	// ingredients
	private Label ingredientsLB = new Label("Ingredients");
	private TableView<Ingredient> ingredientsTbl = new TableView<>();
	private Button ingredientsAdd = new Button("Add Ingredient");
	private Button ingredientsEdd = new Button("Edit Ingredient");
	private Button ingredientsDel = new Button("Delete Ingredient");
	private VBox ingredientButtons = new VBox(ingredientsAdd, ingredientsEdd, ingredientsDel);
	private VBox ingredientsLblAndTbl = new VBox(ingredientsLB, ingredientsTbl);
	private HBox ingredientsHBox = new HBox(ingredientsLblAndTbl, ingredientButtons);

	//ingredient add/edit/delete control
	private Label ingName = new Label("Name: ");
	private TextField ingNameTF = new TextField();
	private HBox ingNameBox = new HBox(ingName,ingNameTF);

	private Label ingQuantity = new Label("Quantity: ");
	private TextField ingQuantityTF = new TextField();
	private HBox ingQuantityBox = new HBox(ingQuantity,ingQuantityTF);

	private Label ingUnits = new Label("Units: ");
	private TextField ingUnitsTF = new TextField();
	private HBox ingUnitsBox = new HBox(ingUnits,ingUnitsTF);

	private Button yesBT = new Button("Okay");
	private Button noBT = new Button("Cancel");
	private HBox buttBox = new HBox(yesBT,noBT);

	private VBox ingRoot = new VBox(ingNameBox,ingQuantityBox,ingUnitsBox,buttBox);
	private Scene ingScene = new Scene(ingRoot);
	private Stage twoStage = new Stage();

	// steps
	private TextArea stepsTA = new TextArea();
	private HBox stepsHBox = new HBox(stepsTA);

	// remarks
	private Label remarksLB = new Label("Remarks: ");
	private TextField remarksTF = new TextField();
	private HBox remarksHBox = new HBox(remarksLB, remarksTF);

	// action buttons
	private Button addBT = new Button("ADD Recipe");
	private Button updateBT = new Button("UPDATE Recipe");
	private Button deleteBT = new Button("DELETE Recipe");
	private Button cancelBT = new Button("EXIT/CANCEL");
	private HBox actionHBox = new HBox();

	// root, scene, local stage
	private VBox root = new VBox();
	private Scene scene = new Scene(root);
	private Stage stage = new Stage();

	public RecipeStageMaker(RecipeDSC recipeDSC, ObservableList<Recipe> tableData, TableView<Recipe> tableView, Stage primaryStage )
	{
		/*
		 * TO DO: Initilize the RecipeStageMaker
		 * (can include the setting of style rules if choose to do so)
		 */
		this.recipeDSC = recipeDSC;
		this.tableData = tableData;
		this.tableView = tableView;
		this.primaryStage = primaryStage;
		idTF.setEditable(false);

		//Table config
		TableColumn<Ingredient, String> ingredientsColumn =
				new TableColumn<Ingredient, String>("Ingredient");
		ingredientsColumn.setCellValueFactory(
				new PropertyValueFactory<Ingredient, String>("Name"));

		TableColumn<Ingredient, Double> quantityColumn =
				new TableColumn<Ingredient, Double>("Quantity");
		quantityColumn.setCellValueFactory(
				new PropertyValueFactory<Ingredient, Double>("Quantity"));

		TableColumn<Ingredient, String> unitsColumn =
				new TableColumn<Ingredient, String>("Units");
		unitsColumn.setCellValueFactory(
				new PropertyValueFactory<Ingredient, String>("UnitsAndStyle"));
		
		ingredientsTbl.getColumns().add(ingredientsColumn);
		ingredientsTbl.getColumns().add(quantityColumn);
		ingredientsTbl.getColumns().add(unitsColumn);
		ingTD = FXCollections.observableArrayList();
		ingTD.clear();

		ingredientsTbl.setItems(ingTD);
		ingredientsTbl.setMinWidth(500);
		stage.setMinWidth(800);

		cancelBT.setOnAction(e ->{
				stage.close();
		});

		twoStage.setScene(ingScene);
		twoStage.initModality(Modality.APPLICATION_MODAL);
		ingredientsAdd.setOnAction(e ->{
			try {
				buildAdd();

				twoStage.show();
			}catch(Exception exc)
			{
				System.out.println("Couldn't build 3rd Stage\n" + exc);
			}
		});
		ingredientsDel.setOnAction(e ->
		{
			try{
				buildDel();
				twoStage.show();
			}catch(Exception exc)
			{
				System.out.println("Couldn't build 3rd Stage\n" + exc);
			}
		});
		ingredientsEdd.setOnAction(e ->
		{
			try {
				buildEdd();
				twoStage.show();
			}catch(Exception exc)
			{
				System.out.println("Couldn't build 3rd Stage\n" + exc);
			}
		});

	}
	private void buildEdd()throws Exception
	{
		Ingredient sel = ingredientsTbl.getSelectionModel().getSelectedItem();
		ingNameTF.setText(sel.getName());
		ingQuantityTF.setText(String.format("%f",sel.getQuantity()));
		ingUnitsTF.setText(sel.getUnitsAndStyle());
		ingNameTF.setEditable(true);
		ingQuantityTF.setEditable(true);
		ingUnitsTF.setEditable(true);
		yesBT.setOnAction(e ->
		{
			ingTD.remove(sel);
			Ingredient i = new Ingredient();
			i.setName(ingNameTF.getText());
			i.setQuantity(Double.parseDouble(ingQuantityTF.getText()));
			i.setUnitsAndStyle(ingUnitsTF.getText());
			ingTD.add(i);
			twoStage.close();
		});
		noBT.setOnAction(e -> twoStage.close());
	}
	private void buildDel()throws Exception
	{
		Ingredient sel = ingredientsTbl.getSelectionModel().getSelectedItem();
		ingNameTF.setText(sel.getName());
		ingQuantityTF.setText(String.format("%f",sel.getQuantity()));
		ingUnitsTF.setText(sel.getUnitsAndStyle());
		ingNameTF.setEditable(false);
		ingQuantityTF.setEditable(false);
		ingUnitsTF.setEditable(false);
		yesBT.setOnAction(e ->
		{
			ingTD.remove(sel);
			twoStage.close();
		});
		noBT.setOnAction(e -> twoStage.close());
	}
	private void buildAdd()throws Exception
	{
		ingNameTF.clear();
		ingQuantityTF.clear();
		ingUnitsTF.clear();
		ingNameTF.setEditable(true);
		ingQuantityTF.setEditable(true);
		ingUnitsTF.setEditable(true);
		yesBT.setOnAction(e ->
		{
			Ingredient i = new Ingredient();
			i.setName(ingNameTF.getText());
			i.setQuantity(Double.parseDouble(ingQuantityTF.getText()));
			i.setUnitsAndStyle(ingUnitsTF.getText());
			ingTD.add(i);
			twoStage.close();
		});
		noBT.setOnAction(e -> twoStage.close());
	}

	public void showViewRecipeStage()
	{
		/*
		 * TO DO: To present a stage to view and/or update the recipe selected
		 * in the table view
		 */
		try {
			Recipe recipe = tableView.getSelectionModel().getSelectedItem();
			int recipeID = recipe.getID();
			List<Ingredient> ingredients = recipeDSC.findAllIngredients(recipeID);
			ingTD.clear();
			ingTD.addAll(ingredients);
			ingredientsTbl.setItems(ingTD);
			idTF.setText("" + recipeID);
			nameTF.setText(recipe.getName());
			servesTF.setText("" + recipe.getServes());
			stepsTA.setText(recipe.getSteps());
			remarksTF.setText(recipe.getRemarks());

			ingredientsHBox.getChildren().setAll(ingredientsLblAndTbl,ingredientButtons);
			actionHBox.getChildren().setAll(updateBT,cancelBT);
			root.getChildren().setAll(idHBox,nameHBox,servesHBox,ingredientsHBox,stepsHBox,remarksHBox,actionHBox);

			updateBT.setOnAction(e ->{
				try {
					int rID = Integer.parseInt(idTF.getText());
					Recipe newR = new Recipe(rID, nameTF.getText(), Integer.parseInt(servesTF.getText()), stepsTA.getText(), remarksTF.getText());
					newR.setIngredients(ingTD);
					recipeDSC.updateRecipe(newR);
					int index = -1;
					for(int i = 0; i < tableData.size(); ++i)
					{
						if(tableData.get(i).getID() == newR.getID())
						{
							index = i;
							break;
						}
					}
					if(index == -1) throw new NullPointerException();

					tableData.get(index).setIngredients(newR.getIngredients());
					tableData.get(index).setName(newR.getName());
					tableData.get(index).setRemarks(newR.getRemarks());
					tableData.get(index).setServes(newR.getServes());
					tableData.get(index).setSteps(newR.getSteps());
					stage.close();
				}catch(Exception exc)
				{
					System.out.println("Couldn't Update.");
					System.out.println(exc.toString());
				}
			});

			scene.setRoot(root);
			stage.setScene(scene);
			stage.show();
		} catch(Exception exc){
			System.out.println("No Item Selected");
			System.out.println(exc.toString());
		}
	}

	public void showAddRecipeStage()
	{
		/*
		 * TO DO: To present a stage to add a recipe
		 */
		ingTD.clear();
		ingredientsTbl.setItems(ingTD);
		nameTF.clear();
		servesTF.clear();
		stepsTA.clear();
		remarksTF.clear();

		actionHBox.getChildren().setAll(addBT,cancelBT);
		ingredientsHBox.getChildren().setAll(ingredientsLblAndTbl,ingredientButtons);
		root.getChildren().setAll(nameHBox,servesHBox,ingredientsHBox,stepsHBox,remarksHBox,actionHBox);

		addBT.setOnAction(e ->{
			try {
				int rID = recipeDSC.addRecipe(nameTF.getText(), Integer.parseInt(servesTF.getText()), stepsTA.getText(), remarksTF.getText());
				Recipe r = recipeDSC.find(rID);
				for(Ingredient I : ingTD) {
					r.addIngredient(I);
					recipeDSC.addIngredient(I,rID);
				}
				tableData.add(r);
				stage.close();
			}catch(Exception exc)
			{
				System.out.println("could not add recipe using those values");
				System.out.println(exc.toString());
			}
		});

		scene.setRoot(root);

		stage.setScene(scene);
		stage.show();
	}

	public void showDeleteRecipeStage() throws SQLException
	{
		/*
		 * TO DO: To present a stage to delete the recipe selected in
		 * the table view
		 */
		try {
			Recipe recipe = tableView.getSelectionModel().getSelectedItem();
			int recipeID = recipe.getID();
			List<Ingredient> ingredients = recipeDSC.findAllIngredients(recipeID);
			ingTD.clear();
			ingTD.addAll(ingredients);
			ingredientsTbl.setItems(ingTD);
			idTF.setText("" + recipeID);
			nameTF.setText(recipe.getName());
			servesTF.setText("" + recipe.getServes());
			remarksTF.setText(recipe.getRemarks());

		actionHBox.getChildren().setAll(deleteBT,cancelBT);
		ingredientsHBox.getChildren().setAll(ingredientsLblAndTbl);
		root.getChildren().setAll(idHBox,nameHBox,servesHBox,ingredientsHBox,remarksHBox,actionHBox);

		deleteBT.setOnAction(e -> {
			try {
				recipeDSC.deleteRecipe(recipe);
				tableData.remove(recipe);
				stage.close();
			}catch(Exception exc)
			{
				System.out.println("Couldn't delete.");
				System.out.println(exc.toString());
			}
		});


		scene.setRoot(root);
		stage.setScene(scene);
		stage.show();
		} catch(NullPointerException exc){
			System.out.println("No Item Selected");
			System.out.println(exc.toString());
		}
	}
}
