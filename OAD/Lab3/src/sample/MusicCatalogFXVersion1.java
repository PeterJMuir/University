package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MusicCatalogFXVersion1 extends Application {
    private MusicCatalogDS catalog = new MusicCatalogDS();
    private TextArea displayTA = new TextArea();
    private TextField idTF = new TextField();
    private TextField nameTF = new TextField();
    private TextField genreTF = new TextField();
    private TextField isCompTF = new TextField();
    private TextField tcTF = new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        build(primaryStage);
        primaryStage.setTitle(getClass().getName());
        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Thread.currentThread().setUncaughtExceptionHandler((thread, exception) ->
        {
            System.out.println("ERROR: " + exception);
        });
    }

    public void build(Stage stage){
        displayTA.setMinWidth(200);
        displayTA.setMinHeight(200);

        Label idLB = new Label("ID: ");
        idTF = new TextField();
        HBox idHBox = new HBox();
        idHBox.getChildren().addAll(idLB,idTF);

        Label nameLB = new Label("Name: ");
        nameTF = new TextField();
        HBox nameHBox = new HBox();
        nameHBox.getChildren().addAll(nameLB,nameTF);

        Label genreLB = new Label("Genre: ");
        genreTF = new TextField();
        HBox genreHBox = new HBox();
        genreHBox.getChildren().addAll(genreLB,genreTF);

        Label isCompLB = new Label("Is Compilation: ");
        isCompTF = new TextField();
        HBox isCompHBox = new HBox();
        isCompHBox.getChildren().addAll(isCompLB,isCompTF);

        Label tcLB = new Label("TrackCount: ");
        tcTF = new TextField();
        HBox tcHBox = new HBox();
        tcHBox.getChildren().addAll(tcLB,tcTF);

        Button loadDataButt = new Button("Load Data");
        Button displayAlbumsButt = new Button("Display Albums");
        Button searchAlbumButt = new Button("Search Album");
        Button addAlbumButt = new Button("Add Album");
        Button removeAlbumButt = new Button("Remove Album");
        Button saveDataButt = new Button("Save Data");
        FlowPane buttPane = new FlowPane();
        buttPane.getChildren().addAll(loadDataButt,displayAlbumsButt,
                searchAlbumButt,addAlbumButt,removeAlbumButt,saveDataButt);

        VBox root = new VBox();
        root.getChildren().addAll(displayTA, idHBox,nameHBox,genreHBox,isCompHBox,tcHBox,buttPane);
        root.setStyle("-fx-alignment: center; -fx-font-size: 20; -fx-spacing:10");
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);

        loadDataButt.setOnAction(e -> loadData());
        displayAlbumsButt.setOnAction(e -> displayAlbums());
        searchAlbumButt.setOnAction(e -> searchAlbums());
        addAlbumButt.setOnAction(e -> addAlbum());
        removeAlbumButt.setOnAction(e -> removeAlbum());
        saveDataButt.setOnAction(e -> saveData());

    }
    private void loadData(){
        try{
            catalog.loadData("MusicCatalog.dat");
        }
        catch(Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
        System.out.println("LOAD DATA:\n" + catalog);	// print out to verify

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Data has been successfully loaded.");
        alert.showAndWait();
    }
    private void displayAlbums(){
        String result = catalog.toString();	// effectively get all products
        displayTA.setText(result);
        /*TextArea root = new TextArea(result);
        root.setStyle("-fx-font: 20 arial");
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();*/
    }
    private void searchAlbums(){
        MusicAlbum des = catalog.get(idTF.getText());
        if(des == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Could not find album with ID: \"" + idTF.getText() +"\".");
            alert.showAndWait();
        }else{
            displayTA.setText(des.toString());
            idTF.setText(des.getId());
            nameTF.setText(des.getName());
            genreTF.setText(des.getGenre());
            isCompTF.setText(des.isCompilation()?"true":"false");
            tcTF.setText(String.format("%d",des.getTrackCount()));
        }
    }
    private void addAlbum(){
        try {
            MusicAlbum temp = new MusicAlbum(idTF.getText(), nameTF.getText(), genreTF.getText(), isCompTF.getText().equalsIgnoreCase("true"), Integer.parseInt(tcTF.getText()));

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to add this album?\n\"" + temp.toString() + "\"",ButtonType.YES,ButtonType.NO);
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.YES)){
                catalog.add(temp);
                System.out.println("ALBUM ADDED: \n" + temp.toString());
            }else{
                System.out.println("ALBUM NOT ADDED");
            }
        /*Label root = new Label("Are you sure you want to add this album?\n" + temp.toString());
        root.setStyle("-fx-font: 20 arial");
        Button yesbt = new Button("Yes");
        Button nobt = new Button("No");
        HBox choiceBox = new HBox();
        choiceBox.getChildren().addAll(yesbt,nobt);
        VBox cont = new VBox();
        cont.getChildren().addAll(root,choiceBox);
        Scene scene = new Scene(cont);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
        yesbt.setOnAction(e -> {
            try {
                catalog.add(temp);
                stage.close();
                System.out.println("ALBUM ADDED: \n" + temp.toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        nobt.setOnAction(e -> {
            stage.close();
            System.out.println("ALBUM NOT ADDED");
        });


        stage.show();*/
        }
        catch(Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
    private void removeAlbum(){
        String id = idTF.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove this album?\n\"" + id + "\"",ButtonType.YES,ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult().equals(ButtonType.YES)){
            MusicAlbum rm = catalog.remove(id);
            System.out.println("ALBUM REMOVED: \n" + rm.toString());
        }else{
            System.out.println("ALBUM NOT REMOVED");
        }
    }
    private void saveData(){
        try{
            catalog.saveData("savedAlbums.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Data has been successfully saved.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
