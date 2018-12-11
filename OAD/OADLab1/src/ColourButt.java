import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class ColourButt extends Application
{
	private Button colourbutt = new Button("CLICK ME FOR LOVE");
	/*public static void main(String[] args)
	{
		Application.launch();
	}*/
	public void	start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}
	public void	build(Stage stage)
	{
		// Define controls and layout
		//ActionEventHandler handler = new ActionEventHandler(colourbutt);
		colourbutt.setOnAction((e) ->
				{
							colourbutt.setStyle("-fx-underline: true; -fx-font-size: 36; -fx-text-fill: rgb("
									+ Math.random()*255 + "," + Math.random()*255 + "," + Math.random()*255 + ");");
				});
		VBox root =	new	VBox(colourbutt);
		root.setStyle("-fx-alignment: center;");
		
		// To add elements:
		// root.getChildren().addAll(element1, element2, )
		
		
		// Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
	
	/*private class ColourButtHandle implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			colourbutt.setStyle("-fx-underline: true; -fx-font-size: 36; -fx-text-fill: rgb("
					+ Math.random()*255 + "," + Math.random()*255 + "," + Math.random()*255 + ");");
		}
	}*/
}