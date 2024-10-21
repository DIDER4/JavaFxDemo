package opgave01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private final TextField txfFornavn = new TextField();
    private final TextField txfEfternavn = new TextField();
    private final TextField txfFuldenavn = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kombiner navne");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }
    private void initContent(GridPane pane) {
        // enable this to show grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label fornavn = new Label("Fornavn:");
        pane.add(fornavn, 0, 0);
        Label efternavn = new Label("Efternavn:");
        pane.add(efternavn, 2, 0);
        Label fuldeNavn = new Label("Fulde navn:");
        pane.add(fuldeNavn, 0, 3);

        // add a text field to the pane
        // TextField txfName = new TextField();
        pane.add(txfFornavn, 0, 1, 2, 1);
        pane.add(txfEfternavn, 2, 1, 2, 1);
        pane.add(txfFuldenavn, 0, 4, 3, 1);


        // add a button to the pane (at col=1, row=1)
        Button kombiner = new Button("Kombiner");
        pane.add(kombiner, 0, 5);
        GridPane.setMargin(kombiner, new Insets(10, 10, 0, 0));

        kombiner.setOnAction(event -> this.kombinerAction());

    }
    private void kombinerAction(){
        String fuldenavn = txfFornavn.getText() + " " + txfEfternavn.getText();
        txfFuldenavn.setText(fuldenavn);
    }
}
