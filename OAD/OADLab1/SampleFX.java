import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SampleFX extends Application
{
	public void	start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}
	public void	build(Stage stage)
	{
		// Define controls and layout
		VBox root =	new	VBox();
		
		// To add elements:
		// root.getChildren().addAll(element1, element2, )
		
		
		// Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}