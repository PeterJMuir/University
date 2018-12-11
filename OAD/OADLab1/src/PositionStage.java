import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PositionStage extends Application
{
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
		VBox root =	new	VBox();
		
		// To add elements:
		// root.getChildren().addAll(element1, element2, )
		
		
		// Set scene and stage
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		stage.setWidth(width/2);
		stage.setHeight(height/2);
		stage.setX(width/4);
		stage.setY(height/4);
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}