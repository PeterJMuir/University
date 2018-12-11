import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;	// ImageView

public class ImageLabel extends Application
{
	private int count = 0;

	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		// Define image view
		ImageView imgView = new ImageView("minifoxterrier.jpg");
		imgView.setFitWidth(200);
		imgView.setPreserveRatio(true);

		// Define label
		Label label = new Label("Best Friend", imgView);
		label.setStyle(
			"-fx-content-display: top;" + 	// display image on top of text
			"-fx-border-style:solid;");		//

		// ImageView imgView2 = new ImageView("minifoxterrier.jpg");
		// Button bt = new Button("hello", imgView2);

		// Define tooltip
		label.setTooltip(new Tooltip("This is the tooltip for label"));

		// Register a mouse event handler
		label.setOnMouseEntered( e ->
			{
				System.out.println(">> I am a mini fox terrier.");
			});

		// Add label to pane
		FlowPane pane = new FlowPane(label);
		// FlowPane pane = new FlowPane(label, bt);
		pane.setStyle("-fx-alignment: center;");

		//	Set scene and stage
		Scene scene = new Scene(pane, 400, 300);
		stage.setScene(scene);
	}
}
