/**
 * All done
 * this class is intended to hold all the data related to an inredient with all variable names matching those of the server side java Ingredient
 * thins means that we can use JSON.stringify and get a perfectly compatable JSON string
 * Take not of the /** ... * / js docs, they will help in most IDEs by alowing the IDE to show auto-compleate sugestions 
 *      and give you warnings if you accadently assign the wrong type of vale to a variable 
 * Auther: Keith Rogers
 * Last updated: 24-09-2017
 */

/**
 * @typedef {object} IngredientFromJson
 * @property {Number} ID
 * @property {String} name
 * @property {Number} quantity
 * @property {String} unitsAndStyle
 */

/**
 * 
 *
 * @param {IngredientFromJson} [ingDataFromJson]
 * @constructor
 * @property {Number} ID
 * @property {String} name
 * @property {Number} quantity
 * @property {String} unitsAndStyle
 * @property {Boolean} deleted
 */
Ingredient = function (ingDataFromJson)
{
    this.ID = -1;
    this.name = "Type Ingredient Name";
    this.quantity = 1;
    this.unitsAndStyle = "eg grams or sliced";
    this.deleted = false;

    if(ingDataFromJson !== undefined)
    {
        if(ingDataFromJson.ID !== undefined) this.ID = ingDataFromJson.ID;
        if(ingDataFromJson.name !== undefined) this.name = ingDataFromJson.name;
        if(ingDataFromJson.quantity !== undefined) this.quantity = ingDataFromJson.quantity;
        if(ingDataFromJson.unitsAndStyle !== undefined) this.unitsAndStyle = ingDataFromJson.unitsAndStyle;
    }
};
/**
 *
 * @param {Ingredient} otherIngredient
 */
Ingredient.prototype.set = function(otherIngredient)
{
    if(otherIngredient.ID !== undefined) this.ID = otherIngredient.ID;
    if(otherIngredient.name !== undefined) this.name = otherIngredient.name;
    if(otherIngredient.quantity !== undefined) this.quantity = otherIngredient.quantity;
    if(otherIngredient.unitsAndStyle !== undefined) this.unitsAndStyle = otherIngredient.unitsAndStyle;
    if(otherIngredient.deleted !== undefined) this.deleted = otherIngredient.deleted;
};
/**
 * @returns {Ingredient}
 */
Ingredient.prototype.deepClone = function()
{
    var ingredient = new Ingredient();
    ingredient.set(this);
    return ingredient;
};
