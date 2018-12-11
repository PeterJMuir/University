/**
 * All done
 * this class is intended to hold all the data related to Recipe with all variable names matching those of the server side java Recipy
 * thins means that we can use JSON.stringify and get a perfectly compatable JSON string
 * Take not of the /** ... * / js docs, they will help in most IDEs by alowing the IDE to show auto-compleate sugestions 
 *      and give you warnings if you accadently assign the wrong type of vale to a variable 
 * Auther: Keith Rogers
 * Last updated: 24-09-2017
 */

/**
 * @typedef {object} RecipeFromJson
 * @property {Number} ID
 * @property {String} name
 * @property {Number} serves
 * @property {IngredientFromJson[]} ingredients
 * @property {String} steps
 * @property {String} remarks
 */

/**
 * @param {RecipeFromJson} [recDataFromJson]
 * @constructor
 * @property {Number} ID
 * @property {String} name
 * @property {Number} serves
 * @property {Ingredient[]} ingredients
 * @property {String} steps
 * @property {String} remarks
 *
 * @property {function} set
 * @property {function} deepClone
 *
 */

Recipe = function(recDataFromJson)
{
    this.ID = -1;
    this.name = "Type Recipe Name";
    this.serves = 1;
    this.ingredients = new Array();
    this.steps = "Type Steps";
    this.remarks = "-";

    if(recDataFromJson !== undefined)
    {
        if (recDataFromJson.ID !== undefined) this.ID = recDataFromJson.ID;
        if (recDataFromJson.name !== undefined) this.name = recDataFromJson.name;
        if (recDataFromJson.serves !== undefined) this.serves = recDataFromJson.serves;
        if (recDataFromJson.steps !== undefined) this.steps = recDataFromJson.steps;
        if (recDataFromJson.remarks !== undefined) this.remarks = recDataFromJson.remarks;

        if (recDataFromJson.ingredients && typeof recDataFromJson.ingredients === 'object' && recDataFromJson.ingredients.constructor === Array) {
            for (var i = 0, len = recDataFromJson.ingredients.length; i < len; i++) {
                this.ingredients.push(new Ingredient(recDataFromJson.ingredients[i]))
            }
        }
    }
};

/**
 * @param {Recipe} otherRecipe
 */
Recipe.prototype.set = function(otherRecipe)
{
    if (otherRecipe.ID !== undefined) this.ID = otherRecipe.ID;
    if (otherRecipe.name !== undefined) this.name = otherRecipe.name;
    if (otherRecipe.serves !== undefined) this.serves = otherRecipe.serves;
    if (otherRecipe.steps !== undefined) this.steps = otherRecipe.steps;
    if (otherRecipe.remarks !== undefined) this.remarks = otherRecipe.remarks;

    this.ingredients = new Array();
    if (otherRecipe.ingredients && typeof otherRecipe.ingredients === 'object' && otherRecipe.ingredients.constructor === Array) {
        for (var i = 0, len = otherRecipe.ingredients.length; i < len; i++) {
            this.ingredients.push(new Ingredient(otherRecipe.ingredients[i]))
        }
    }

};
/**
 * create a copy of this recipe
 * Note: because objects in javascript are all assigned by reference make sure that you also clone each ingredient
 * @returns {Recipe}
 */
Recipe.prototype.deepClone = function()
{
    var recipe = new Recipe();
    recipe.set(this);
    return recipe;
};

/**
 * returns a string of ingredients names used in the main page table ingredients column
 * @returns {String} names
 */

Recipe.prototype.getIngredientsNames = function()
{
    var ingredientString = "";
    for (var i = 0, len = this.ingredients.length; i < len; i++)
    {
        if (ingredientString !== "")
        {
            ingredientString += ", "
        }
        ingredientString += this.ingredients[i].name;
    }
    return ingredientString;
}