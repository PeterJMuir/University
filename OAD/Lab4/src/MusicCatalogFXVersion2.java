import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import static javafx.application.Application.launch;


public class MusicCatalogFXVersion2 extends Application {
    // Data source controller
    MusicCatalogDS catalog = new MusicCatalogDS();
    ObservableList<MusicAlbum> tableData= FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }


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
        catalog.add(new MusicAlbum("A01", "Defiance", "Soundtrack", true,24));
        catalog.add(new MusicAlbum("A02", "Insomniac", "Punk Rock", false,14));
        catalog.add(new MusicAlbum("A03", "Artificial Existence", "Punk Rock", false,10));

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
        Button addBT = new Button("Add Album");
        Button deleteBT = new Button("Delete Selected Album");

        FlowPane fp = new FlowPane(sortBT,addBT,deleteBT);
        // Create scene and set stage
        VBox root = new VBox(filterBox, tableView, fp);
        root.setStyle("-fx-alignment: center; -fx-font-size: 30; -fx-spacing:10");
        Scene scene = new Scene(root);
        stage.setScene(scene);

        addBT.setOnAction(e -> addAlbum());
    }

    private void addAlbum(){
        try {
            int newIDInt = tableData.size();
            String newID = "A" + (newIDInt/10)%10 + newIDInt%10;
            System.out.println(newID);
            boolean pre = true;
            System.out.println(catalog.getAll());
            while(pre){
                if(null == catalog.get(newID)) {
                    pre = false;
                }else {
                    newIDInt++;
                    newID = "A" + newIDInt/10 + newIDInt%10;
                }
            }
            Label idLb = new Label("ID: " + newID);
            idLb.setStyle("-fx-font: 20 arial");
            Label nameLb = new Label("Name:");
            Label genreLb = new Label("Genre:");
            TextField genreTF = new TextField();
            TextField nameTF = new TextField();

            Label compLb = new Label("Compilation?");
            CheckBox compCheck = new CheckBox();

            Label tcLb = new Label("Track Count:");
            Spinner tcSpin = new Spinner((int) 1, (int) 60, (int) 1);
            tcSpin.getValueFactory().setValue(1);

            Button yesBT = new Button("OK");
            Button noBT = new Button("Cancel");

            HBox nameBox = new HBox();
            nameBox.getChildren().addAll(nameLb, nameTF);

            HBox genreBox = new HBox();
            genreBox.getChildren().addAll(genreLb, genreTF);

            HBox compBox = new HBox();
            compBox.getChildren().addAll(compCheck, compLb);

            HBox tcBox = new HBox();
            tcBox.getChildren().addAll(tcLb, tcSpin);

            HBox buttBox = new HBox();
            buttBox.getChildren().addAll(yesBT,noBT);

            VBox cont = new VBox();
            cont.getChildren().addAll(idLb,nameBox, genreBox, compBox, tcBox, buttBox);
            Scene scene = new Scene(cont);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Add Album");
            final String newestID = newID;
            yesBT.setOnAction(e -> {
                try {
                    System.out.println(newestID);
                    MusicAlbum temp = new MusicAlbum(newestID, nameTF.getText(), genreTF.getText(), compCheck.isSelected(),(int) tcSpin.getValueFactory().getValue());
                    tableData.add(temp);

                    catalog.add(temp);
                    stage.close();
                    System.out.println("ALBUM ADDED: \n" + temp.toString());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            noBT.setOnAction(e -> {
                stage.close();
                System.out.println("ALBUM NOT ADDED");
            });


            stage.show();
        }
        catch(Exception exception){
            System.out.println(exception);
        }
    }
}
