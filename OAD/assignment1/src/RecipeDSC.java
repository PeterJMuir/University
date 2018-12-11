/* CSE3OAD
* Modified by: Peter MUIR
* Student Number and Username: 18477719
* Used with RecipeDSC (user: root)
* */
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeDSC
{
	private  Connection connection;
	private  Statement statement;
	private  PreparedStatement preparedStatement;
	private String username = null;
	private String password = null;
	private String url = null;

	private boolean useAlertForInput = true;

	public String getInfoFromUser( String userInstructions)
	{
		if (useAlertForInput) {
			final TextInputDialog inputDlg = new TextInputDialog("");
			//inputDlg.initOwner(parent);
			inputDlg.setTitle("information Required");
			inputDlg.setContentText(userInstructions);
			inputDlg.setHeaderText(null);
			inputDlg.initModality(Modality.APPLICATION_MODAL);
			Optional<String> userResponce = inputDlg.showAndWait();
			while (!userResponce.isPresent())
				userResponce = inputDlg.showAndWait();
			return userResponce.get();

		}
		try {
			System.out.println(userInstructions);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		return "";
	}

	public  void connect() throws SQLException
	{
		 //String url = "jdbc:mysql://latcs7.cs.latrobe.edu.au:3306/username";
		 //url = "jdbc:mysql://localhost:3306";
		 //username = "root";
		//password = "";

		if  (url == null) {
			String userResponce = getInfoFromUser( "Please enter your database url");
			if (userResponce == "") url ="jdbc:mysql://localhost:3306/recipedb";
			else url = userResponce;
		}
		if (username == null) {
			username = getInfoFromUser( "Please enter your database username for " + url);
		}
		if (password == null) {
			password = getInfoFromUser( "Please enter your database password for user: " + username);
		}
		connection = DriverManager.getConnection(url, username, password);
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("use recipedb");
		preparedStatement.executeQuery();
	}

	public  void disconnect() throws SQLException
	{
		if (preparedStatement != null) preparedStatement.close();
		if (statement != null) statement.close();
		if (connection != null) connection.close();
	}


	/*
	 * TODO: 	This method should find a Recipe with the given id.
	 * @param 	id The id of the Recipe to be found.
	 * @return 	The Recipe with the given id if it exists. Otherwise return null.
	 * @throws 	SQLException
	 */
	public Recipe find(int id) throws SQLException
	{
		connect();

		String queryString = "select * from recipes where ID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();

		Recipe recipe = null;

		if (rs.next())
		{	// Recipe exists in database
			recipe = new Recipe(
					rs.getInt("ID"),
					rs.getString("name"),
					rs.getInt("serves"),
					rs.getString("steps"),
					rs.getString("remarks"));
		}
		queryString = "select * from recipeingredients where recipeID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1, id);
		rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			recipe.addIngredient(new Ingredient(rs.getInt("ID"),rs.getString("name"),
					rs.getDouble("quantity"),rs.getString("unitsAndStyle")));
		}

		disconnect();

		return recipe;
	}

	/*
	 * TODO: 	This method should count the total number of Recipes in the database
	 * @return 	An int representing the number of Recipes
	 * @throws 	SQLException
	 */
	public int count() throws SQLException
	{
		connect();

		int count = 0;
		String queryString = "select Count(*) AS t from recipes";
		preparedStatement = connection.prepareStatement(queryString);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()) {
			count = rs.getInt("t");
		}
		disconnect();
		return count;
	}


	/**
	 * TODO: 	This method should obtain and return  the list of all Recipes
	 * 			from the database
	 * @return 	The list of all Recipes stored in the database
	 * @throws 	SQLException
	 */
	public List<Recipe> findAll() throws SQLException
	{
		List<Recipe> recipeList = new ArrayList<Recipe>();
		connect();
		String queryString = "select * from recipes";
		preparedStatement = connection.prepareStatement(queryString);
		ResultSet rs = preparedStatement.executeQuery();

		Recipe recipe = null;
		List<Ingredient> ingList = null;
		while (rs.next())
		{	// Recipe exists in database
			recipe = new Recipe(
					rs.getInt("ID"),
					rs.getString("name"),
					rs.getInt("serves"),
					rs.getString("steps"),
					rs.getString("remarks"));
			queryString = "select * from recipeingredients where recipeID = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, recipe.getID());
			ResultSet ps = preparedStatement.executeQuery();
			ingList = new ArrayList<>();
			Ingredient ing = null;
			while(ps.next()){
				ing = new Ingredient(
						ps.getInt("ID"),
						ps.getString("name"),
						ps.getDouble("quantity"),
						ps.getString("unitsAndStyle"));
				ingList.add(ing);
			}
			recipe.setIngredients(ingList);
			recipeList.add(recipe);
		}

		disconnect();
		return recipeList;
	}

	/**
	 * TODO: 	This method should obtain and return  the list of all Ingredients for a given recipe ID
	 * 			from the database
	 * @return 	The list of Ingredients
	 * @throws 	SQLException
	 */

	public List<Ingredient> findAllIngredients(int recipeID) throws SQLException
	{
		List<Ingredient> ingList = new ArrayList<>();
		connect();
		String queryString = "Select * from recipeingredients where recipeID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,recipeID);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			ingList.add(new Ingredient(rs.getInt("ID"),rs.getString("name"),rs.getDouble("quantity"),
					rs.getString("unitsAndStyle")));
		}
		disconnect();
		return ingList;
	}

	/*
	 * TODO: 	This method should try to add a new Ingredient with the details
	 * 			provided by the parameters
	 *	@param 	All the details of the recipe to be added (except the id)
	 *	@return 	The id of the recipe (which is generated by the database)
	 * @throws 	SQLException
	 */
	public int addIngredient(int recipeID, String name, double quantity, String unitsAndStyle) throws SQLException {
		connect();
		String queryString = "insert into recipeingredients (recipeID, name, quantity, unitsAndStyle)" +
				" values (?,?,?,?)";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,recipeID);
		preparedStatement.setString(2,name);
		preparedStatement.setDouble(3,quantity);
		preparedStatement.setString(4,unitsAndStyle);
		preparedStatement.executeUpdate();
		queryString = "select ID from recipeingredients where recipeID = ? and name = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,recipeID);
		preparedStatement.setString(2,name);
		ResultSet rs = preparedStatement.executeQuery();
		int id = 0;
		if(rs.next()) id = rs.getInt("ID");
		disconnect();
		return id;
	}
	public int addIngredient(Ingredient ingredient, int recipeID) throws SQLException {
		return addIngredient(recipeID,ingredient.getName(),ingredient.getQuantity(),ingredient.getUnitsAndStyle());
	}

	/*
	 * TODO: 	This method should try to updated an existing Recipe with the details
	 * 			provided by the parameters
	 *	@param 	All the details of the recipe to be added (except the id)
	 *  @throws 	SQLException
	 */
	public int updateIngredient(int ingredientID, String name, double quantity, String unitsAndStyle) throws SQLException {
		connect();
		String queryString = "UPDATE recipeingredients " +
				"SET name = ?, quantity = ?, unitsAndStyle = ? " +
				"WHERE ID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setString(1,name);
		preparedStatement.setDouble(2,quantity);
		preparedStatement.setString(3,unitsAndStyle);
		preparedStatement.setInt(4,ingredientID);
		int i = preparedStatement.executeUpdate();
		disconnect();
		return i;
	}
	public int updateIngredient(Ingredient ingredient) throws SQLException {
		return updateIngredient(ingredient.getID(),ingredient.getName(),ingredient.getQuantity(),ingredient.getUnitsAndStyle());
	}

	/*
	 * TODO: 	This method should try to delete an existing Recipe with the details
	 * 			provided by the parameters
	 *	@param 	Ingredient ID
	 *  @throws 	SQLException
	 */
	public int deleteIngredient(int ingredientID) throws SQLException {
		connect();
		String queryString = "DELETE FROM recipeingredients " +
				"WHERE ID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,ingredientID);
		int i = preparedStatement.executeUpdate();
		disconnect();
		return i;
	}
	public int deleteIngredient(Ingredient ingredient) throws SQLException {
		return deleteIngredient(ingredient.getID());
	}

	/*
	 * TODO: 	This method should try to add a new Recipe with the details
	 * 			provided by the parameters
	 *	@param 	All the details of the recipe to be added (except the id)
	 *	@return 	The id of the recipe (which is generated by the database)
	 *  @throws 	SQLException
	 */
	public int addRecipe(String name, int serves, String steps, String remarks) throws SQLException
	{
		connect();
		String queryString = "insert into recipes (name, serves, steps, remarks)" +
				" values (?,?,?,?)";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setString(1,name);
		preparedStatement.setInt(2,serves);
		preparedStatement.setString(3,steps);
		preparedStatement.setString(4,remarks);
		preparedStatement.executeUpdate();
		queryString = "select ID from recipes where name = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setString(1,name);
		ResultSet rs = preparedStatement.executeQuery();
		int id = 0;
		if(rs.next()) id = rs.getInt("ID");
		disconnect();
		return id;
	}

	/*
	 * TODO: 	This method should try to add the given Recipe to the database.
	 * @param 	recipe - The recipe object which contains details of the new recipe
	 * @throws 	SQLException
	 */

	public int addRecipe(Recipe recipe) throws SQLException
	{
		int id = addRecipe(recipe.getName(),recipe.getServes(),recipe.getSteps(),recipe.getRemarks());
		//	then add each of the ingredients
		for(Ingredient I: recipe.getIngredients())
		{
			addIngredient(I,recipe.getID());
		}
		return id;
	}

	/**
	 * TODO: 	This method should try to update an existing Recipe using the
	 * 			details provided by the given Recipe parameter. All the details,
	 *	`			except the id, can be updated
	 * @param 	recipe - The Recipe instance that contains details to be used for
	 * 			updating
	 * @throws 	SQLException
	 */
	public void updateRecipe(Recipe recipe) throws SQLException
	{
		connect();
		//update ingredients first
		//delete all old ingredients
		String queryString = "delete from recipeingredients " +
				"where recipeID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,recipe.getID());
		preparedStatement.executeUpdate();
		//add all ingredients from new recipe
		for(Ingredient I: recipe.getIngredients())
		{
				addIngredient(recipe.getID(), I.getName(), I.getQuantity(), I.getUnitsAndStyle());
		}
		//reconnect and update recipe
		connect();
		queryString = "update recipes " +
				"set name = ?, serves = ?, steps = ?, remarks = ? " +
				"where ID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setString(1,recipe.getName());
		preparedStatement.setInt(2,recipe.getServes());
		preparedStatement.setString(3,recipe.getSteps());
		preparedStatement.setString(4,recipe.getRemarks());
		preparedStatement.setInt(5,recipe.getID());
		preparedStatement.executeUpdate();
		disconnect();
	}


	/**
	 * TODO: 	This method should try to delete a Recipe  from the database
	 * @param 	id - The id of the Recipe to be deleted
	 * @throws 	SQLException
	 */

	public void deleteRecipe(int id) throws SQLException
	{
		connect();
		//delete ingredients first
		String queryString = "DELETE FROM recipeingredients " +
				"WHERE recipeID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,id);
		preparedStatement.executeUpdate();
		//delete recipe
		queryString = "DELETE FROM recipes " +
				"WHERE ID = ?";
		preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1,id);
		preparedStatement.executeUpdate();
		disconnect();
	}


	/**
	 * TODO: 	This method should try to delete a Recipe from the database
	 * @param 	recipe - The Recipe object which contains the id of the recipe
	 *				to be deleted
	 * @throws 	SQLException
	 */
	public void deleteRecipe(Recipe recipe) throws SQLException
	{
		deleteRecipe(recipe.getID());
	}

	// This method provide a few basic tests of the  DSC class
	//

	public void setUseAlertForInput(boolean value)
	{
		useAlertForInput = value;
	}

	public static void main(String [] args) throws Exception
	{
		///*

		RecipeDSC dsc = new RecipeDSC();
		dsc.setUseAlertForInput(false); //this changes the program to use command prompt instead
		//dsc.getPassword();
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Test 1 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

		List<Recipe> list = dsc.findAll();
		System.out.println(list);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Test 2 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

		Recipe recipe = dsc.find(4);
		System.out.println(recipe);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Test 3 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

		recipe = dsc.find(100);
		System.out.println(recipe);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Test 4 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

		int ID = dsc.addRecipe("name 200", 100, "step 1 , 2, 3, 4", "easy");
		System.out.println("ID: " + ID);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- Test 5 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

		int ingredientID = dsc.addIngredient(ID, "ingredient", 20, "grams");
		System.out.println("ingredientID: " + ingredientID);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Test 6 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");

		recipe = dsc.find(4);
		recipe.setName("Drunken chicken zoo");
		recipe.setServes(100);
		Ingredient i = new Ingredient();
		i.setName("Drunken chicken");
		i.setQuantity(10);
		i.setUnitsAndStyle("");
		recipe.addIngredient(i);
		i = new Ingredient();
		i.setName("RICE");
		i.setQuantity(100);
		i.setUnitsAndStyle("kg");
		recipe.addIngredient(i);

		recipe.setSteps("\n1. Cook chicken\n2.Cook rice");
		recipe.setRemarks("Enjoy the festival!");

		System.out.println(">>> updated recipe: " + recipe);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Test 7 _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");


		dsc.updateRecipe(recipe);
		recipe = dsc.find(4);
		System.out.println(">>> updated recipe from database: " + recipe);
		System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
		//*/
	}
}
