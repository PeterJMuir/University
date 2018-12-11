import javafx.event.*;
import javafx.scene.control.*;

public class ActionEventHandler implements EventHandler<ActionEvent>
{
	private Button colourButt;
	
	public ActionEventHandler(Button colourButt)
	{
		this.colourButt = colourButt;
	}
	@Override
	public void handle(ActionEvent e)
	{
		colourButt.setStyle("-fx-underline: true; -fx-font-size: 36; -fx-text-fill: rgb("
							+ Math.random()*255 + "," + Math.random()*255 + "," + Math.random()*255 + ");");
	}
}