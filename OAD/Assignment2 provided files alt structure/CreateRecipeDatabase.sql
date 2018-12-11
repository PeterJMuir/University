--	This is a MySQL script to
--		Create a database
--		Create a table
--		Add some data to the table

-- for personal computers
DROP database if EXISTS recipeDB;
CREATE database recipeDB;
USE recipeDB;

-- for unix account
-- USE <your Student Database>;
-- DROP TABLE IF EXISTS recipeIngredients
-- DROP TABLE IF EXISTS recipes

CREATE TABLE recipes(
    ID INT auto_increment,
    name VARCHAR(50) NOT NULL,
    serves int,
    steps TEXT,
    remarks VARCHAR(100),
    PRIMARY KEY (ID)
);

CREATE TABLE recipeIngredients(
    ID INT NOT NUll auto_increment,
    recipeID INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    quantity DECIMAL(6,2) NOT NULL,
    unitsAndStyle VARCHAR(50) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (recipeID) REFERENCES recipes(ID)
);

-- Populate the database with some data

INSERT INTO recipes	(name, serves, steps, remarks)	-- nr 1
VALUES('Breakfast Quinoa', 3,
"\nBring milk to a boil\nAdd quinoa and return to a boil\nSimmer for 15 minutes\nAdd 3/4 of banana and raspberries\nCook until all milk is absorbed\nAdd remaing banana and raspberries",
'1300 KJ per serve'
);
-- create a sql variable using a select statement to get the auto incremented ID of the 'Breakfast Quinoa' recipe
Select @currentRecipeID := ID FROM recipes WHERE name = 'Breakfast Quinoa';
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'ALMOND MILK', 2, 'cups');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'QUINOA', 1, 'cup');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'BANANA', 1, 'sliced');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'RASPBEERRIES', 1, 'cup');

INSERT INTO recipes 	(name, serves, steps, remarks)	-- nr 2
VALUES( 'Sweet Potato Ham Fritters', 4,
'\n1. Beat the eggs in a large bowl.\n2. Add sweet potato and ham.\n3. heat 2 spoons of oive oil in  frying pan.\n4. Spoon the batter and cook until brown on each side.',
'High in fibre, low in carbohydrate'
);
Select @currentRecipeID := ID FROM recipes WHERE name = 'Sweet Potato Ham Fritters';
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'EGGS', 4, '');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'SWEET POTATO', 2, 'cups mashed');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'SMOKE HAM', 100, 'grams');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'OLIVE OIL', 1, 'tbs');


INSERT INTO recipes	(name, serves, steps, remarks)	-- nr 3
VALUES( 'Yoghurt Parfait', 1,
'\nMix brown rice and yoghurt\nAdd blueberries and almond\nSpoon into a parfait glass to serve',
'1628 KJ per serve'
);
Select @currentRecipeID := ID FROM recipes WHERE name = 'Yoghurt Parfait';
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'BROWN RICE', 0.5, 'cups cooked');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'FAT-FREE YOGHURT', 100 , 'grams');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'BLUEBERRIES', 50, 'grams');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'ALMOND', 30 , 'grams');

INSERT INTO recipes 	(name, serves, steps, remarks)	-- nr 4
VALUES('Balsamic Chicken with Creamy Mash', 4,
'\nSlice chicken into thin tenderloins\nMarinate in vinegar for 20 minutes\nHeat chicken at 180 degrees for 10 minuts\nPeel potato and boil them until tender\nDrain potato, and mash until smooth\nAdd chopped avacado and mash\nSpoon mash into a bowl and top with chicken strips',
'Low in energy'
);
Select @currentRecipeID := ID FROM recipes WHERE name = 'Balsamic Chicken with Creamy Mash';
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'CHICKEN BREAST', 500, 'grams');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'BALSAMIC VINEGAR', 0.25 , 'cup');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'GOLD POTATO', 700, 'grams');
INSERT INTO recipeIngredients (recipeID, name, quantity, unitsAndStyle)
Values (@currentRecipeID, 'AVOCADO', 300, 'grams');


-- to verify
SELECT * FROM recipes;

