/* 
*	Name: Peter Muir
*	Student ID: 18477719
 */
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
     
        
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        if(loadDBSettings(out) != 0) return;
		try
		{
		String id = request.getParameter("ID");
		int idnum = Integer.parseInt(id);
		Recipe rec = DB.findRecipe(idnum);
		if(rec != null)
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
			
			// Convert Json to Recipe
			Recipe recipe = (new Gson()).fromJson(data, Recipe.class);
			
			DB.updateRecipe(recipe);
			
			response.setContentType("application/json");
			
			out.print(new Gson().toJson(DB.findRecipe(idnum)));
		}
		}
		catch(Exception exc)
		{
			out.println(exc.getMessage());
		}
		
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		
        PrintWriter out = response.getWriter();
        if(loadDBSettings(out) != 0) return;
		try
		{
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
			
			// Convert Json to Recipe
			Recipe recipe = (new Gson()).fromJson(data, Recipe.class);
			
			int newId = DB.addRecipe(recipe);
			
			response.setContentType("application/json");
			
			out.print(new Gson().toJson(DB.findRecipe(newId)));
		}
		}
		catch(Exception exc)
		{
			out.println(exc.getMessage());
		}

		

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        if(loadDBSettings(out) != 0) return;
		try
		{
			String id = request.getParameter("ID");
			int idnum = Integer.parseInt(id);
			Recipe rec = DB.findRecipe(idnum);
			if(rec != null)
			{
				DB.deleteRecipe(idnum);
			}
		}catch(Exception exc)
		{
			out.println(exc.toString());
		}
		
        
    }
}
