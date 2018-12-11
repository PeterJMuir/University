import java.io.*;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Texty extends Application
{
	private PrintWriter inWrite;
	Scanner inRead;
	Label label;
	FileWriter outFile;
	String textTest = "";
	
	TextField appendTF = new TextField();
	File readFile = new File("Test.txt");
	public static void main(String[] args)
	{
		Application.launch();
	}
	
	public void	start(Stage stage) throws IOException
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}
	public void	build(Stage stage) throws IOException
	{
		
		outFile = new FileWriter("Test.txt",true);
		
		try{
		inRead = new Scanner(readFile);
		while(inRead.hasNext())
		{
			textTest.concat(inRead.next());
		}
			inRead.close();
			}catch(Exception e1)
			{	System.out.println("BAD");}
		label = new Label(textTest);
		// Define controls and layout
		
		
		Button appendButt = new Button("Append");
		appendButt.setOnAction((e) ->
		{
			inWrite = new PrintWriter(outFile,true);
			inWrite.println(appendTF.getText());
			try{
			inWrite.close();
			inRead = new Scanner(readFile);
			while(inRead.hasNext())
			{
				textTest.concat(inRead.next());
			}
			inRead.close();
			}catch(Exception e1)
			{	System.out.println("BAD");}
			label.setText(textTest);
			System.out.println(textTest);
		});
		VBox root =	new	VBox(appendTF, appendButt,label);
		root.setStyle("-fx-alignment: center;");
		// To add elements:
		// root.getChildren().addAll(element1, element2, )
		
		
		// Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
	@Override
	public void stop()
	{
		try{
		inWrite.close();
		inRead.close();
		}catch(Exception e)
		{}
	}
}