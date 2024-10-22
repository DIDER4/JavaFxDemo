package opgave03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private final TextField txfIndskud = new TextField();
    private final TextField txfRente = new TextField();
    private final TextField txfRenteTilskrivning = new TextField();
    private int Resultat = 0;
    Label lblResultat = new Label("" + Resultat);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Opgave 3 Rentetilskrivning");
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
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblIndskub = new Label("Indskud:");
        pane.add(lblIndskub, 0, 1);
        Label lblRente = new Label("Rente (%):");
        pane.add(lblRente, 0, 2);
        Label lblRenteTilskrivninger = new Label("Antal Rentetilskrivninger:");
        pane.add(lblRenteTilskrivninger, 0, 3);
        Label lblFremtidigVærdi = new Label("Fremtidig Værdi:");
        pane.add(lblFremtidigVærdi, 0, 5);
        pane.add(lblResultat, 1, 5);

        pane.add(txfRente, 1, 2, 2, 1);
        pane.add(txfIndskud, 1, 1, 2, 1);
        pane.add(txfRenteTilskrivning, 1, 3, 3, 1);




        // add a button to the pane (at col=1, row=1)
        Button btnBeregn = new Button("Beregn");
        pane.add(btnBeregn, 1, 4);
        GridPane.setMargin(btnBeregn, new Insets(10, 10, 10, 10));
        btnBeregn.setOnAction(event -> this.beregn());

    }
    private void beregn(){
        double indskud = Double.parseDouble(txfIndskud.getText());
        double rente = 1 + Double.parseDouble(txfRente.getText()) / 100;
        double RenteTilskrivning = Double.parseDouble(txfRenteTilskrivning.getText());
        double nyVærdi = indskud * Math.pow(rente,RenteTilskrivning);
        lblResultat.setText(String.valueOf(nyVærdi));

    }

}
