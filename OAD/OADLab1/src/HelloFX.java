import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class HelloFX extends Application
{
	
	public void	start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}
	public void	build(Stage stage)
	{
		Label label = new Label("Hello JavaFX");
		label.setStyle("-fx-text-fill: red;"
				+ "		-fx-font-size: 36; -fx-font-style: italic;"
				+ "		-fx-font-weight: 900; -fx-underline: true;");
		// Define controls and layout
		VBox root =	new	VBox(label);
		root.setStyle("-fx-alignment: center;");
		
		// To add elements:
		// root.getChildren().addAll(element1, element2, )
		
		
		// Set scene and stage
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}