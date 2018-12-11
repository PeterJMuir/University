
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.SQLException;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class RecipeWS extends HttpServlet {

    private RecipeDSC DB = new RecipeDSC();
    private DBSettings settings = null;

	//only actualy loads the settings once
	//use getServletContext to get the full qualified path to DBSettings.txt withing the context of this web service
	//open this file using a Buffered Reader
	//get Gson to decode the entire content of this buffered reder into a DBsettings object
	//then load these settings into the database object
	//file not found and JSON encoding errors will be cought here and writen the to responce buffer (ie parameter 'out')
    private int loadDBSettings(PrintWriter out)
    {
        if (settings == null)
        {
            try {
				//use getServletContext to get the full qualified path to DBSettings.txt withing the context of this web service
				//open this file using a Buffered Reader
				//get Gson to decode the entire content of this buffered reder into a DBsettings object
				//then load these settings into the database object
                settings = (new Gson()).fromJson(
						new BufferedReader(new FileReader(
                                getServletContext().getRealPath("/WEB-INF/classes/DBSettings.txt")
                        ))
                        ,DBSettings.class
                );
                DB.load(settings);
            }
            catch (Exception e)
            {
				//file not found and JSON encoding errors will be cought here and sent back to the client 
                out.write("failed to load settings");
                out.write(e.getMessage() + "\n");
                return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
            }
        }
        return 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		//load DB connection setting from a local file
        PrintWriter out = response.getWriter();
		if(loadDBSettings(out) != 0) return;
		try{
			String id = request.getParameter("ID");
			if(null == id)
			{
				List<Recipe> list = DB.findAllRecipes();
				response.setContentType("application/json");
				out.print((new Gson()).toJson(list));
			}else
			{
				int newID = Integer.parseInt(id);
				Recipe r = DB.findRecipe(newID);
				response.setContentType("application/json");
				out.print((new Gson()).toJson(r));
			}
		}catch(Exception exc)
		{
			System.out.println("It no worky");
		}
        //TODO
		//get ID from request
        //if has id get single recipe
        //if not has id get all
        //encode using Gson and place in response
		
		//also handle exceptions and send back somthing meaningfull via the responce 
		//(ie appropriate responce code and error message that can tell your what you need to fix)
        
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        if(loadDBSettings(out) != 0) return;
		//TODO
		//must have valid recipe ID
		//update all recipe
		//get recipe from the DB after adding
		//create new recipe object and send back to client to confirm that the insert was successful and to pass back any generated IDs

		//also handle exceptions and send back somthing meaningfull via the responce 
		//(ie appropriate responce code and error message that can tell your what you need to fix)
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		try
		{
        PrintWriter out = response.getWriter();
        if(loadDBSettings(out) != 0) return;
		String id = request.getParameter("ID");
		if(Integer.parseInt(id) < 0)
		{
			BufferedReader in = request.getReader();
			StringBuffer dataSB = new StringBuffer();
			String line = in.readLine();
			while(line != null)
			{
			dataSB.append(line).append("\n");
			line = in.readLine();
			}
			String data = dataSB.toString();
			System.out.println(">>> data:\n*" + data +"*");
			
			// Convert Json to Product
			Recipe recipe = (new Gson()).fromJson(data, Recipe.class);
			
			int newId = DB.addRecipe(recipe);
			
			response.setContentType("application/json");
			out.print(DB.findRecipe(newId));
		}
		}
		catch(Exception exc)
		{
		}

		//TODO
		//recipe ID must be < 0
        //add recipe to DB
		//get recipe from the DB after adding
		//create new recipe object and send back to client to confirm that the insert was successful and to pass back any generated IDs

		//also handle exceptions and send back somthing meaningfull via the responce 
		//(ie appropriate responce code and error message that can tell your what you need to fix)

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        if(loadDBSettings(out) != 0) return;
		//TODO
        //must have ID
        //get recipe with ID
        //if recipe exists, delete recipe
        //return deleted recipe
        
		//also handle exceptions and send back somthing meaningfull via the responce 
		//(ie appropriate responce code and error message that can tell your what you need to fix)
        
    }
}
