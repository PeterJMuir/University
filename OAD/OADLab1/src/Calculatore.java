import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;

public class Calculatore extends Application
{
	Label label = new Label();
	double a,b;
	char op;
	boolean resetLab = false;
	private Button[] butt = new Button[16];
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
		for(int i = 0; i < 10; i++ )
		{
			butt[i] = new Button("" +i);
		}
		butt[10] = new Button("+");
		butt[11] = new Button("-");
		butt[12] = new Button("*");
		butt[13] = new Button("/");
		butt[14] = new Button("=");
		butt[15] = new Button("Clear");
		double a;
		double b;
		for(int i = 0; i < 10; i++)
		{
			final int x= i;
			
			butt[x].setOnAction(e -> 
									{
										if(resetLab)
										{
											resetLab = false;
											label.setText("");
										}
										label.setText(label.getText() + butt[x].getText());
									});
		}
		butt[10].setOnAction(e -> 
		{
			if(resetLab)
			{
				resetLab = false;
				label.setText("");
			}
			label.setText(label.getText() + " " + butt[10].getText() + " ");
		});
		butt[11].setOnAction(e ->
		{
			if(resetLab)
			{
				resetLab = false;
				label.setText("");
			}
			label.setText(label.getText() + " " + butt[11].getText() + " ");
		});
		butt[12].setOnAction(e ->
		{
			if(resetLab)
			{
				resetLab = false;
				label.setText("");
			}
			label.setText(label.getText() + " " + butt[12].getText() + " ");
		});
		butt[13].setOnAction(e ->
		{
			if(resetLab)
			{
				resetLab = false;
				label.setText("");
			}
			label.setText(label.getText() + " " + butt[13].getText() + " ");
		});
		butt[14].setOnAction(e ->
		{
			String[] s = label.getText().split(" ");
			//a = Double.parseDouble(s[0]);
			op = s[1].charAt(0);
			//b = Double.parseDouble(s[2]);
			resetLab = true;
		});
		butt[15].setOnAction(e ->
		{
				label.setText("");
				resetLab = false;
		});
		VBox root =	new	VBox(label);
		for(int i = 0; i < butt.length; i++)root.getChildren().add(butt[i]);
		//root.setStyle("-fx-alignment: center;");
		
		// To add elements:
		// root.getChildren().addAll(element1, element2, )
		
		
		// Set scene and stage
		Scene scene = new Scene(root);
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