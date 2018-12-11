import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.*;
import java.io.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.scene.control.cell.*;
import javafx.beans.property.*;

public class CreateObservableList extends Application
{
	public void start(Stage stage) throws Exception
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage) throws Exception
	{
		ObservableList<Product> list1 = FXCollections.observableArrayList();
		list1.addAll(
			new Product("P60", "table", 10.10, true),
			new Product("P10", "table", 10.10, true),
			new Product("P20", "table", 10.10, true));

		ArrayList<Product> list2 = new ArrayList<Product>();
		list2.add(new Product("P60", "table", 10.10, true));
		list2.add(new Product("P10", "table", 10.10, true));
		list2.add(new Product("P20", "table", 10.10, true));

		ObservableList<Product> list3 = FXCollections.observableArrayList(list2);

		VBox root = new VBox();
		Scene scene = new Scene(root, 400, 300);
		stage.setScene(scene);
	}
}