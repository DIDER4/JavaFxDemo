package opgave05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    Label lblName = new Label("Name");
    private final TextField txfName = new TextField();
    private final TextArea resultat = new TextArea();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 4 Grader");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setMinHeight(200);
        stage.setMinWidth(300);
        stage.show();

    }
    private void initContent(GridPane pane) {
        // enable this to show grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(0);
        // set vertical gap between components
        pane.setVgap(0);

        // add a label to the pane (at col=0, row=0)
        pane.add(lblName, 0, 0);
        pane.add(txfName, 0, 1, 3, 1);
        pane.add(resultat, 0, 4);
        resultat.setPrefRowCount(6);
        resultat.setPrefWidth(200);
        resultat.setEditable(false);


        // add a button to the pane (at col=1, row=1)
        Button btnTilføj = new Button("Tilføj Navn");
        pane.add(btnTilføj, 0, 3);
        GridPane.setMargin(btnTilføj, new Insets(10, 10, 10, 0));
        btnTilføj.setOnAction(event -> this.fill());

    }
    private void fill(){
        resultat.setText(this.tilføj());
    }
    private String tilføj (){
        String resultat = txfName.getText();
        return resultat.toString();
    }
}
