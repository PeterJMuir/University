/* 
*	Name: Peter Muir
*	Student ID: 18477719
 */


var app = angular.module("myApp", []);

app.controller("myController", function($scope, $http, $window) {
    // initialise model
        // set 'ng-show's
        // set selected to null
    // load data function
    // addRecipe
    // addIngredient
    // updateRecipe
    // updateIngredient
    // deleteRecipe
    // deleteIngredient

    //default model (scope) values
    /** @type {boolean} */
    $scope.showMain = true;
    /** @type {boolean} */
    $scope.showAdd = false;
    /** @type {boolean} */
    $scope.showEdit = false;
    /** @type {boolean} */
    $scope.showDisplay = false;

    /** @type {null|Recipe} */
    $scope.selectedRecipe = null;
    /** @type {null|Ingredient} */
    $scope.selectedIngredient = null;
    /**
     * for folding potentially discardable changes made in update and add pages
     * @type {null|Recipe}
     */
    $scope.tempRecipe = null;
    /** @type {String} */
    $scope.filterString = "";

    /** @type {boolean} */
    $scope.sortByName = false;

    /** @type {Recipe[]} */
    $scope.recipes = new Array();

    /*	helper functions to show/hide included HTML pages
	*/
	/**
	 * used when swaping between pages
	 */
    $scope.reset = function()
    {
        $scope.showMain = false;
        $scope.showAdd = false;
        $scope.showEdit = false;
        $scope.showDisplay = false;
    };
	/**
	 * show the main page 
	 * set selected things and tempRecipe to null
	 */
    $scope.openMain = function() {
        $scope.reset();
        $scope.showMain = true;

        //set selected things and tempRecipe to null
        $scope.selectedRecipe = null;
        $scope.selectedIngredient = null;
        $scope.tempRecipe = null;
    };
	/**
	 * alow the user to add a new recipe
	 * show the add page 
	 * NOTE: remember the user sould be editing properties of the tempRecipy untill they click save
	 */
    $scope.openAdd = function() {
		$scope.reset();
		$scope.showAdd = true;
		$scope.selectedRecipe = null;
		$scope.selectedIngredient = null;
        $scope.tempRecipe = new Recipe();
        //TODO see description above
    };
	/**
	 * alow the user to edit the selected recipe
	 * alert the use if there is no recipy currently selected and return
	 * else show the edit page 
	 * NOTE: remember the user sould be editing properties of the tempRecipy untill they click save
	 */
    $scope.openEdit = function() {
		if($scope.selectedRecipe === null)
        {
			alert("Please select a recipe to edit");
            return;
        }else
		{
			$scope.reset();
			$scope.showEdit = true;
			$scope.selectedIngredient = new Ingredient();
			$scope.tempRecipe = $scope.selectedRecipe.deepClone();
		}
        //TODO see description above
    };
	
	/**
	 * display the select recipe
	 * alert the use if there is no recipy currently selected and return
	 * else show the display page 
	 */
    $scope.openDisplay = function(){
		if($scope.selectedRecipe === null)
        {
            alert("Please select a recipe to display");
            return;
        }else
		{
			$scope.reset();
			$scope.showDisplay = true;
			$scope.selectedIngredient = null;
		}
        //TODO see description above
    };

    /*	To support edit and delete of recipes
		Called when we click to select a row in the table
		See the <tr> element that we use to display the table
	*/
    $scope.setSelectedRecipe = function(recipe){
        $scope.selectedRecipe = recipe;
    };

    /*	To support edit and delete of ingredients on the add and edit pages
		Called when we click to select a row in the table
		See the <tr> element that we use to display the table
	*/
    $scope.setSelectedIngredient = function(ingredient) {
        $scope.selectedIngredient = ingredient;
    };


	/**
	 * load all recipes from the database into $scope.recipes
	 * console log or alert in the case of errors 
	 */
    $scope.load = function()
    {
        // alert("Call getAllproducts");
        var connection = $http({
			method: "get",
			url: "http://localhost:8080/Assignment2/RecipeWS"
		})
		.then(function(response){
			var JSONDataArray = response.data;
			$scope.recipes = new Array(); //to make recipes a js array and hence have the push(..) function

			for(var i = 0, len = JSONDataArray.length; i < len; i++){
				 $scope.recipes.push(new Recipe(JSONDataArray[i]));
			}
			// TODO handle successfull responce
		})
		.catch(function(response){
			// TODO handle error responce (ie when http resonce != 200)
		});
    };

	/**
	 * add new ingredinet to tempRecipe and set as selected so that the use can 
	 * start updatign the new ingredient from the default vaues
	 */
    $scope.addIngredient = function(){
        //TODO see description above
		$scope.setSelectedIngredient(new Ingredient());
		$scope.tempRecipe.ingredients.push($scope.selectedIngredient);
    };

	/**
	 * flag select ingredient for deleation
	 * if there is no ingredient selected show an alert to the user and return
	 * else set deleted = true
	 */
    $scope.flagIngredientDeleted = function(){
        if($scope.selectedIngredient === null)
		{
			alert("Please select an ingredient");
			return;
		}else
		{
			$scope.selectedIngredient.deleted = true;
		}
    };

	/**
	 * update database based on the tempRecipe
	 * if succesfully updated on the database also udpate the selected recipy (with all generated IDs)
	 * then go back to main
	 * console log or alert in the case of errors 
	 */
    $scope.updateRecipe = function(){
        var connection = $http({
			method: "put",
			url: "http://localhost:8080/Assignment2/RecipeWS?ID="+$scope.tempRecipe.ID,
			data: JSON.stringify($scope.tempRecipe)
		})
		.then(function(response){
			$scope.selectedRecipe.set(response.data);
			$scope.openMain();
		})
		.catch(function(response){
			console.log(response);
			// TODO handle error responce (ie when http resonce != 200)
		});
    };

	/**
	 * add the temp recipy to the database
	 * if succesfully added to the database also insert it into $scope.recipes (with all generated IDs)
	 * then go back to main
	 * console log or alert in the case of errors 
	 */
    $scope.addRecipe = function(){
        var connection = $http({
			method: "post",
			url: "http://localhost:8080/Assignment2/RecipeWS?ID="+$scope.tempRecipe.ID,
			data: JSON.stringify($scope.tempRecipe)
		})
		.then(function(response){
			$scope.recipes.push(new Recipe(response.data));
			$scope.openMain();
		})
		.catch(function(response){
			console.log(response);
			// TODO handle error responce (ie when http resonce != 200)
		});
    };

	/**
	 * delete select recipe
	 * if there is no recipy selected show an alert to the user and return
	 * show a confirm alert to make sure the user wants to delete
	 * if so perform the delete
	 * console log or alert in the case of errors 
	 */
    $scope.deleteRecipe = function()
    {
        if($scope.selectedRecipe === null)
        {
            alert("Please select a recipe to delete");
            return;
        }
        if(confirm('Are you sure you want to delete the recipe?'))
        {
            //console.log($scope.selectedRecipe);
            var connection = $http({
				method: "delete",
				url: "http://localhost:8080/Assignment2/RecipeWS?ID="+$scope.selectedRecipe.ID,
                // TODO make rewuest
            })
            .then(function(response){
				var index = $scope.recipes.indexOf($scope.selectedRecipe);
				$scope.recipes.splice(index,1);
				$scope.selectedRecipe = null;
                // TODO handle successfull responce
            })
            .catch(function(response){
				console.log(response.data);
                // TODO handle error responce (ie when http resonce != 200)
            });
        }
        else
        {
            console.log("no delete");
        }
    };

	/**
	 *
	 */
    $scope.setSortOrder = function(){
		$scope.sortByName = !($scope.sortByName);
        console.log("$scope.sortByName = " + $scope.sortByName);
        if($scope.sortByName)
        {
            console.log("$scope.sortOrder = 'name';");
            $scope.sortOrder = 'name';
        }
        else
        {
            console.log("$scope.sortOrder = 'id';");
            $scope.sortOrder = 'id';
        }

    };

});