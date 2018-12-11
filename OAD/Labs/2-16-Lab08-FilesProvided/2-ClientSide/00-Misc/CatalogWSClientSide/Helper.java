// Requires gson-2.2.4.jar or later

import com.google.gson.Gson;
import java.util.*;
import java.lang.reflect.*;	// Type, etc.
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.google.gson.JsonParser;

public class Helper
{
	public static <T> String getJSON(T obj)
	{
		Gson g = new Gson();
		return g.toJson(obj);
	}

	public static <T> T getObject(String json, Class<T> theClass)
	{
		Gson g = new Gson();
		T obj = g.fromJson(json, theClass);
		return obj;
	}

	public static <T> String getJSONList(List<T> list, Class<T> theClass)
	{
		Gson g = new Gson();

		Type listType = new TypeToken<List<T>>() {}.getType();
		String s = g.toJson(list, listType);
		return s;
	}

 	public static <T> List<T> getObjectList(String json, Class<T> theClass)
 	{
        Gson gson = new Gson();

        //	Split JSON string into a JsonArray of elements
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();

		  // Convert each JSON element into an object and add to the list
        List<T> entityList = new ArrayList<T>();
        for(JsonElement jsonElement: array)
        {
            T entity = gson.fromJson(jsonElement, theClass);
            entityList.add(entity);
        }
        return entityList;
    }

 	/*
 	This method does not work!
 	The return value is actually a list of Maps!
 	*/
 	public static <T> List<T> getObjectListSimple(String json, Class<T> theClass)
 	{
 		Gson g = new Gson();

 		Type listType = new TypeToken<List<T>>() {}.getType();
 		List<T> list = g.fromJson(json, listType);
 		return list;
	}

	public static void main(String [] args) throws Exception
	{
		//	Convert a Product to JSON string
		//
		Product p = new Product("p10", "chair", 10.99, true);
		String s = Helper.getJSON(p);
		System.out.println("product in JSON:\n" + s + "\n");

		//	Convert JSON string to Product
		//
		Product p2 = Helper.getObject(s, Product.class);
		System.out.println("product:\n" + p2 + "\n");

		//	Convert a list of Products to a JSON string
		//
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product("p10", "table", 10.99, false));
		products.add(new Product("p20", "chair", 20.99, true));
		products.add(new Product("p30", "desk", 30.99, false));

		s = Helper.getJSONList(products, Product.class);
		System.out.println("product list in JSON:\n" + s + "\n");

		//	Convert JSON string to list of Products
		//
		List<Product> list2 = Helper.getObjectList(s, Product.class);
		System.out.println("List of Products (list2):\n" + list2 + "\n");

		//	Further verification
		Product pp = list2.get(0);
		pp.setPrice(1000);
		System.out.println(pp + "\n");

		//	The simple method does not work!
		List<Product> list3 = Helper.getObjectListSimple(s, Product.class);
		System.out.println("List of Products (list3):\n" + list3 + "\n");

	}
}
/*
Output:

product in JSON:
{"MISSING_PRICE":-1,"id":"p10","name":"chair","price":10.99,"onSale":true}

product:
Product[id: p10, name: chair, price: 10.99, onSale: true]

product list in JSON:
[{"MISSING_PRICE":-1,"id":"p10","name":"table","price":10.99,"onSale":false
},{"MISSING_PRICE":-1,"id":"p20","name":"chair","price":20.99,"onSale":true
},{"MISSING_PRICE":-1,"id":"p30","name":"desk","price":30.99,"onSale":false
}]

List of Products (list2):
[Product[id: p10, name: table, price: 10.99, onSale: false], Product[id: p2
0, name: chair, price: 20.99, onSale: true], Product[id: p30, name: desk, p
rice: 30.99, onSale: false]]

Product[id: p10, name: table, price: 1000.0, onSale: false]

List of Products (list3):
[{MISSING_PRICE=-1.0, id=p10, name=table, price=10.99, onSale=false}, {MISS
ING_PRICE=-1.0, id=p20, name=chair, price=20.99, onSale=true}, {MISSING_PRI
CE=-1.0, id=p30, name=desk, price=30.99, onSale=false}]

*/

