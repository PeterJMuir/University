package sample;

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

public class CreateTableView extends Application
{
	// Data source controller
	 MusicCatalogDS catalog = new MusicCatalogDS();

	public void start(Stage stage) throws Exception
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage) throws Exception
	{

		// =============================================
		// Define the table data and table view
		// =============================================

		// Create table data (an observable list of objects)
		//
		ObservableList<MusicAlbum> tableData= FXCollections.observableArrayList();

		// Define table columns
		//
		TableColumn<MusicAlbum, String> idColumn =
							new TableColumn<MusicAlbum, String>("Id");
		idColumn.setCellValueFactory(
							new PropertyValueFactory<MusicAlbum, String>("Id"));
							// required to get instructions to display the cells
							// comment out and see effect

		TableColumn<MusicAlbum, String> nameColumn =
							new TableColumn<MusicAlbum, String>("Name");
		nameColumn.setCellValueFactory(
							new PropertyValueFactory<MusicAlbum, String>("Name"));

		TableColumn<MusicAlbum, String> genreColumn =
							new TableColumn<MusicAlbum, String>("Genre");
		genreColumn.setCellValueFactory(
							new PropertyValueFactory<MusicAlbum, String>("Genre"));

		TableColumn<MusicAlbum, Boolean> isCompilationColumn =
							new TableColumn<MusicAlbum, Boolean>("IsCompilation");
		isCompilationColumn.setCellValueFactory(
							new PropertyValueFactory<MusicAlbum, Boolean>("IsCompilation"));

		TableColumn<MusicAlbum, Integer> trackCountColumn =
				new TableColumn<MusicAlbum, Integer>("TrackCount");
		trackCountColumn.setCellValueFactory(
				new PropertyValueFactory<MusicAlbum, Integer>("TrackCount"));


		// Create the table view and add table columns to it
		TableView<MusicAlbum> tableView = new TableView<MusicAlbum>();

		tableView.getColumns().add(idColumn);
		tableView.getColumns().add(nameColumn);
		tableView.getColumns().add(genreColumn);
		tableView.getColumns().add(isCompilationColumn);
		tableView.getColumns().add(trackCountColumn);
						// Comment out a statement and see effect

		//	Set the table data to be the table view's items
		//
		tableView.setItems(tableData);


		// Can control the display of the table view
		idColumn.setMinWidth(150);
		nameColumn.setMinWidth(150);
		genreColumn.setMinWidth(150);
		isCompilationColumn.setMinWidth(150);
		trackCountColumn.setMinWidth(150);


		// =================================
		// Put some data into the table data
		// =================================
		tableData.add(new MusicAlbum("A01", "Defiance", "Soundtrack", true,24));
		tableData.add(new MusicAlbum("A02", "Insomniac", "Punk Rock", false,14));
		tableData.add(new MusicAlbum("A03", "Artificial Existence", "Punk Rock", false,10));
		/*tableData.add(new MusicAlbum("p20", "chair", 20.0, true));
		tableData.add(new MusicAlbum("p30", "desk", 30.0, false));
		tableData.add(new MusicAlbum("p40", "bookcase", 40.0, true));*/

		System.out.println("\nLOAD DATA (quick demo)\n" + tableData);

		Button sortBT = new Button("Sort Rows by Genre (ascending) and Name (ascending)");
		sortBT.setOnAction((e) ->
		{
			genreColumn.setSortType(TableColumn.SortType.ASCENDING);
			nameColumn.setSortType(TableColumn.SortType.ASCENDING);
			tableView.getSortOrder().clear();
			tableView.getSortOrder().add(genreColumn);
			tableView.getSortOrder().add(nameColumn);
		});

		Label filterLb = new Label("Filter:");
		TextField filterTF = new TextField();
		HBox filterBox = new HBox(filterLb,filterTF);

		FilteredList<MusicAlbum> filteredList =
				new FilteredList<>(tableData, p -> true);
		SortedList<MusicAlbum> sortedList = new SortedList<MusicAlbum>(filteredList);
		sortedList.comparatorProperty().bind(tableView.comparatorProperty());

		tableView.setItems(sortedList);

		filterTF.textProperty().addListener((observable, oldValue, newValue) ->
		{
			filteredList.setPredicate(musicAlbum ->
			{
				if(newValue == null || newValue.isEmpty())
				{
					return true;
				}
				String filterString = newValue.toUpperCase();
				if(musicAlbum.getName().toUpperCase().contains(filterString))
				{
					return true;
				}else
				{
					return false;
				}
			});
		});


		// Create scene and set stage
		VBox root = new VBox(filterBox, tableView, sortBT);
		root.setStyle(" -fx-font-size: 30");
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
}