/* CSE3OAD
* Modified by: Peter MUIR
* Student Number and Username: 18477719
* Used with RecipeDSC (user: root)
* */

import java.util.ArrayList;
import java.util.List;

public class Recipe
{
	private int ID;
	private String name;
	private int serves;
	private List<Ingredient> ingredients;
	private String steps;
	private String remarks;

	public Recipe(int ID, String name, int serves, String steps, String remarks)
	{
		this.ID = ID;
		this.name = name;
		this.serves = serves;
		this.steps = steps;
		this.remarks = remarks;
		this.ingredients = new ArrayList<>();
	}
	public Recipe(String name, int serves, String steps, String remarks)
	{
		this.ID = -1;
		this.name = name;
		this.serves = serves;
		this.steps = steps;
		this.remarks = remarks;
		this.ingredients = new ArrayList<>();
	}

	public Ingredient getIngredientByID(int ingID)
	{
		for (Ingredient I: ingredients)
		{
			if (I.getID() == ingID)
			{
				return  I;
			}
		}
		return null;
	}

	public String getIngredientString()
	{
		String string = null;
		for(Ingredient I: ingredients)
		{
			if(null == string)
			{
				string = I.getName();
			}else {
				string = string + ", " + I.getName();
			}
		}
		return string;
	}

	public int getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getServes()
	{
		return serves;
	}

	public void setServes(int serves)
	{
		this.serves = serves;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getSteps()
	{
		return steps;
	}

	public void setSteps(String steps)
	{
		this.steps = steps;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public void addIngredient(Ingredient ingredient)
	{
		this.ingredients.add(ingredient);
	}

	public void update(String name, int serves,
		String steps, String remarks)
	{
		this.name = name;
		this.serves = serves;
		this.steps = steps;
		this.remarks = remarks;
	}

	@Override
	public String toString()
	{
		return "\nRecipe{\n\t" +
		  "ID: " + ID + "\n\t" +
		  "name: " + name + "\n\t" +
		  "serves: " + serves + "\n\t" +
		  "ingredients: " + ingredients + "\n\t" +
		  "steps: " +  steps  + "\n\t" +
		  "remarks = " + remarks + "}\n";
	}

	@Override
	public boolean equals(Object obj)
	{
		return
			obj != null &&
			obj instanceof Recipe &&
			((Recipe) obj).getID() == this.ID;
	}
}